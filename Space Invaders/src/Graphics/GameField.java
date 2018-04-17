/**
 * <h1>GameField</h1>
 * Klassen GameField ritar ut alla grafiska objekt på skärmen genom metoden paintComponent. Den använder
 * ObjectMap som parameter och objekten själva bestämmer var och hur dom ska ritas ut. 
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */


package Graphics;

import Logics.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Image;

public class GameField extends JComponent{
	
	private ObjectMap model; 
	private BorderLayout layout = new BorderLayout();
	private GameEngine engine;

	public GameEngine getEngine() {
		return engine;
	}

	public void setEngine(GameEngine engine) {
		this.engine = engine;
	}

	Coordinate c = new Coordinate (400, 400);
	private Healthbar pHealth = new Healthbar();
	
	private Image backImage = ImageHandler.getImage("src/images/map1.png");
	
	public GameField(final ObjectMap model, Image backImage) {		
		this.backImage = backImage;
		System.out.println("Spelfält skapas...");
		setLayout(layout);
		setFocusable(true);
		this.model = model;
		this.engine = new GameEngine(model, this);
		this.add(engine);
		engine.startGame();
	}
	
	public void addProjectile(Coordinate c){
		Projectile p = new Projectile(c.getX(), c.getY());
		model.addProjectile(p);
		
	}
	public void addEnemyProjectile(Coordinate c){
		EnemyProjectile p = new EnemyProjectile(c.getX(), c.getY());
		model.addProjectile(p);
		
	}
	public void paintComponent(Graphics g) {
		g.drawImage(backImage, 0, 0, null);
		if (!engine.isRunning())
			printGameOver(g);
		pHealth.paintYourself(g, model.getPlayer());
		printHighscore(g);
		
		if (!model.getAllExplosions().isEmpty())
			System.out.println(model.getAllExplosions().get(0).getCurrentIndex());
		for (GameObject go : model.getAllObjects()) {
			go.paintYourself(g);
			if (go.getHealthBar()!=null) {
				go.getHealthBar().paintYourself(g, go);
			}
		}
	}
	
  public void printGameOver(Graphics g) {
	  System.out.println("Printing game over...");
	  g.setFont((new Font("Verdana", 400, 100)));
	  g.setColor(Color.RED);
	  g.drawString("GAME OVER", 100, 300);
	//  repaint();
  }
  
  public void printHighscore(Graphics g) {
	  g.setColor(Color.RED);
	  g.setFont(new Font ("Verdana", 100, 30));
	  g.drawString("SCORE: " + model.getPlayer().getCurrentScore(), 20, 50);
  }
}
