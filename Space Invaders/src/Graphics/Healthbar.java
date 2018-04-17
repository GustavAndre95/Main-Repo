/**
 * <h1>HealthBar</h1>
 * Klassen HealthBar är en grafisk komponent som kan användas till samtliga grafiska objekt i spelet.
 * Den bestämmer själv hur en ska ritas ut beroende på hur mycket HP det grafiska objektet har.
 * 
 * @author Gustav André 
 * @version 1.0
 * @since 2017-03-08
 */

package Graphics;

import java.awt.Color;
import java.awt.Graphics;

import Logics.Coordinate;

public class Healthbar extends GameObject{
	private int width = 100;
	
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getnTiles() {
		return nTiles;
	}
	public void setnTiles(int nTiles) {
		this.nTiles = nTiles;
	}
	private int height = 20;
	private int nTiles;
	
	public Healthbar(){

	}
	
	public void paintYourself(Graphics g, GameObject go) {
		this.nTiles = go.getMaxHp();
		if (nTiles < 1)
			return;
		int tileLength = width / nTiles;
		int rightMovement = 0;

		//Drawing green hitpoints 
		for (int i = go.getHp(); i > 0; i--) {
			g.setColor(Color.GREEN);
			g.fillRect(go.getxPos() + rightMovement, go.getyPos() - 30, tileLength, height);
			rightMovement += tileLength;
		}
		//Drawing red hitpoints
		for (int i = go.getMaxHp() - go.getHp(); i > 0; i--) {
			g.setColor(Color.RED);
			g.fillRect(go.getxPos() + rightMovement, go.getyPos() - 30, tileLength, height);
			rightMovement += tileLength;;
		}
	
	}
	

}
