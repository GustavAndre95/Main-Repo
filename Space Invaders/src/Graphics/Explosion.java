/**
 * <h1>Explosion</h1>
 * En explosion uppstår när en projektil träffar en spelare eller en fiende. Explosionen renderas på ungefär
 * samma sätt som övriga grafiska objekt men har en lista med bilder som den växlar mellan när den ritas ut,
 * vilket skapar illusionen av en animation.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */


package Graphics;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import Logics.SoundManager;
import javax.swing.Timer;

public class Explosion extends GameObject {
	private ArrayList<Image> renderImages = new ArrayList<>();
	private int currentIndex = 0;
	private static final int FRAMETIME = 65; // Visningstid för varje frame
	public Explosion(int x, int y) {		
		for (int i = 0; i < 7; i++) {
			renderImages
					.add(ImageHandler.getImage("src/images/E" + i + ".png"));
		}
		super.setImage(ImageHandler.getImage("src/images/E" + 0 + ".png"));
		super.setxPos(x);
		super.setyPos(y);
		SoundManager.playASound("src/sounds/explosion.wav", false);
	}
	@Override
	public void updatePosition() {
		super.setImage((BufferedImage) renderImages.get(currentIndex));
		Timer timer = new Timer(FRAMETIME, new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentIndex != 6)
					currentIndex++;
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	public void setRenderImages(ArrayList<Image> renderImages) {
		this.renderImages = renderImages;
	}
	public int getCurrentIndex() {
		return currentIndex;
	}
}