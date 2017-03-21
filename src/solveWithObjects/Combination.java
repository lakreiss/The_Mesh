package solveWithObjects;

import java.util.ArrayList;

public class Combination {
	
	private ArrayList<Integer> tiles;
	public ArrayList<Integer> getTiles() {
		return tiles;
	}
	
	private int goal;
	public int getGoal() {
		return goal;
	}
	
	private int numTimesTwos;
	public int getNumTimesTwos(){
		return numTimesTwos;
	}
	
	private boolean solution = false;
	public boolean isSolution() {
		return solution;
	}
	
	private int timesTwosUsed = 0;
	public int getTimesTwosUsed(){
		return timesTwosUsed;
	}
	
	public void usedATimesTwo(){
		this.numTimesTwos--;
		this.timesTwosUsed++;
	}
	
	//combining blocks can make more than one solution for the goal
	private int numSolutions;
	public int getTotalSoltionsMade() {
		return numSolutions;
	}

	public Combination(ArrayList<Integer> tiles, int goal, int numDoubles){
		//converts all values to their absolute values initially
		this.tiles = makeAbsolute(tiles);
		this.goal = goal;
		this.numTimesTwos = numDoubles;
	}

	/**
	 * converts each of Tiles to its absolute value and returns tiles
	 * @param tiles
	 * @return 
	 */
	private ArrayList<Integer> makeAbsolute(ArrayList<Integer> tiles) {
		for (int i = 0; i < tiles.size(); i++){
			tiles.set(i, Math.abs(tiles.get(i)));
		}
		return tiles;
	}
	
	public String toString(){
		return tiles.toString() + " makes " + numSolutions + " solutions using " + numTimesTwos + "x2 tiles";
	}
}
