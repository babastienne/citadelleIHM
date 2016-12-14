import controller.Obervers;
import vue.Filtre;
import vue.test;

public class Application {
	
	public static void main(String[] args) {
		test fen = new test();
		fen.setVisible(true);
		Obervers obs = new Obervers(fen);
		
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		
		fen.miseAJour();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println("ERROR : " + e.getMessage());
		}
		
		String[] arg =  {"Deux pièces d'or", "Deux cartes"};
		Filtre f = new Filtre("Choisir entre deux pièces d'or ou deux cartes dans la pioche", arg, obs);
		fen.ajouterFiltre(f);
	}
}
