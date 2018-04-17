/**
 * <h1>HardEnemy</h1>
 * Klassen HardEnemy ärver från Enemy. Den implementerar också ett interface som gör den till en
 * "Tracker", dvs att den har möjlighet att följa efter spelaren. Detta, bakgrundsbilden och antalet HP
 * är det enda som skiljer den från en vanlig Enemy.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import Logics.Tracker;

public class HardEnemy extends Enemy implements Tracker{
	private int xValue;
	
	public HardEnemy(){	
		super();
		super.setHp(3);
		super.setMaxHp(getHp());
	 	super.setImage(ImageHandler.getImage("src/images/Enemyhard.png"));
	 	super.setyPos(0);
	 	super.setSpeed(super.getSpeed());
	 	setReloadSpeed(2000);
	 	
	}

	public void updatePosition (int tValue){		
			setyPos(getyPos() + getSpeed());
			followPlayer(tValue);
	}

	
	public void followPlayer(int tValue) {
		if (getSpeed()==0)
			return;
		
		if (tValue > this.getxPos())
			setxPos(getxPos() + 4);
		else
			setxPos(getxPos() - 4);
		
	}

}
