/**
 * <h1>Tracker</h1>
 * Interfacet "Tracker" används av HardEnemy. Metoden "followPlayer" bestämmer hur fienden ska
 * bära sig åt för att följa efter spelaren. 
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */
package Logics;

import Graphics.Player;

public interface Tracker {
	public abstract void followPlayer(int playerPos);
	
}
