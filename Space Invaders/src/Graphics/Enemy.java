
/**
 * <h1>Enemy</h1>
 * Klassen Enemy är ett grafiskt objekt som representerar de "lätta" fienderna i spelet. En enemy
 * kan skjuta projektiler och rör sig konstant nedåt på skärmen. 
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Logics.Coordinate;

public class Enemy extends GameObject{

	private int speed = 2;
	private boolean reloading = false;
	public boolean isReloading() {
		return reloading;
	}
	
	public void updatePosition (int tValue){
		setyPos(getyPos() + getSpeed());
	//	followPlayer(tValue);

}

	public void setReloading(boolean reloading) {
		this.reloading = reloading;
	}

	private int reloadSpeed;
	private boolean toBeRemoved = false;
	public int getReloadSpeed() {
		return reloadSpeed;
	}

	public void setReloadSpeed(int reloadSpeed) {
		this.reloadSpeed = reloadSpeed;
	}

	public Enemy(){
			setMaxHp(2);
			setHp(getMaxHp());
		 	super.setImage(ImageHandler.getImage("src/images/Enemyeasy.png"));
		 	super.setxPos((int)(Math.random()* 750));
		 	super.setyPos(0);	
		 	super.setSpeed(speed);
		 	setReloadSpeed(1500);
		 			 	
	}	
	
	public Coordinate fire() {
		if (reloading)
			return null;
		
		Coordinate c = new Coordinate(0,0);
		c.setX(super.getxPos() + super.getImage().getWidth(null) 
								- getImage().getWidth(null) / 2);
		c.setY(super.getyPos() + 40);
		
		reloading = true;
		
		Timer timer = new Timer(reloadSpeed, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				reloading = false;
			}
		});
		timer.setRepeats(false);
		timer.start();
			
		return c;
	}

	
	public int getSpeed() {
		return speed;
	}
	
	public void setSpeed(int val) {
		speed = val;
	}

	public boolean isToBeRemoved() {
		return toBeRemoved;
	}

	public void setToBeRemoved(boolean toBeRemoved) {
		this.toBeRemoved = toBeRemoved;
	}

}
