/**
 * <h1>CollisionControl</h1>
 * Klassen "HighScorePanel" är den komponent som ritar ut highscores på skärmen. Den hämtar data från en
 * fil på datorn och ritar ut detta genom paintComponent.
 * 
 * @@author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */
package Graphics;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Logics.HighScoreHolder;

public class HighScorePanel extends JPanel{
	
	public HighScorePanel() {
		setBackground(Color.BLACK);
	}
	
	public void printHighScores(Graphics g) throws IOException, ClassNotFoundException {
	    int yValue = 100;
	
		FileInputStream fis = new FileInputStream("src/highscores.ser");
		ObjectInputStream ois = new ObjectInputStream(fis);
		HighScoreHolder highscores = (HighScoreHolder) ois.readObject();
		System.out.println("Hämtar highscores...");
		ois.close();
		g.setColor(Color.RED);
		g.setFont(new Font ("Verdana", 200, 30));
		g.drawString("TOP SCORES OF ALL TIME", 20, 50);
		
		for (int i = 0; i < 10 ; i++) {
			g.setColor(Color.RED);
			g.setFont(new Font ("Verdana", 100, 30));

			g.drawString(i + 1 + ". " + highscores.getScores().get(i), 50, yValue);
			System.out.println(highscores.getScores().get(i));
			yValue += 40;
		}	
	}
	
@Override
	public void paintComponent(Graphics g) {
	super.paintComponent(g);		
		try {
			printHighScores(g);
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}

	}

}
