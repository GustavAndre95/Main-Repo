/**
 * <h1>HighScoreHolder</h1>
 * Klassen HighScoreHolder lagrar alla highscores från spelet. Den implementerar "Serializable" så 
 * att klassen, och därmed alla highscores, kan skrivas till datorns hårddisk.
 * 
 * @author Gustav André
 * @version 1.0
 * @since 2017-03-08
 */

package Logics;

import java.io.Serializable;
import java.util.ArrayList;

public class HighScoreHolder implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArrayList<Integer> scores;
	
	public HighScoreHolder() {
		scores = new ArrayList<>();
	}
	
	public ArrayList<Integer> getScores() {
		return scores;
	}
	
	public void addScore(Integer score) {
		scores.add(score);
	}
	
	
}
