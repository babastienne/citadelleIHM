package vue;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class test extends JFrame {
	
	StatJoueur stat;
	Filtre filtre;
	
	public test() {
		JPanel panneauStat = new JPanel();
		stat = new StatJoueur(5, "Papa");
		panneauStat.add(stat.getMoney());
		panneauStat.add(stat.getPrenom());

		
		this.getContentPane().add(panneauStat);
		this.setMinimumSize(new Dimension(800, 1000));
		this.pack();
	}
	
	public void miseAJour() {
		stat.setName("Maman");
		stat.setMoney(10);
	}
	
	public void ajouterFiltre(Filtre f) {
		this.filtre = f;
		JPanel filtre = this.filtre.getFiltre();
		this.add(filtre);
		this.pack();		
	}
	
	public void suppressionFiltre() {
		System.out.println("suppression du filtre");
		this.getContentPane().remove(this.filtre.getFiltre());
	}
}
