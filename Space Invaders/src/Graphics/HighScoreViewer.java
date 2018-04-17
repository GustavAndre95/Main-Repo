/**
 * <h1>HighScoreViewer</h1>
 * Klassen HighScoreViewer är egentligen bara en behållare för HighScorePanel och menyknappen som tar spelaren tillbaka till 
 * menyn. Klassen är egentligen ganska onödig men hade en del strul med Swing och AWT och var tvungen
 * att göra såhär för att det skulle fungera.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import Logics.HighScoreHolder;

public class HighScoreViewer extends JComponent{
	
	private HighScoreHolder highscores;
	private Box box;
	public HighScoreViewer(final MainWindow window){
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		box = new Box(BoxLayout.Y_AXIS);
		Box.createVerticalBox();
		setFocusable(true);
		
		JButton menuBtn = new JButton("BACK TO MENU");
		menuBtn.setPreferredSize(new Dimension(800, 100));
		menuBtn.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		menuBtn.setFocusable(false);
		menuBtn.setFont(new Font("Verdana", 1, 15));		
		menuBtn.setBackground(Color.black);
		menuBtn.setForeground(Color.magenta);
		menuBtn.setBorder(new LineBorder(Color.black, 0));
		box.add(menuBtn);
	
		HighScorePanel jp = new HighScorePanel();
		jp.setFocusable(true);
		jp.setBackground(Color.BLACK);
		jp.setLayout(new BorderLayout());
		jp.setPreferredSize(new Dimension(800, 400));
		box.add(jp);
		menuBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				window.getContentPane().removeAll();
				window.startMenu();
			//	clip.stop();
			
			}
		});
		add(box);
		repaint();
	}
	

}
