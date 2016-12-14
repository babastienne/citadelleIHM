package vue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class StatJoueur extends JFrame {
	
	JLabel money;
	JLabel name;

	public StatJoueur(int money, String name) {
		this.money = new JLabel(money + "");
		this.name = new JLabel(name);
	}
	
	public void setName(String name) {
		this.name.setText(name);
	}
	
	public void setMoney(int money) {
		this.money.setText("" + money);
	}
	
	public JLabel getMoney() {
		return this.money;
	}
	
	public JLabel getPrenom() {
		return this.name;
	}
}
