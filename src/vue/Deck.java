package vue;

import java.util.List;

import javax.swing.JPanel;

import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Tray;

public class Deck {
	JPanel deck;
	
	List<District> deckCards;
	boolean isFirstPlayer;
	
	public Deck(Tray tray, Boolean isFirstPlayer) {
		this.deck = new JPanel();
		
		this.isFirstPlayer = isFirstPlayer;
		
		creationOfStructure();
		
		updateStructure(tray);
	}
	
	public JPanel getDeck() {
		return this.deck;
	}
	
	public void creationOfStructure() {
		
	}
	
	public void updateStructure(Tray tray) {
		if(isFirstPlayer && !this.deckCards.equals(tray.firstPlayerDistrictCards())) {
			this.deckCards = tray.firstPlayerDistrictCards();
			updateStructure();
		}
		else if(!this.deckCards.equals(tray.secondPlayerDistrictCards())) {
			this.deckCards = tray.secondPlayerDistrictCards();
			updateStructure();
		}
				
	}
	
	private void updateStructure() {
		
	}
}
