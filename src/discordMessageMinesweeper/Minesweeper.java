package discordMessageMinesweeper;

import java.util.Random;

public class Minesweeper {
	public static int[][] generateBombCoords(int yheight, int xwidth, int count) {
		Random rnd = new Random();
		String list = ",";
		int[][] bombs = new int[2][count];
		for(int i = 0; i < count; i++) {
			int a = rnd.nextInt(xwidth);
			while(list.contains("," + a + "/")) {
				a = rnd.nextInt(xwidth);
			}
			list += a + "/";
			int b = rnd.nextInt(yheight);
			while(list.contains("/" + b + ",")) {
				b = rnd.nextInt(yheight);
			}
			list += b + ",";
			bombs[0][i] = a;
			bombs[1][i] = b;
		}
		return bombs;
	}
	//bombs[0][a] is X, bombs[1][a] is Y
	
	public static boolean checkExist(int yheight, int xwidth, int x, int y) {
		if(y >= 0 && y < yheight && x < xwidth && x >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean checkBomb(int[][] bombs, int x, int y) {
		for(int i = 0; i < bombs[0].length; i++) {
			if(bombs[0][i] == x && bombs[1][i] == y) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int checkNumber(int[][] bombs, int yheight, int xwidth, int x, int y) {
		int number = 0;
		if(checkExist(yheight, xwidth, x, y)) {
			if(checkBomb(bombs, x, y)) {
				number =  -1;
			} else {
				if(checkBomb(bombs, x-1, y-1)) {
					number++;
				}
				if(checkBomb(bombs, x, y-1)) {
					number++;
				}
				if(checkBomb(bombs, x+1, y-1)) {
					number++;
				}
				if(checkBomb(bombs, x-1, y)) {
					number++;
				}
				if(checkBomb(bombs, x+1, y)) {
					number++;
				}
				if(checkBomb(bombs, x-1, y+1)) {
					number++;
				}
				if(checkBomb(bombs, x, y+1)) {
					number++;
				}
				if(checkBomb(bombs, x+1, y+1)) {
					number++;
				}
			}
		}
		return number;
	}
	
	public static int[][] generateFullArray(int yheight, int xwidth, int numberOfBombs) {
		int[][] bombs = generateBombCoords(yheight, xwidth, numberOfBombs);
		int[][] minefield = new int[xwidth][yheight];
		for(int i = 0; i < yheight; i++) {
			for(int j = 0; j < xwidth; j++) {
				minefield[j][i] = checkNumber(bombs, yheight, xwidth, j, i);
			}
		}
		
		return minefield;
	}
	
	public static void printArray(int[][] arr) {
		for(int i = 0; i < arr.length; i++) { //yheight
			for(int j = 0; j < arr[0].length; j++) { //xwidth
				System.out.print(arr[j][i] + ",");
			}
			System.out.println();
		}
	}
	public static void printArray(String[][] arr) {
		for(int i = 0; i < arr.length; i++) { //yheight
			for(int j = 0; j < arr[0].length; j++) { //xwidth
				System.out.print(arr[j][i]);
			}
			System.out.println();
		}
	}
}
