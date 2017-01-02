package view.abstraction;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

public interface ImageSize {

	public default ImageIcon resize(String pathToImage, float size) {
		ImageIcon image = new ImageIcon(pathToImage);
		
		float ratio = Math.max(image.getIconWidth(), image.getIconHeight());
		int largeur = (int) (size * (float) image.getIconWidth() / ratio);
		int hauteur = (int) (size * (float) image.getIconHeight() / ratio);

		BufferedImage buf = new BufferedImage(largeur, hauteur,	BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = buf.createGraphics();
		g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		g.drawImage(image.getImage(), 0, 0, largeur, hauteur, null);
		g.dispose();

		return (new ImageIcon(buf));
	}
}
