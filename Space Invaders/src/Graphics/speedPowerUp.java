/**
 * <h1>SpeedPowerUp</h1>
 * Klassen SpeedPowerUp är en underklass av PowerUp. Om spelaren skjuter sönder detta grafiska objekt
 * kan spelaren skjuta med en snabbare hastighet i några sekunder.
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

import Logics.EventTrigger;
import Logics.ObjectMap;

public class speedPowerUp extends PowerUp{
	Image currentImage = ImageHandler.getImage("src/images/speedPowerUp.png");

	public speedPowerUp(){
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
		Player player = map.getPlayer();
		int reloadTime = player.getReloadTime();
		if (reloadTime < 300)
			return;
		player.setReloadTime(150);
		Timer timer = new Timer(4000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				player.setReloadTime(300);
			}
		}); 
		timer.setRepeats(false);
		timer.start();
		
	}
	


}
