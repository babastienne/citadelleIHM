package application;

import vue.Windows;

public class Main {

	public static void main(String[] args) {
		Game game = new Game();
		Windows windows = new Windows(game);
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		game.changePlayerTMP();
		windows.updateStructure(game);
	}
}
