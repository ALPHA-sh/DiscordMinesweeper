package discordMessageMinesweeper;

public class DiscordMinesweeper {

	public static void main(String[] args) {
		
		//---------------------------------
		// vvv VARIABLES (CHANGE THESE) vvv
		
		int xwidth = 12;
		int yheight = 12;
		int bombCount = 9;
		
		
		//---------------------------------
		
		
		if(xwidth <= 0) {
			xwidth = 1;
		}
		if(yheight <= 0) {
			yheight = 1;
		}
		if (bombCount > yheight * xwidth) {
			bombCount = yheight * xwidth;
		}
		String print= "";
		print += "**Minesweeper** *(" + xwidth + "x" + yheight + " with " + bombCount + " bombs)*\n";
		int[][] minefield = Minesweeper.generateFullArray(yheight, xwidth, bombCount);
		String[][] discordMinefield = new String[minefield.length][minefield[0].length];
		for(int i = 0; i < minefield[0].length; i++) { //xwidth
			for(int j = 0; j < minefield.length; j++) { //yheight
				if(minefield[j][i] == 0) {
					discordMinefield[j][i] = "||:zero:||";
				} else if(minefield[j][i] == 1) {
					discordMinefield[j][i] = "||:one:||";
				} else if(minefield[j][i] == 2) {
					discordMinefield[j][i] = "||:two:||";
				} else if(minefield[j][i] == 3) {
					discordMinefield[j][i] = "||:three:||";
				} else if(minefield[j][i] == 4) {
					discordMinefield[j][i] = "||:four:||";
				} else if(minefield[j][i] == 5) {
					discordMinefield[j][i] = "||:five:||";
				} else if(minefield[j][i] == 6) {
					discordMinefield[j][i] = "||:six:||";
				} else if(minefield[j][i] == 7) {
					discordMinefield[j][i] = "||:seven:||";
				} else if(minefield[j][i] == 8) {
					discordMinefield[j][i] = "||:eight:||";
				} else if(minefield[j][i] == -1) {
					discordMinefield[j][i] = "||:boom:||";
				} 
			}
		}
		print += Minesweeper.printArray(discordMinefield);
		if(print.length() < 2000) {
			System.out.println(print);
		} else {
			System.out.println("-------WARNING: OVER 2000 CHARCTER LIMIT-------\n\n\n");
			System.out.println(print);
		}
	}

}
