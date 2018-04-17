/**
 * <h1>HighScoreHolder</h1>
 * Klassen HighScoreHolder lagrar alla highscores fr�n spelet. Den implementerar "Serializable" s� 
 * att klassen, och d�rmed alla highscores, kan skrivas till datorns h�rddisk.
 * 
 * @author Gustav Andr�
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
