/**
 * <h1>BombPowerUp</h1>
 * Klassen BombPowerUp är ett grafiskt objekt som dödar alla fiender på skärmen om
 * spelaren lyckas skjuta sönder objektet.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */


package Graphics;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import Logics.ObjectMap;

public class BombPowerUp extends PowerUp{
	Image currentImage = ImageHandler.getImage("src/images/bombPowerUp.png");

	public BombPowerUp(){
		super();
		setyPos(35);
		setImage(currentImage);
	}
	
	@Override
	public void updatePosition() {
		if (getxPos() < 0 || getxPos() > 750)
			setMovementPos(getMovementPos() *-1);
		setxPos(getxPos() + getMovementPos());
	}
	
	@Override
	public void triggerEvent(ObjectMap map) {
		ArrayList <Enemy> toRemove = new ArrayList<>();
		for (Enemy e : map.getAllEnemies()) {
			toRemove.add(e);	
		}
			Timer timer = new Timer(500, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (Enemy e : map.getAllEnemies()) {
						map.addExplosion(e);	
					}
					map.getAllEnemies().removeAll(toRemove);
					map.getAllObjects().removeAll(toRemove);
					
				}
			});
	
			timer.setRepeats(false);
			timer.start();
		
			
		
	}
	


}
