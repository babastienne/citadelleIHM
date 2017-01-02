package view;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.MouseActionStatus;
import maxime.maheo.free.fr.card.CardManager;
import maxime.maheo.free.fr.game.Player;
import view.abstraction.TangibleStruct;

public class Status implements TangibleStruct<JPanel> {
	
	private final static float CHARACTER_SIZE = 100.0f;
	private final ImageIcon DOSPERSONNAGE = resize("images/dos_personnage.jpg", CHARACTER_SIZE);
	
	private JPanel status;
	
	private JLabel lblPlayerName, lblPerso, lblPerso_1, lblOr, lblCouronn, lblPersonnageprotectioncondottiere;
	private JButton btnChoisirDeuxPices, btnChoisirUneCarte, btnActivationDuPouvoir;
	
	private Player player;
	private CardManager cardManager;
	private JButton btnFinishRound;
	private JButton btnActiverLeSecond;
//	private JLabel lblPickingCard;
//	private JLabel card1;
//	private JLabel card2;
	
	public Status(Player player, CardManager cardManager) {
		this.player = player;
		this.cardManager = cardManager;
		
		creationOfStructure();
		
		updateStructure();
	}
	
	public JPanel getView() {
		return this.status;
	}
	
	public void creationOfStructure() {
		this.status = new JPanel();
		
		GridBagLayout gbl_status = new GridBagLayout();
		gbl_status.columnWidths = new int[]{38, 0, 0};
		gbl_status.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_status.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_status.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		status.setLayout(gbl_status);
		this.lblPlayerName = new JLabel();
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 13));
		GridBagConstraints gbc_playerName = new GridBagConstraints();
		gbc_playerName.insets = new Insets(0, 0, 5, 0);
		gbc_playerName.gridwidth = 2;
		gbc_playerName.anchor = GridBagConstraints.NORTH;
		gbc_playerName.gridx = 0;
		gbc_playerName.gridy = 0;
		this.status.add(lblPlayerName, gbc_playerName);
		
		lblPerso = new JLabel();
		GridBagConstraints gbc_lblPerso = new GridBagConstraints();
		gbc_lblPerso.insets = new Insets(0, 0, 5, 5);
		gbc_lblPerso.gridx = 0;
		gbc_lblPerso.gridy = 1;
		status.add(lblPerso, gbc_lblPerso);
		
		lblPerso_1 = new JLabel();
		GridBagConstraints gbc_lblPerso_1 = new GridBagConstraints();
		gbc_lblPerso_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblPerso_1.gridx = 1;
		gbc_lblPerso_1.gridy = 1;
		status.add(lblPerso_1, gbc_lblPerso_1);
		
		lblOr = new JLabel();
		GridBagConstraints gbc_lblOr = new GridBagConstraints();
		gbc_lblOr.insets = new Insets(0, 0, 5, 5);
		gbc_lblOr.gridx = 0;
		gbc_lblOr.gridy = 2;
		status.add(lblOr, gbc_lblOr);
		
		lblCouronn = new JLabel();
		GridBagConstraints gbc_lblCouronn = new GridBagConstraints();
		gbc_lblCouronn.insets = new Insets(0, 0, 5, 0);
		gbc_lblCouronn.gridx = 1;
		gbc_lblCouronn.gridy = 2;
		status.add(lblCouronn, gbc_lblCouronn);
		
		btnChoisirDeuxPices = new JButton("Obtenir deux pièces d'or");
		btnChoisirDeuxPices.setName("pieces");
		GridBagConstraints gbc_btnChoisirDeuxPices = new GridBagConstraints();
		gbc_btnChoisirDeuxPices.gridwidth = 2;
		gbc_btnChoisirDeuxPices.insets = new Insets(0, 0, 5, 0);
		gbc_btnChoisirDeuxPices.gridx = 0;
		gbc_btnChoisirDeuxPices.gridy = 4;
		btnChoisirDeuxPices.addMouseListener(new MouseActionStatus(this.player));
		status.add(btnChoisirDeuxPices, gbc_btnChoisirDeuxPices);
		btnChoisirDeuxPices.setEnabled(false);
		
		btnChoisirUneCarte = new JButton("Choisir une carte parmi deux cartes de la pioche");
		btnChoisirUneCarte.setName("cartes");
		GridBagConstraints gbc_btnChoisirUneCarte = new GridBagConstraints();
		gbc_btnChoisirUneCarte.insets = new Insets(0, 0, 5, 0);
		gbc_btnChoisirUneCarte.gridwidth = 2;
		gbc_btnChoisirUneCarte.gridx = 0;
		gbc_btnChoisirUneCarte.gridy = 5;
		btnChoisirUneCarte.addMouseListener(new MouseActionStatus(this.player, this.cardManager));
		status.add(btnChoisirUneCarte, gbc_btnChoisirUneCarte);
		btnChoisirUneCarte.setEnabled(false);
		
		lblPersonnageprotectioncondottiere = new JLabel();
		GridBagConstraints gbc_lblPersonnageprotectioncondottiere = new GridBagConstraints();
		gbc_lblPersonnageprotectioncondottiere.gridwidth = 2;
		gbc_lblPersonnageprotectioncondottiere.insets = new Insets(0, 0, 5, 0);
		gbc_lblPersonnageprotectioncondottiere.gridx = 0;
		gbc_lblPersonnageprotectioncondottiere.gridy = 6;
		status.add(lblPersonnageprotectioncondottiere, gbc_lblPersonnageprotectioncondottiere);
		
		btnActivationDuPouvoir = new JButton("Activer le pouvoir du personnage");
		btnActivationDuPouvoir.setName("pouvoir");
		GridBagConstraints gbc_btnActivationDuPouvoir = new GridBagConstraints();
		gbc_btnActivationDuPouvoir.insets = new Insets(0, 0, 5, 0);
		gbc_btnActivationDuPouvoir.gridwidth = 2;
		gbc_btnActivationDuPouvoir.gridx = 0;
		gbc_btnActivationDuPouvoir.gridy = 7;
		btnActivationDuPouvoir.addMouseListener(new MouseActionStatus(player));
		status.add(btnActivationDuPouvoir, gbc_btnActivationDuPouvoir);
		btnActivationDuPouvoir.setEnabled(false);
		
		btnActiverLeSecond = new JButton("Activer le second pouvoir du personnage");
		btnActiverLeSecond.setName("pouvoirDeux");
		GridBagConstraints gbc_btnActiverLeSecond = new GridBagConstraints();
		gbc_btnActiverLeSecond.gridwidth = 2;
		gbc_btnActiverLeSecond.insets = new Insets(0, 0, 5, 0);
		gbc_btnActiverLeSecond.gridx = 0;
		gbc_btnActiverLeSecond.gridy = 8;
		btnActiverLeSecond.addMouseListener(new MouseActionStatus(this.player));
		status.add(btnActiverLeSecond, gbc_btnActiverLeSecond);
		btnActiverLeSecond.setEnabled(false);
		
//		lblPickingCard = new JLabel();
//		GridBagConstraints gbc_lblCliquezSurLa = new GridBagConstraints();
//		gbc_lblCliquezSurLa.gridwidth = 2;
//		gbc_lblCliquezSurLa.insets = new Insets(0, 0, 5, 0);
//		gbc_lblCliquezSurLa.gridx = 0;
//		gbc_lblCliquezSurLa.gridy = 9;
//		status.add(lblPickingCard, gbc_lblCliquezSurLa);
//		
//		card1 = new JLabel();
//		GridBagConstraints gbc_card1 = new GridBagConstraints();
//		gbc_card1.insets = new Insets(0, 0, 5, 5);
//		gbc_card1.gridx = 0;
//		gbc_card1.gridy = 10;
//		card1.addMouseListener(new MouseActionStatus(this.player, 0));
//		status.add(card1, gbc_card1);
//		
//		card2 = new JLabel();
//		GridBagConstraints gbc_card2 = new GridBagConstraints();
//		gbc_card2.insets = new Insets(0, 0, 5, 0);
//		gbc_card2.gridx = 1;
//		gbc_card2.gridy = 10;
//		card2.addMouseListener(new MouseActionStatus(this.player, 1));
//		status.add(card2, gbc_card2);
		
		btnFinishRound = new JButton("Finir le tour");
		btnFinishRound.setName("finish");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 11;
		btnFinishRound.addMouseListener(new MouseActionStatus(this.player));
		status.add(btnFinishRound, gbc_btnNewButton);
		btnFinishRound.setEnabled(false);
		
	}
	
	public void updateStructure() {
		this.lblPlayerName.setText(this.player.getName());
		
		if(this.player.isPlaying() && this.player.getFirstCharacter() != null)
			this.lblPerso.setIcon(resize(this.player.getFirstCharacter().getImage(), CHARACTER_SIZE));
		else 
			this.lblPerso.setIcon(DOSPERSONNAGE);
			
		if(this.player.isPlaying() && this.player.getSecondCharacter() != null)
			this.lblPerso_1.setIcon(resize(this.player.getSecondCharacter().getImage(), CHARACTER_SIZE));
		else
			this.lblPerso_1.setIcon(DOSPERSONNAGE);
		
		this.lblOr.setText("Or : " + String.valueOf(this.player.getCoins()));
		
		if(this.player.isCrowned())
			this.lblCouronn.setIcon(resize("images/couronne.jpg", CHARACTER_SIZE));
		else
			this.lblCouronn.setText("");
		
		if(this.player.getFirstCharacter() != null && this.player.getSecondCharacter() != null) {
			if(this.player.isPlayingCharacterNumber() == 5)
				this.lblPersonnageprotectioncondottiere.setText("Personnage protégé du condottiere");
		} else
			this.lblPersonnageprotectioncondottiere.setText("");
		
		if(!this.player.isHasUsedHisPower())
			this.btnActivationDuPouvoir.setEnabled(true);
		else
			this.btnActivationDuPouvoir.setEnabled(false);
		
		if(this.player.isHadToChooseBetweenGoldAndCards())
			this.btnChoisirDeuxPices.setEnabled(true);
		else
			this.btnChoisirDeuxPices.setEnabled(false);
		
		if(this.player.isHadToChooseBetweenGoldAndCards())
			this.btnChoisirUneCarte.setEnabled(true);
		else
			this.btnChoisirUneCarte.setEnabled(false);
		
		if(!this.player.isFinishRound())
			this.btnFinishRound.setEnabled(true);
		else
			this.btnFinishRound.setEnabled(false);
		
		if(!this.player.isHasUsedHisSecondPower())
			this.btnActiverLeSecond.setEnabled(true);
		else
			this.btnActiverLeSecond.setEnabled(false);
		
//		if(this.player.isPickingCard()) {
//			card1.setIcon(new ImageIcon(this.player.getDistrictCardsUsedToPick().get(0).getImage()));
//			card2.setIcon(new ImageIcon(this.player.getDistrictCardsUsedToPick().get(1).getImage()));
//			lblPickingCard.setText("Cliquez sur la carte \u00E0 conserver");
//		} else {
//			card1.setText("");
//			card2.setText("");
//			lblPickingCard.setText("");
//		}
	}

}
