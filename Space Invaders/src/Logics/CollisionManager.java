
/**
 * <h1>CollisionManager</h1>
 * Klassen CollisionManager sköter all kollisionshantering i spelet, och bestämmer vad som händer
 * om en kollision inträffar.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */
package Logics;

import Graphics.Enemy;
import Graphics.EnemyProjectile;
import Graphics.Explosion;
import Graphics.GameField;
import Graphics.GameObject;
import Graphics.HardEnemy;
import Graphics.Player;
import Graphics.PowerUp;
import Graphics.Projectile;

import java.awt.Rectangle;
import java.util.ArrayList;
public class CollisionManager {
	
	private ObjectMap map;
	private GameField gf;
	private boolean damagePlayer = false;
	ArrayList <GameObject> toRemove = new ArrayList<>();	
	
	
	public void handleAllCollisions (ObjectMap map, GameField gf){
		this.map = map;
		this.gf = gf;
		
		detectExplosions();
		detectProjectilePowerUpCollisisons();
		detectEnemyProjectileCollisions();
		detectEnemyPlayerCollisions();
		removeObjects(toRemove);
	}
	
	public void detectProjectilePowerUpCollisisons() {
		for (PowerUp pu : map.getAllPowerUps()) {	
			for (Projectile p : (map.getAllProjectiles())) {
				if (p instanceof EnemyProjectile)
					continue;
				if (!pu.isExisting())
					toRemove.add(pu); 
			else        
				if (intersects(p, pu)) {
					map.addExplosion(pu);
					pu.setHp(pu.getHp() - 1);
					if (pu.getHp() < 1) {
						toRemove.add(pu);
						pu.triggerEvent(map);
					}
					toRemove.add(p);
				}
			}
				
		}
	}
	
	public void detectEnemyProjectileCollisions(){
		Player player = map.getPlayer();
		
		for (Projectile p: map.getAllProjectiles())
			if (!p.isInYBounds(gf))
				toRemove.add(p);
		
		for (Enemy e: map.getAllEnemies()) {
			
			if (!e.isInYBounds(gf)){
				player.setCurrentScore(player.getCurrentScore() - 30);
				int currentScore = player.getCurrentScore();
				if (currentScore < 0)
					player.setCurrentScore(0); 
				
				toRemove.add(e);
			}	
			for (Projectile p: map.getAllProjectiles()) {
				if (p instanceof EnemyProjectile) {		
					if (intersects(map.getPlayer(), p)) {
						map.addExplosion(p);
						toRemove.add(p);
						damagePlayer = true;
					}
				} 
				else {		
					if (intersects(e, p)){
						map.addExplosion(p);
						e.setHp(e.getHp()-1);
						toRemove.add(p);
					}
					if (e.getHp() < 1) {
						if (e instanceof HardEnemy && !e.isToBeRemoved())
							player.setCurrentScore(player.getCurrentScore() + 50);
						else if (!e.isToBeRemoved())
							player.setCurrentScore(player.getCurrentScore() + 20);
						e.setToBeRemoved(true);
						toRemove.add(e);
					}
				}				
			}
		}
	}
	public void detectEnemyPlayerCollisions(){
		Player player = map.getPlayer();
		for (Enemy e : map.getAllEnemies()) {
			if (intersects(e, map.getPlayer()) || damagePlayer){
				//Player gets hurt if the enemies manages to pass through the map or if enemy intersects player.
				
				player.setHp(player.getHp() - 1);
				SoundManager.playASound("src/sounds/Ahh.wav", false);
				if (!damagePlayer)
					toRemove.add(e);
				damagePlayer = false;
			}
		}
	}
	
	public void detectExplosions() {
		for (Explosion e : map.getAllExplosions()) {
			if (e.getCurrentIndex() == 6)
				toRemove.add(e);
		}
	}
	
	public boolean intersects (GameObject go, GameObject go2) {
		Rectangle r1 = new Rectangle (go.getxPos(), go.getyPos(), go.getImage().getWidth(null), go.getImage().getHeight(null));
		Rectangle r2 = new Rectangle (go2.getxPos(), go2.getyPos(), go2.getImage().getWidth(null), go2.getImage().getHeight(null));
		
		if (r1.intersects(r2))
			return true;
		
		return false;
	}
	
	public void removeObjects(ArrayList<GameObject> toRemove) {
		if (toRemove.isEmpty())
			return;
		try {
		map.getAllPowerUps().removeAll(toRemove);
		map.getAllProjectiles().removeAll(toRemove);
		map.getAllEnemies().removeAll(toRemove);
		map.getAllObjects().removeAll(toRemove);
		map.getAllExplosions().removeAll(toRemove);
		} catch (ArrayIndexOutOfBoundsException e) {
			// NOT an optimal solution, but works suprisingly well.
		}
	}

}
