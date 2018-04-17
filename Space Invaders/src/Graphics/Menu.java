/**
 * <h1>Menu</h1>
 * Klassen Menu är en JPanel-komponent som bestämmer hur menyn ska se ut i spelet. Det finns tre knappar,
 * två som startar ett nytt spel och ett som tar spelaren till vyn som visar highscores.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.sound.sampled.Clip;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;

import Logics.SoundManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.*;


public class Menu extends JPanel{

	public Menu(final MainWindow window){
		ImageIcon map1 = new ImageIcon("src/images/MenuBackground.png");
		ImageIcon map2 = new ImageIcon("src/images/map2.png");
		Image gf1 = ImageHandler.getImage("src/images/map2.jpg");
		Image gf2 = ImageHandler.getImage("src/images/map1.png");
		
		
		ImageIcon highscores = new ImageIcon("src/images/highscores.png");
		BoxLayout by = new BoxLayout(this, 0);
		setLayout(by);
		
		Box box = new Box(BoxLayout.Y_AXIS);
		Box.createVerticalBox();
		
		JButton newGame1 = new JButton (map1);
		newGame1.setPreferredSize(new Dimension(200,200));
		newGame1.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		newGame1.setFocusable(true);
  
        newGame1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startGame(window, gf1);
			}
		});
        
        JButton newGame2 = new JButton (map2);
		newGame2.setPreferredSize(new Dimension(200,200));
		newGame2.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		newGame2.setFocusable(true);
  
        newGame2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				startGame(window, gf2);
			}
		});
        
        
        JButton viewHighScores = new JButton (highscores);
        viewHighScores.setPreferredSize(new Dimension(200,200));
        viewHighScores.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
        viewHighScores.setFocusable(true);
      
        viewHighScores.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				openHighScores(window);
			 
				
			}
		});
        box.add(newGame1);
        box.add(newGame2);
        box.add(viewHighScores);
        add(box);
        
	}
	
		
	
	//Add second map as parameter
	public void startGame(final MainWindow window, Image backImage){
		window.getContentPane().removeAll();
		window.getContentPane().add(new GamePanel(window, backImage));
		window.revalidate();
	}
	
	public void openHighScores(final MainWindow window) {
		window.getContentPane().removeAll();
		window.getContentPane().add(new HighScoreViewer(window));
		window.revalidate();
	}

}
