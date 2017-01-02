package view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import listener.MouseActionStatus;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Player;
import maxime.maheo.free.fr.game.Tray;
import view.abstraction.TangibleStruct;

public class Deck implements TangibleStruct<JPanel> {
	private final ImageIcon DOSQUARTIER = new ImageIcon("images/dos_quartier.jpg");
	
	JPanel deck, conteneur;
	JScrollPane sp;
	
	boolean isFirstPlayer;
	boolean isPlaying;
	Player player;
	Tray tray;
	
	public Deck(Player player, Tray tray) {
		this.player = player;
		this.tray = tray;
		this.isPlaying = false;
		
		creationOfStructure();
		
		updateStructure();
	}
	
	public JPanel getView() {
		return this.deck;
	}
	
	public void creationOfStructure() {
		this.deck = new JPanel();
	}
	
	public void updateStructure() {
		this.deck.removeAll();
		this.conteneur = new JPanel();
		JLabel carte;
		
		int cardNumber = 0;
		for(District d : this.player.getDistrictCards()) {
			if(this.player.isPlaying()) {
				carte = new JLabel(new ImageIcon(d.getImage()));
				carte.addMouseListener(new MouseActionStatus(this.player, d, tray, cardNumber));
				carte.setName("carte");
			} else
				carte = new JLabel(DOSQUARTIER);
			this.conteneur.add(carte);
			cardNumber++;
		}
		
		this.sp = new JScrollPane(conteneur);
		this.deck.add(sp);
	}

}
