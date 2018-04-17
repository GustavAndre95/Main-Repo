/**
 * <h1>SoundManager</h1>
 * Klassen SoundManager används för att spela upp ljud i spelet.
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */
package Logics;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
public class SoundManager {

	public static Clip playASound(String path, boolean repeat) {
	
		AudioInputStream audioIn;
		try {
			audioIn = AudioSystem.getAudioInputStream(new File(path));
			
			DataLine.Info info = new DataLine.Info(Clip.class, audioIn.getFormat());
			Clip clip = (Clip) AudioSystem.getLine(info);
			clip.open(audioIn);
			if (repeat) {
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				clip.start();
			}
	        return clip;
		} catch (UnsupportedAudioFileException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
}