/**
 * <h1>ImageHandler</h1>
 * ImageHandler anv�nds f�r att h�mta bilder fr�n datorns h�rddisk och g�ra dem till en Image i javaprogrammet.
 * 
 * @author Gustav Andr� 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.sun.prism.Image;

public class ImageHandler {

	private static BufferedImage image;
	
	public static BufferedImage getImage(String fileName) {
		try {
			image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			System.out.println("Cannot read file.");
			return null;
		}
		return image;
	}
	
}
