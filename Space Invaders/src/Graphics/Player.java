/**
 * <h1>Player</h1>
 * Klassen Player är ett grafiskt objekt som representerar spelaren på skärmen. Spelaren kan skjuta och
 * röra sig i sidled. Själva metoden för att hantera inputs från tangentbordet ligger inte här,
 * utan i GameEngine.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.sound.sampled.Clip;
import javax.swing.Timer;
import com.sun.prism.Image;

import Logics.Coordinate;
import Logics.SoundManager;

public class Player extends GameObject{
	
	private boolean reloading = false;
	private static final int MOVEMENT_SPEED = 16;
	private int reloadTime = 300;
	
	public int getReloadTime() {
		return reloadTime;
	}

	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}

	private BufferedImage projImage = ImageHandler.getImage("src/images/projectile_red.png");
	private BufferedImage currentImage = ImageHandler.getImage("src/images/playership.png");
	private int currentScore = 0;
	
	public Player(){
		super.setImage(currentImage);
		super.setxPos(300);
		super.setyPos(500);
		super.setSpeed(0);
		super.setHp(5);
		super.setMaxHp(getHp());
	}
	
	public Coordinate fire() {
		if (reloading)
			return null;
		
		Coordinate c = new Coordinate(0,0);
		c.setX(super.getxPos() + super.getImage().getWidth(null) 
								- currentImage.getWidth() / 2);
		c.setY(super.getyPos());
		
	   SoundManager.playASound("src/sounds/laser.wav", false);
	  
		reloading = true;
		
		Timer timer = new Timer(reloadTime, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reloading = false;
			}
		});
		timer.setRepeats(false);
		timer.start();
			
		return c;
	}


	
	public void updatePosition(){
		if (getxPos() + getSpeed() >=0
				&& getxPos() + getSpeed() + projImage.getWidth() <= 730) {
			setxPos(getxPos() + getSpeed());
		}
		
	}
	
	public void move (int input){
			if (input == 37 && getxPos() > 0) {
				setSpeed(-MOVEMENT_SPEED);
			}
			if (input == 39 && getxPos() < 750) {
				setSpeed(MOVEMENT_SPEED);
			}
	}

	public int getCurrentScore() {
		return currentScore;
	}

	public void setCurrentScore(int currentScore) {
		this.currentScore = currentScore;
	}



}
