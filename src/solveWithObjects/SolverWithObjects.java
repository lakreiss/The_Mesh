package solveWithObjects;

import java.util.ArrayList;

public class SolverWithObjects {

	public static void main(String[] args) {
		int goal = 10;
		int[] tiles = new int[]{1, 5, -3, 5};
		int numTimesTwos = 0;
		
		makeSolutions(goal, tiles, numTimesTwos);
	}

	private static void makeSolutions(int goal, int[] tiles, int numTimesTwos) {
		ArrayList<Combination> combinations = new ArrayList<Combination>();
		for (int i = 0; i < tiles.length; i++){
			if (numTimesTwos > 0){
				
			}
		}
		
		boolean solutionFound = false;
		for (Combination c : combinations){
			if (c.isSolution()) {
				solutionFound = true;
				System.out.println(c.toString());
			}
		}
		if (!solutionFound) {
			System.out.println("No solutions could be found");
		}
	}
}
