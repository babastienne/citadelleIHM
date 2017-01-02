package view;

import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Tray;
import view.abstraction.TangibleStruct;

public class City implements TangibleStruct<JPanel> {
	JPanel city, conteneur;
	JScrollPane sp;
	
	List<District> cityCards;
	boolean isFirstPlayer;
	Tray tray;
	
	public City(Tray tray, boolean isFirstPlayer) {
		this.isFirstPlayer = isFirstPlayer;
		this.tray = tray;
		this.cityCards = (isFirstPlayer) ? tray.firstPlayerDistrictCards() : tray.secondPlayerDistrictCards();
		
		creationOfStructure();
		
		updateStructure();
	}
	
	public JPanel getView() {
		return this.city;
	}
	
	public void creationOfStructure() {
		this.city = new JPanel();
		
		this.conteneur = new JPanel();
	}
	
	public void updateStructure() {
		this.cityCards = (isFirstPlayer) ? this.tray.firstPlayerDistrictCards() : this.tray.secondPlayerDistrictCards();
		this.city.removeAll();
		this.conteneur = new JPanel();
		
		for(District d : this.cityCards) {
			JLabel carte = new JLabel(new ImageIcon(d.getImage()));
			this.conteneur.add(carte);
		}
		
		this.sp = new JScrollPane(conteneur);
		this.city.add(sp);
	}
	
}
