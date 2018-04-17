/**
 * <h1>PowerUp</h1>
 * Klassen PowerUp är en abstrakt klass som styr grundläggande logik för alla powerups.
 * 
 * @author Gustav André 
 * @since 2017-03-08
 */

package Graphics;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Logics.EventTrigger;
import Logics.ObjectMap;

public abstract class PowerUp extends GameObject{
	private int movementPos;
	private int hp = 4;
	private boolean existing = true;
	
	public int getMovementPos() {
		return movementPos;
	}

	public void setMovementPos(int movementPos) {
		this.movementPos = movementPos;
	}
	public PowerUp(){
		setxPos((int)(Math.random()* 750));
		setyPos(0);
		setMaxHp(hp);
		setHp(getMaxHp());
		if (Math.random() > 0.5)
			setMovementPos(2);
		else 
			setMovementPos(- 2);
		
		Timer timer = new Timer(10000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				setExisting(false);
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	
	public abstract void triggerEvent(ObjectMap map);

	public boolean isExisting() {
		return existing;
	}

	public void setExisting(boolean existing) {
		this.existing = existing;
	}
	
}
