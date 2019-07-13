package discordMessageMinesweeper;

public class DiscordMinesweeper {

	public static void main(String[] args) {
		
		//VARIABLES
		
		int xwidth = 14;
		int yheight = 14;
		int bombCount = 9;
		
		System.out.println("__***Discord Minesweeper***__");
		System.out.println("**Minesweeper** *(" + xwidth + "x" + yheight + " with " + bombCount + " bombs)*");
		int[][] minefield = Minesweeper.generateFullArray(xwidth, yheight, bombCount);
		String[][] discordMinefield = new String[minefield[0].length][minefield.length];
		for(int i = 0; i < minefield.length; i++) { //yheight
			for(int j = 0; j < minefield[0].length; j++) { //xwidth
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
		Minesweeper.printArray(discordMinefield);
	}

}
