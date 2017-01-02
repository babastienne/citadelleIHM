package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import application.Game;
import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.card.district.District;
import maxime.maheo.free.fr.game.Bank;
import maxime.maheo.free.fr.game.Player;
import maxime.maheo.free.fr.game.Tray;
import view.Window;

public class MouseActionStatus implements MouseListener {
	
	private Player player;
	private CardManager cardManager;
	private District district;
	private Tray tray;
	private int cardNumber;
//	private int nbCard;
	
	public MouseActionStatus(Player player) {
		this.player = player;
	}
	
//	public MouseActionStatus(Player player, int number) {
//		this.player = player;
//		this.nbCard = number;
//	}
	
	public MouseActionStatus(Player player, CardManager cardManager) {
		this.player = player;
		this.cardManager = cardManager;
	}
	
	public MouseActionStatus(Player player, District distrcit, Tray tray, int cardNumber) {
		this.player = player;
		this.district = distrcit;
		this.tray = tray;
		this.cardNumber = cardNumber;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource().getClass().equals(JButton.class)) {
			JButton bouton = (JButton)e.getSource();
			if(bouton.isEnabled()) {
				if(bouton.getName() == "pieces")
					giveTwoGoldCoins();
				else if(bouton.getName() == "cartes")
					chooseDistrictCard();
				else if(bouton.getName() == "pouvoir")
					launchPowerCharacter();
				else if(bouton.getName() == "pouvoirDeux")
					launchPowerSoldier();
				else if(bouton.getName() == "finish")
					finishRound();
				else
					System.out.println("ERROR, unknown button : " + bouton.getText());
			}
		} else if(e.getSource().getClass().equals(JLabel.class)) {
			JLabel label = (JLabel)e.getSource();
			if(label.getName() == "carte") {
				placeDistrictCard();
			} else if(label.getName() == "chooseDistrict") {
				chooseDistrict();
			} else {
				System.out.println("ERROR, label unknown : " + label.toString());
			}
		} else {
			System.out.println("ERROR, event unknown :" + e.getSource().getClass() + e.toString());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}
	@Override
	public void mouseExited(MouseEvent e) {
	}
	@Override
	public void mousePressed(MouseEvent e) {
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	private void giveTwoGoldCoins() {
		this.player.setCoins(this.player.getCoins() + Bank.getInstance().giveCoins(2));
		this.player.setHadToChooseBetweenGoldAndCards(false);
	}
	
	private void chooseDistrictCard() {
//		EventQueue.invokeLater(new Runnable() {
//			
//			@Override
//			public void run() {
				player.chooseDistrictCard(cardManager);
//			}
//		});
		this.player.setHadToChooseBetweenGoldAndCards(false);
	}
	
	private void launchPowerCharacter() {
		System.out.println("launchPower");
		Game.getInstance().characterPower(this.player);
		this.player.setHasUsedHisPower(true);
	}
	
	private void launchPowerSoldier() {
		if(this.player.hasCharacterWithNumber(8)) {
			Game.getInstance().secondPower(this.player);
		}
		this.player.setHasUsedHisSecondPower(true);
		Game.getInstance().secondPower(this.player);
	}
	
	private void finishRound() {
		this.player.setFinishRound(true);
	}
	
	private void placeDistrictCard() {
		System.out.println("carte :" + this.district.toString());
		if(!this.player.isHadToChooseBetweenGoldAndCards() && this.player.isPlaying()) {
			this.player.placeDistrictCard(this.district, this.tray, this.cardNumber);
			Window.getInstance().updateStructure(Game.getInstance());
		}
	}
	
	private void chooseDistrict() {
//		this.player.setNbCardPicking(this.nbCard);
//		this.player.setIsPickingCard(false);
	}

}
