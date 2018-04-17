/**
 * <h1>Projectile</h1>
 * Klassen Projectile �r ett grafiskt objekt som representerar spelarens projektiler som denne kan skjuta
 * mot fienderna. Den illustreras av en bakgrundsbild och r�r sig med en hastighet av -11 pixlar
 * (allts� upp�t p� sk�rmen).
 * @author Gustav Andr�
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.Image;

public class Projectile extends GameObject{
	
	private Image currentImage = ImageHandler.getImage("src/images/projectile_red.png");
	private int speed = -11;
	
	public Projectile(int x, int y){
		super.setImage(currentImage);
		super.setxPos(x);
		super.setyPos(y);
		super.setSpeed(speed);
	}

}
