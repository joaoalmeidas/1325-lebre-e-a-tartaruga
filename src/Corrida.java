import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Corrida extends JPanel{

	private Coelho coelho;
	private Tartaruga tartaruga;
	private int[] pista;
	
	public Corrida() {
		
		coelho = new Coelho("Coelho", 1);
		tartaruga = new Tartaruga("Tartaruga", 2);
		pista = new int[300];
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.GREEN);
		
		g.fillArc(30, getHeight() / 2, getWidth() - 60, getHeight(), 0, 180);

		
	}
}
