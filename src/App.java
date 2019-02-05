import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class App {

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		frame.setLayout(new BorderLayout());
		JPanel panelControle = new JPanel(new FlowLayout());
		
		JLabel label = new JLabel();
		JButton botao = new JButton("Iniciar");
		Corrida corrida = new Corrida();
		
		panelControle.add(botao);
		panelControle.add(label);
		
		frame.add(panelControle, BorderLayout.NORTH);
		frame.add(corrida);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}

}
