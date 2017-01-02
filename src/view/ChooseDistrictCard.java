//package view;
//
//import java.awt.BorderLayout;
//import java.util.List;
//
//import javax.swing.ImageIcon;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//
//import application.Game;
//import listener.MouseActionStatus;
//import maxime.maheo.free.fr.card.district.District;
//import maxime.maheo.free.fr.game.Player;
//import view.abstraction.TangibleStruct;
//
//public class ChooseDistrictCard implements TangibleStruct<JPanel> {
//	
//	Game game;
//	
//	JPanel conteneur;
//	JPanel fenetre;
//
//	public ChooseDistrictCard(Game game) {
//		this.game = game;
//		
//		creationOfStructure();
//		
//		updateStructure();
//	}
//	
//	public void creationOfStructure() {
//		this.fenetre = new JPanel();
//		this.conteneur = new JPanel();
//	}
//	
//	public void updateStructure() {
//		if(game.getFirstPlayer().isPickingCard() || game.getSecondPlayer().isPickingCard()) {
//			Player player;
//			if(game.getFirstPlayer().isPickingCard())
//				player = game.getFirstPlayer();
//			else
//				player = game.getSecondPlayer();
//			
//
//			List<District> districts = player.getDistrictCardsUsedToPick();	
//			JLabel carte;
//			
//			int nbCard = 0;
//			for(District d : districts) {
//				carte = new JLabel(new ImageIcon(d.getImage()));
//				System.out.println(d.getImage());
//				carte.addMouseListener(new MouseActionStatus(player, nbCard));
//				carte.setName("chooseDistrict");
//				this.conteneur.add(carte);
//				nbCard++;
//			}
//			
//			JLabel lblNewLabel = new JLabel(player.getName() + ", cliquez sur le quartier que vous souhaitez conserver. Le quartier non choisi sera remis dans la pioche.");
//			this.fenetre.add(lblNewLabel, BorderLayout.NORTH);
//			
//			JScrollPane sp = new JScrollPane(conteneur);
//			this.fenetre.add(sp);
//		} else {
//			this.fenetre = new JPanel();
//		}
//	}
//	
//	public JPanel getView() {
//		return this.fenetre;
//	}
//}
