/**
 * <h1>GameObject</h1>
 * Klassen CollisionControl �r superklass f�r alla grafiska objekt p� sk�rmen. Vaje objekt har en position,
 * en bild, en healthbar och hp. Detta underl�ttar d� samtliga grafiska objekt �rver dessa egenskaper,
 * och kan ritas ut p� ungef�r samma s�tt.
 * 
 * @author Gustav Andr� 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.Graphics;
import java.awt.Image;

import Logics.Coordinate;

public abstract class GameObject {
	
	private int xPos, yPos, speed = 0;
	private Image image;
	private int hp;
	private int MaxHp;
	private Healthbar healthBar;
	
	public void paintYourself(Graphics g) {
		g.drawImage(image, xPos, yPos, null);
		
	}
	
	public void setImage(Image image) {
		this.image = image;
	}

	public int getxPos() {
		return xPos;
	}

	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Image getImage() {
		return image;
	}
	
	public void updatePosition (){
		yPos = yPos + speed;
		
	}
	
	public boolean isInYBounds (GameField gf){
		if ( yPos + image.getHeight(null) < 0 || yPos > gf.getHeight() - image.getHeight(null)) {
			return false;
		}
		return true;
		
	}
	
	public boolean isInXBounds (GameField gf){
		if ( xPos < 0 || xPos > gf.getWidth() - image.getWidth(null)) {
			return false;
		}
		return true;
		
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return MaxHp;
	}

	public void setMaxHp(int maxHp) {
		MaxHp = maxHp;
	}

	public Healthbar getHealthBar() {
		return healthBar;
	}

	public void setHealthBar(Healthbar healthBar) {
		this.healthBar = healthBar;
	}
	

	

}
