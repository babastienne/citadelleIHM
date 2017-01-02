package view;

import javax.swing.JPanel;

import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.game.Player;
import maxime.maheo.free.fr.game.Tray;

public class PlayerIHM {
	Status status;
	City city;
	Deck deck;
	
	public PlayerIHM(Player player, Tray tray, Boolean isFirstPlayer, CardManager cardManager) {
		this.status = new Status(player, cardManager);
		this.city = new City(tray, isFirstPlayer);
		this.deck = new Deck(player, tray);
	}
	
	public void updateStructure(Tray tray) {
		this.status.updateStructure();
		this.deck.updateStructure();
		this.city.updateStructure();
	}
	
	public JPanel getStatus() {
		return this.status.getView();
	}
	
	public JPanel getCity() {
		return this.city.getView();
	}
	
	public JPanel getDeck() {
		return this.deck.getView();
	}
}
