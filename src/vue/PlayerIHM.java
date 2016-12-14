package vue;

import javax.swing.JPanel;

import maxime.maheo.free.fr.game.Player;
import maxime.maheo.free.fr.game.Tray;

public class PlayerIHM {
	Status status;
	City city;
	Deck deck;
	
	public PlayerIHM(Player player, Tray tray, Boolean isFirstPlayer) {
		this.status = new Status(player);
		this.city = new City(player);
		this.deck = new Deck(tray, isFirstPlayer);
	}
	
	public void update(Player player, Tray tray) {
		this.status.updateStructure(player);
		this.deck.updateStructure(tray);
		this.city.updateStructure(player);
	}
	
	public JPanel getStatus() {
		return this.status.getStatus();
	}
	
	public JPanel getCity() {
		return this.city.getCity();
	}
	
	public JPanel getDeck() {
		return this.deck.getDeck();
	}
}
