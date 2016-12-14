package vue;

import java.util.List;

import javax.swing.JPanel;

import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Player;

public class City {
	JPanel city;
	
	List<District> cityCards;
	
	public City(Player player) {
		this.city = new JPanel();
		
		creationOfStructure();
		
		updateStructure(player);
	}
	
	public JPanel getCity() {
		return this.city;
	}
	
	public void creationOfStructure() {
		
	}
	
	public void updateStructure(Player player) {
		if(!this.cityCards.equals(player.getDistrictCards())) {
			
		}
	}
}
