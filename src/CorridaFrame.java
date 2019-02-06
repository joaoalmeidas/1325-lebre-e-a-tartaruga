import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CorridaFrame extends JFrame{
	
	private JPanel panel;
	private JButton botao;
	private Corrida corrida;
	
	public CorridaFrame() {
		
		panel = new JPanel(new FlowLayout());
		botao = new JButton("Iniciar corrida!");
		corrida = new Corrida();
		botao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				corrida.iniciaCorrida();
				
			}
			
			
			
		});
		
		
		panel.add(botao);
		
		add(panel, BorderLayout.NORTH);
		add(corrida);
		
		repaint();
		
	}

}
