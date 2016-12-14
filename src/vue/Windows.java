package vue;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.Game;

public class Windows extends JFrame {
	
	Container fenetre;
	
	PlayerIHM firstPlayer;
	PlayerIHM secondPlayer;
	
	public Windows(Game game) {
		this.fenetre = this.getContentPane();
		
		firstPlayer = new PlayerIHM(game.getFirstPlayer(), game.getTray(), true);
		secondPlayer = new PlayerIHM(game.getSecondPlayer(), game.getTray(), false);
		
		
		creationOfStructure(firstPlayer, secondPlayer);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setPreferredSize(new Dimension(1000, 800));
		this.setTitle("Citadelle");
		this.pack();
		this.setVisible(true);
	}
	
	public void update() {
		this.pack();
	}
	
	public void creationOfStructure(PlayerIHM firstPlayer, PlayerIHM secondPlayer) {
		// TEST
		JPanel player1deck = new JPanel();
		player1deck.setBackground(Color.RED);
		player1deck.add(firstPlayer.getDeck());
		
		JPanel player1city = new JPanel();
		player1city.setBackground(Color.BLUE);
		player1city.add(firstPlayer.getCity());
		
		JPanel player2city = new JPanel();
		player2city.setBackground(Color.YELLOW);
		player2city.add(secondPlayer.getCity());
		
		JPanel player2deck = new JPanel();
		player2deck.setBackground(Color.GREEN);
		player2deck.add(secondPlayer.getDeck());
		
		JPanel player1status = new JPanel();
		player1status.setBackground(Color.CYAN);
		player1status.add(firstPlayer.getStatus());
		
		JPanel player2status = new JPanel();
		player2status.setBackground(Color.BLACK);
		player2status.add(secondPlayer.getStatus());
		// END TEST
		
		this.fenetre.setLayout(new GridLayout(2, 1));
		
		Container player1 = new Container();
		player1.setLayout(new BoxLayout(player1, BoxLayout.X_AXIS));
		
		Container cardAbstractionPlayer1 = new Container();
		cardAbstractionPlayer1.setLayout(new GridLayout(2, 1));
		
		cardAbstractionPlayer1.add(player1deck);
		cardAbstractionPlayer1.add(player1city);
		
		player1.add(cardAbstractionPlayer1);
		player1.add(player1status);
		
		this.fenetre.add(player1);
		
		Container player2 = new Container();
		player2.setLayout(new BoxLayout(player2, BoxLayout.X_AXIS));
		
		Container cardAbstractionPlayer2 = new Container();
		cardAbstractionPlayer2.setLayout(new GridLayout(2, 1));
		
		cardAbstractionPlayer2.add(player2city);
		cardAbstractionPlayer2.add(player2deck);
		
		player2.add(cardAbstractionPlayer2);
		player2.add(player2status);
		
		this.fenetre.add(player2);
		
	}
	
	public void updateStructure(Game game) {
		if(!firstPlayer.equals(game.getFirstPlayer()))
			this.firstPlayer.update(game.getFirstPlayer(), game.getTray());
		if(!secondPlayer.equals(game.getSecondPlayer()))
			this.secondPlayer.update(game.getSecondPlayer(), game.getTray());
	}
}
