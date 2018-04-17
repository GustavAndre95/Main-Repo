/**
 * <h1>EnemyProjectile</h1>
 * Klassen EnemyProjectile �r en underklass av Projectile. Den beter sig ungef�r likadant fast den r�r
 * sig ned�t ist�llet f�r upp�t p� sk�rmen, och representeras av en annan bild.
 * 
 * @author Gustav Andr� 
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
