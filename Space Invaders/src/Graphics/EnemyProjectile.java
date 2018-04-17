/**
 * <h1>EnemyProjectile</h1>
 * Klassen EnemyProjectile är en underklass av Projectile. Den beter sig ungefär likadant fast den rör
 * sig nedåt istället för uppåt på skärmen, och representeras av en annan bild.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import Logics.Coordinate;

public class EnemyProjectile extends Projectile{
	private Image currentImage = ImageHandler.getImage("src/images/projectile_blue.png");
	private int speed = 15;
	
	public EnemyProjectile(int x, int y) {
		super(x, y);
		super.setImage(currentImage);
		super.setSpeed(speed);
	}
	


}
