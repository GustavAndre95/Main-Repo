/**
 * <h1>Tracker</h1>
 * Interfacet "Tracker" anv�nds av HardEnemy. Metoden "followPlayer" best�mmer hur fienden ska
 * b�ra sig �t f�r att f�lja efter spelaren. 
 * 
 * @author Gustav Andr�
 * @version 1.0
 * @since 2017-03-08
 */
package Logics;

import Graphics.Player;

public interface Tracker {
	public abstract void followPlayer(int playerPos);
	
}
