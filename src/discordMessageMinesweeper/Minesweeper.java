package discordMessageMinesweeper;

import java.util.Random;

public class Minesweeper {
	public static int[][] generateBombCoords(int xwidth, int yheight, int count) {
		Random rnd = new Random();
		String list = ",";
		int[][] bombs = new int[2][count];
		for(int i = 0; i < count; i++) {
			int a = rnd.nextInt(yheight);
			while(list.contains("," + a + "/")) {
				a = rnd.nextInt(yheight);
			}
			list += a + "/";
			int b = rnd.nextInt(xwidth);
			while(list.contains("/" + b + ",")) {
				b = rnd.nextInt(xwidth);
			}
			list += b + ",";
			bombs[0][i] = a;
			bombs[1][i] = b;
		}
		return bombs;
	}
	//bombs[0][a] is y, bombs[1][a] is x
	
	public static boolean checkExist(int xwidth, int yheight, int y, int x) {
		if(x >= 0 && x < xwidth && y < yheight && y >= 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean checkBomb(int[][] bombs, int y, int x) {
		for(int i = 0; i < bombs[0].length; i++) {
			if(bombs[0][i] == y && bombs[1][i] == x) {
				return true;
			}
		}
		return false;
	}
	
	
	public static int checkNumber(int[][] bombs, int xwidth, int yheight, int y, int x) {
		int number = 0;
		if(checkExist(xwidth, yheight, y, x)) {
			if(checkBomb(bombs, y, x)) {
				number =  -1;
			} else {
				if(checkBomb(bombs, y-1, x-1)) {
					number++;
				}
				if(checkBomb(bombs, y, x-1)) {
					number++;
				}
				if(checkBomb(bombs, y+1, x-1)) {
					number++;
				}
				if(checkBomb(bombs, y-1, x)) {
					number++;
				}
				if(checkBomb(bombs, y+1, x)) {
					number++;
				}
				if(checkBomb(bombs, y-1, x+1)) {
					number++;
				}
				if(checkBomb(bombs, y, x+1)) {
					number++;
				}
				if(checkBomb(bombs, y+1, x+1)) {
					number++;
				}
			}
		}
		return number;
	}
	
	public static int[][] generateFullArray(int xwidth, int yheight, int numberOfBombs) {
		int[][] bombs = generateBombCoords(xwidth, yheight, numberOfBombs);
		int[][] minefield = new int[yheight][xwidth];
		for(int i = 0; i < xwidth; i++) {
			for(int j = 0; j < yheight; j++) {
				minefield[j][i] = checkNumber(bombs, xwidth, yheight, j, i);
			}
		}
		
		return minefield;
	}
	
	public static void printArray(int[][] arr) {
		for(int i = 0; i < arr[0].length; i++) { //xwidth
			for(int j = 0; j < arr.length; j++) { //yheight
				System.out.print(arr[j][i] + ",");
			}
			System.out.println();
		}
	}
	public static String printArray(String[][] arr) {
		String print = "";
		for(int i = 0; i < arr[0].length; i++) { //xwidth
			for(int j = 0; j < arr.length; j++) { //yheight
				print += arr[j][i];
			}
			print += "\n";
		}
		return print;
	}
}
