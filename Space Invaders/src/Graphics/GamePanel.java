/**
 * <h1>GamePanel</h1>
 * Klassen GamePanel är egentligen bara en "behållare" för själva spelfältet samt knappen som tar spelaren
 * tillbaka till menyn.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Graphics;
import java.awt.Color;

import Logics.Coordinate;
import Logics.ObjectMap;

public class GamePanel extends JComponent{
	
	private ObjectMap model = new ObjectMap();
	private GameField gamefield;
	public GamePanel (final MainWindow window, Image backImage) {
		
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JButton menuBtn = new JButton("BACK TO MENU");
		menuBtn.setPreferredSize(new Dimension(800, 100));
		menuBtn.setMaximumSize(new Dimension(Short.MAX_VALUE, Short.MAX_VALUE));
		menuBtn.setFocusable(false);
		menuBtn.setFont(new Font("Verdana", 1, 15));		
		menuBtn.setBackground(Color.black);
		menuBtn.setForeground(Color.magenta);
		menuBtn.setBorder(new LineBorder(Color.black, 0));
		
		add(menuBtn);
		gamefield = new GameField(model, backImage);
		this.add(gamefield);
		menuBtn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gamefield.getEngine().stopGame();
				window.getContentPane().removeAll();
				window.startMenu();
			}
		});
		
		
	}

}
