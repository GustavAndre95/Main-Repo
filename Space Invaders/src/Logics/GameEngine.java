/**
 * <h1>GameEngine</h1>
 * Klassen GameEngine utgör själva "speelloopen". Den ansvarar också för grundläggande spellogik,
 * inputs från användaren och sparandet av highscore när spelaren dör.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Logics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

import javax.swing.JComponent;
import javax.swing.Timer;

import Graphics.GameField;
import Graphics.GameObject;
import Graphics.HardEnemy;
import Graphics.Player;
import Graphics.Enemy;
import Logics.Coordinate;

public class GameEngine extends JComponent implements Runnable {
	private boolean running;
	private boolean saving = false;
	public boolean isRunning() {
		return running;
	}

	private int ENEMY_SPAWNTIME = 2500;
	private boolean spawnEnemies = true;
	private boolean spawnPowerUps = true;
	private boolean allowFire = false;
	private int lastPlayerScore = 0;
	private ObjectMap model;
	private GameField gamefield;
	private CollisionManager cm = new CollisionManager();
	
	public GameEngine(ObjectMap model, GameField gamefield){
		running = true;
		this.model = model;
		this.gamefield = gamefield;
	}
	
	
	@Override
	public void run() {

		long lastLoopTime = System.nanoTime();
	    final int TARGET_FPS = 30;
	    final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
	    long lastFpsTime = 0;
	    
	    //Implementerar lyssnare...
	    addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode()==32) {
					allowFire = true;						
				}
					model.getPlayer().move(e.getKeyCode());
			}

			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == 37 || e.getKeyCode() == 39) {
					model.getPlayer().setSpeed(0);
				}
				if (e.getKeyCode() == 32)
					allowFire = false;
			}
		});
		
		while (running){
			//Updating game logics
			updateDifficulty();
			this.requestFocusInWindow();
			if (model.getPlayer().getHp() < 1) {
				SoundManager.playASound("src/sounds/no_no_no.wav", false);
				stopGame();
			}
			
			if (allowFire){				
				Coordinate c = model.getPlayer().fire();	
				if (c != null)
					gamefield.addProjectile(c);
			}	
			spawnPowerUps();
			spawnEnemies();
			
			for (Enemy e : model.getAllEnemies()) {
				Coordinate c = e.fire();
				if (c != null)
					gamefield.addEnemyProjectile(c);
			}	
			cm.handleAllCollisions(model, gamefield);

			for (GameObject go : model.getAllObjects()) {
				if (go instanceof HardEnemy)
					((HardEnemy)go).updatePosition(model.getPlayer().getxPos());
				else
					go.updatePosition();
				
			}
			//Updating GUI
			gamefield.repaint();
			//Loop mechanics
			long now = System.nanoTime();
	        long updateLength = now - lastLoopTime;
	        lastLoopTime = now;
	        
	        lastFpsTime += updateLength;
	        if(lastFpsTime >= 1000000000){
	            lastFpsTime = 0;
	        }
	        
			try{
				long gameTime = (lastLoopTime - System.nanoTime() + OPTIMAL_TIME) / 1000000;
	            Thread.sleep(gameTime);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			}
			
		}
	
	
	public void startGame(){
		model.setPlayer(new Player());
		Thread thread = new Thread(this);
		thread.start();
		SoundManager.playASound("src/sounds/I_am_the_senate.wav", false);
	}
	
	public void spawnEnemies(){
		if (!spawnEnemies)
			return;
		if (spawnEnemies){
			spawnEnemies = false;
			model.addEnemy();
			
			Timer timer = new Timer(ENEMY_SPAWNTIME, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					spawnEnemies = true;
				}
			});
			timer.setRepeats(false);
			timer.start();
		}
			
			
	}
	public void stopGame() {
		running = false;
		try {
			saveHighScore();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void updateDifficulty(){
		if (model.getPlayer().getCurrentScore() > lastPlayerScore + 200 && ENEMY_SPAWNTIME > 1300) {
			lastPlayerScore = model.getPlayer().getCurrentScore();
			ENEMY_SPAWNTIME -= 100;
			
		}
	}
	
	public void spawnPowerUps() {
		
		if (!spawnPowerUps||model.getPlayer().getReloadTime() < 300)
			return;
		if (spawnPowerUps){
			spawnPowerUps = false;
			if (Math.random() < 0.5)
				model.addPowerUp();
			
			Timer timer = new Timer(10000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					spawnPowerUps = true;
				}
			});
			timer.setRepeats(false);
			timer.start();
		}
		
	}
	
	public void saveHighScore() throws ClassNotFoundException {
		if (saving)
			return;
		saving = true;
		System.out.println("Sparar highscores...");
		try {	
			FileInputStream fis = new FileInputStream("src/highscores.ser");
			ObjectInputStream ois = new ObjectInputStream(fis);
			HighScoreHolder hsh = (HighScoreHolder) ois.readObject();
			ois.close();
			
			hsh.addScore(model.getPlayer().getCurrentScore());
			Collections.sort(hsh.getScores(), Collections.reverseOrder());
			
			FileOutputStream fos = new FileOutputStream("src/highscores.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(hsh);
			oos.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}
	
}		


		

	


