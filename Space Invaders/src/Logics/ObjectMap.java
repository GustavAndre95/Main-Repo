/**
 * <h1>ObjectMap</h1>
 * Klassen ObjectMap håller koll på samtliga objekt på skärmen, var de befinner sig, hur mycket hp de har
 * kvar osv. 
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Logics;

import java.util.ArrayList;

import Graphics.Enemy;
import Graphics.Explosion;
import Graphics.GameObject;
import Graphics.HardEnemy;
import Graphics.Healthbar;
import Graphics.Player;
import Graphics.PowerUp;
import Graphics.Projectile;
import Graphics.BombPowerUp;
import Graphics.speedPowerUp;

public class ObjectMap {
	
	private Player player;
	private ArrayList <GameObject> allObjects = new ArrayList<>(); 
	private ArrayList <Enemy> allEnemies = new ArrayList<>();
	private ArrayList <Projectile> allProjectiles = new ArrayList<>();
	private ArrayList <Explosion> allExplosions = new ArrayList<>();
	
	public ArrayList<PowerUp> getAllPowerUps() {
		return allPowerUps;
	}

	public void setAllPowerUps(ArrayList<PowerUp> allPowerUps) {
		this.allPowerUps = allPowerUps;
	}
	private ArrayList <PowerUp> allPowerUps = new ArrayList<>();
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
		allObjects.add(player);
	}

	public void addProjectile(Projectile p){
		allProjectiles.add(p);
		allObjects.add(p);
	}
	
	public ArrayList<GameObject> getAllObjects() {
		return allObjects;
	}
	public ArrayList<Enemy> getAllEnemies() {
		return allEnemies;
	}
	
	public ArrayList<Projectile> getAllProjectiles() {
		return allProjectiles;
}
	public void addEnemy (){
		if (allEnemies.size() > 6)
			return;
		
		Enemy e = new Enemy();
		if (Math.random() < 0.35)
			e = new HardEnemy();
		e.setHealthBar(new Healthbar());
		allEnemies.add(e);
		allObjects.add(e);
		
	}
	public void addPowerUp() {
		PowerUp pu;
		
		if (Math.random()> 0.5)
			pu = new speedPowerUp();
	    else 
			pu = new BombPowerUp();
		pu.setHealthBar(new Healthbar());
	
		allPowerUps.add(pu);
		allObjects.add(pu);
	}

	public ArrayList <Explosion> getAllExplosions() {
		return allExplosions;
	}

	public void setAllExplosions(ArrayList <Explosion> allExplosions) {
		this.allExplosions = allExplosions;
	}
	
	public void addExplosion(GameObject go){
		Explosion e = new Explosion(go.getxPos() - 20, go.getyPos() - 20);
		allObjects.add(e);
		allExplosions.add(e);
	}

	
	

}
