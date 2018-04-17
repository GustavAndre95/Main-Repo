/**
 * <h1>MainWindow</h1>
 * Klassen MainWindow �r sj�lva f�nstret som h�ller i alla andra JComponent och JPanel-komponenter. Den best�mmer egentligen bara hur
 * stor sk�rmen ska, annars best�mmer komponenterna sj�lva vilka egenskaper de ska ha.
 * 
 * @author Gustav Andr�
 * @version 1.0
 * @since 2017-03-08
 */
package Graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;


public class MainWindow extends JFrame{
	private Dimension di = new Dimension(800, 800);
	
	public static void main (String [] args) {
	     new MainWindow();		
	}
	
	public MainWindow(){
		this.setLayout(new BorderLayout());
		setSize(di);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
		
		this.getContentPane().add(new Menu(this));
		revalidate();
	
	}
	
	public void startMenu(){
		this.getContentPane().add(new Menu(this));
		revalidate();
	}
 

		
	

}
