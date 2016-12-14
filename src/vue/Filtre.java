package vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.Obervers;

public class Filtre {
	
	JPanel filtre;

	public Filtre(String description, String[] args, Obervers o) {
		this.filtre = new JPanel();
		this.filtre.add(new JLabel(description));
		for(int i = 0; i < args.length; i++) {
			JButton arg = new JButton(args[i]);
			arg.addMouseListener(new MouseListener() {
				@Override public void mouseReleased(MouseEvent e) {} @Override public void mousePressed(MouseEvent e) {} @Override public void mouseExited(MouseEvent e) {} @Override public void mouseEntered(MouseEvent e) {} 
				@Override 
				public void mouseClicked(MouseEvent e) { 
					System.out.println(arg.getText()); 
					o.suppressionDuFiltre();
				} 
			});
			this.filtre.add(arg);
		}
	}
	
	public JPanel getFiltre() {
		return this.filtre;
	}
}
