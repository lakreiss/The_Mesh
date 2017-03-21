package solveWithoutObjects;

import java.util.Arrays;

public class SolverWithoutObjects {
	
	//TODO: correct order so as to make as many versions of the goal as possible and to not fail the test
	//use objects?
	//use multiplier and divider
	//use multiple multipliers and divisors
	
	public static void main(String[] args) {
//		int[] goals = new int[]{1, 7, 8, 3, 4, 4, 10};
//		int[][] tile_configs = new int[][]{{1, 2, 4}, {8, 3, 2}, {8, 8, 8}, {2, 10, 20, 1, 30}, {1, 1, 1, 1}, {-1, -1, -1, -1}, {1, 2}};
//		int index = 0;
//		while (index < goals.length && index < tile_configs.length){
//			get_answer(goals[index], tile_configs[index]);
//			System.out.println();
//			index++;
//		}
		
		//bug where it can only get odd multiples of goal
		int goal = 7;
		boolean hasTimesTwo = true;
		int[] tiles = new int[]{3, 4, 5, 8, 8};
		
		if (hasTimesTwo){
			System.out.println("without x2: ");
			get_answer(goal, tiles, false);
			System.out.println();
			System.out.println("with x2: ");
			get_answer(goal, tiles, true);
		} else {
			get_answer(goal, tiles, false);
		}

	}
	
	public static void get_answer(int goal, int[] tiles, boolean timesTwoAvailable){
		//make all the values positive
		for (int i = 0; i < tiles.length; i++){
			tiles[i] = Math.abs(tiles[i]);
		}
		
		//index = 0, answer is an empty int[] with length = tiles.length
		int[] answer = new int[tiles.length];
		get_digits(goal, tiles, 0, answer, timesTwoAvailable, goal);
	}
	
	//cont = continue
	public static void get_digits(int goal, int[] tiles, int index, int[] answer, boolean timesTwoAvailable, int originalGoal){
		if (index == tiles.length){
			if (goal == 0){
//				System.out.println(Arrays.toString(check_answer(answer, originalGoal))/* + " succeeds!!"*/);

				System.out.println(Arrays.toString(answer)/* + " succeeds!!"*/);
			} else {
				//System.out.println(Arrays.toString(answer) + "is not a valid solution");
			}
		} else {
			if (timesTwoAvailable){
				
				//positive because multiplier is 2
				contWithMultiplier(goal, tiles, index, answer, 2, timesTwoAvailable, originalGoal);
				
				//negative because multiplier is -2
				contWithMultiplier(goal, tiles, index, answer, -2, timesTwoAvailable, originalGoal);
			
			} else {
				
				//positive because multiplier is 1
				contWithMultiplier(goal, tiles, index, answer, 1, timesTwoAvailable, originalGoal);
				
				//negative because multiplier is -1
				contWithMultiplier(goal, tiles, index, answer, -1, timesTwoAvailable, originalGoal);
			}
		}
	}
	
	//TODO make so that it changes the order of the numbers so that they don't preemtively form an answer
//	private static int[] check_answer(int[] answer, int goal){
//		boolean foundWorkingSolution = false;
//		int index = 0;
//		int sum = 0;
//		while (!foundWorkingSolution || index < answer.length){
//			if (sum + answer[index] == goal && index < answer.length - 1){
//				
//			}
//		}
//	}

	private static void contWithMultiplier(int goal, int[] tiles, int index, int[] answer, int multiplier, boolean timesTwoAvailable, int originalGoal) {
		int num = tiles[index] * multiplier;
		answer[index] = num;
		if ((int)Math.abs(multiplier) == 2){
			get_digits(goal - num, tiles, index + 1, answer, false, originalGoal);
		} else {
			get_digits(goal - num, tiles, index + 1, answer, timesTwoAvailable, originalGoal);
		}
	}
}
