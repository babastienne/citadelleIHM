package view;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import application.Game;
import view.abstraction.ContainerStruct;

/**
 * This class is the main container composing the window of the game.
 * It follow the architecture created for the project (using interfaces
 * of the package 'abstraction'). The window is unique, so there is a 
 * pattern which provide only one instance of the Window.
 * @author bpotiron
 *
 */
@SuppressWarnings("serial")
public final class Window extends JFrame implements ContainerStruct<Game> {
	
	private static Window INSTANCE = new Window();
	
	Container fenetre;
	
	PlayerIHM firstPlayer;
	PlayerIHM secondPlayer;
//	ChooseDistrictCard choosePanel;
	
	private Window() {

	}
	
	public static Window getInstance() {
		return INSTANCE;
	}
	
	public Container getView() {
		return this.fenetre;
	}
	
	public void creationWindow(Game game) {
		this.fenetre = this.getContentPane();
		this.fenetre.setBackground(SystemColor.controlHighlight);
		
		firstPlayer = new PlayerIHM(game.getFirstPlayer(), game.getTray(), true, game.getCardManager());
		secondPlayer = new PlayerIHM(game.getSecondPlayer(), game.getTray(), false, game.getCardManager());
//		choosePanel = new ChooseDistrictCard(game);
		
		
		creationOfStructure();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//		this.setPreferredSize(new Dimension(1000, 850));
		this.setTitle("Citadelle");
		this.pack();
		this.setVisible(true);
	}
	
	private void update() {
		this.pack();
	}
	
	public void creationOfStructure() {
		JPanel player1deck = new JPanel();
		player1deck.add(firstPlayer.getDeck());
		
		JPanel player1city = new JPanel();
		player1city.add(firstPlayer.getCity());
		
		JPanel player2city = new JPanel();
		player2city.add(secondPlayer.getCity());
		
		JPanel player2deck = new JPanel();
		player2deck.add(secondPlayer.getDeck());
		
		JPanel player1status = new JPanel();
		player1status.add(firstPlayer.getStatus());
		
		JPanel player2status = new JPanel();
		player2status.add(secondPlayer.getStatus());
		
		
		// creation of containers
		Container statusBothPlayer = new Container();
		statusBothPlayer.setLayout(new GridLayout(2, 1));
		
		statusBothPlayer.add(player1status);
		statusBothPlayer.add(player2status);
		
		this.fenetre.setLayout(new BoxLayout(this.fenetre, BoxLayout.X_AXIS));
		
		Container cardAbstraction = new Container();
		cardAbstraction.setLayout(new GridLayout(2, 1));
		
		Container cardAbstractionPlayer1 = new Container();
		cardAbstractionPlayer1.setLayout(new GridLayout(2, 1));
		
		cardAbstractionPlayer1.add(player1deck);
		cardAbstractionPlayer1.add(player1city);
		
		cardAbstraction.add(cardAbstractionPlayer1);
		
		Container cardAbstractionPlayer2 = new Container();
		cardAbstractionPlayer2.setLayout(new GridLayout(2, 1));
		
		cardAbstractionPlayer2.add(player2city);
		cardAbstractionPlayer2.add(player2deck);
		
		cardAbstraction.add(cardAbstractionPlayer2);
		
		this.fenetre.add(cardAbstraction);
		this.fenetre.add(statusBothPlayer);
		
//		JPanel choiceOfThePlayerForTheGame = new JPanel();
//		choiceOfThePlayerForTheGame.add(choosePanel.getView());
//		this.fenetre.add(choiceOfThePlayerForTheGame);
		
	}
	
	public void updateStructure(Game game) {		
		if(!firstPlayer.equals(game.getFirstPlayer()))
			this.firstPlayer.updateStructure(game.getTray());
		if(!secondPlayer.equals(game.getSecondPlayer()))
			this.secondPlayer.updateStructure(game.getTray());
		
//		this.choosePanel.updateStructure();
		
		update();
	}

}
