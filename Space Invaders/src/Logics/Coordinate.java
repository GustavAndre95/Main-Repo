/**
 * <h1>CollisionControl</h1>
 * Klassen Coordinate är en hjälpklass som gör det enklare att hantera koordinater i spelet.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Logics;

public class Coordinate {
	private int x;
	private int y;
	
	public Coordinate(int xPos, int yPos){
		this.x = xPos;
		this.y = yPos;
	}
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	
	public void setY (int y) {
		this.y = y;
	}
	
	public void setX (int x) {
		this.x = x;
	}
	
	
	
}
