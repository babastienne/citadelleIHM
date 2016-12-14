package vue;

import javax.swing.JLabel;
import javax.swing.JPanel;

import maxime.maheo.free.fr.game.Player;

public class Status {
	JPanel status;
	
	JLabel playerName;
	
	public Status(Player player) {
		this.status = new JPanel();
		
		creationOfStructure();
		
		updateStructure(player);
	}
	
	public JPanel getStatus() {
		return this.status;
	}
	
	public void creationOfStructure() {
		this.playerName = new JLabel();
		this.status.add(playerName);
	}
	
	public void updateStructure(Player player) {
		this.playerName.setText(player.getCoins() + "");
	}
	
}
