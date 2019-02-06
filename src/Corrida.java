import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JPanel;
import javax.swing.Timer;


public class Corrida extends JPanel implements ActionListener{

	private Coelho coelho;
	private Tartaruga tartaruga;
	private int[] pista;
	private boolean inicio;
	private Timer tempo;	
	
	public Corrida() {
		
		coelho = new Coelho("Coelho", 1);
		tartaruga = new Tartaruga("Tartaruga", 2);
		inicio = false;
		pista = new int[300];
		pista[0] += coelho.getNumero();
		pista[0] += tartaruga.getNumero();
		tempo = new Timer(10, this);
		tempo.start();
	}
	
	public void atualizaCorrida() {
		
		final SecureRandom aleatorio = new SecureRandom();
		int posicaoTartaruga;
		int posicaoCoelho;
		int movimentoCoelho, movimentoTartaruga;
		
		
		if(contemNumero(3, pista)) {
			
			posicaoTartaruga = buscaIndice(3, pista);
			pista[buscaIndice(3, pista)] -= tartaruga.getNumero();
			posicaoCoelho = buscaIndice(coelho.getNumero(), pista);
			pista[buscaIndice(coelho.getNumero(), pista)] -= coelho.getNumero();
			
			
		}else {
			
			posicaoTartaruga = buscaIndice(tartaruga.getNumero(), pista);
			pista[buscaIndice(tartaruga.getNumero(), pista)] -= tartaruga.getNumero();
			posicaoCoelho = buscaIndice(coelho.getNumero(), pista);
			pista[buscaIndice(coelho.getNumero(), pista)] -= coelho.getNumero();
			
		}
		
		movimentoCoelho = coelho.movimentaCoelho(1 + aleatorio.nextInt(10));
		movimentoTartaruga = tartaruga.movimentaTartaruga(1 + aleatorio.nextInt(10));
		
		if(movimentoCoelho + posicaoCoelho >= pista.length ) {
			
			pista[pista.length-1] += coelho.getNumero();
			
		}else if(movimentoCoelho + posicaoCoelho < 0) {
			
			pista[0] += coelho.getNumero();	
			
		}else {
			
			pista[movimentoCoelho + posicaoCoelho] += coelho.getNumero();
			
		}
		
		if(movimentoTartaruga + posicaoTartaruga >= pista.length ) {
			
			pista[pista.length-1] += tartaruga.getNumero();
			
		}else if(movimentoTartaruga + posicaoTartaruga < 0) {
			
			pista[0] += tartaruga.getNumero();	
			
		}else {
			
			pista[movimentoTartaruga + posicaoTartaruga] += tartaruga.getNumero();
			
		}
		
		System.out.println(posicaoTartaruga);
		System.out.println(movimentoTartaruga);
		
		for(int i = 0 ; i < pista.length; i++) {
			System.out.printf("%d,", pista[i]);
		}
		System.out.println();
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillArc(0, 20, getWidth(), getHeight() * 2, 0, 180);
		
		g.setColor(Color.GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 10));
		
		if(inicio == false) {
			
			g.drawString("Inicia a corrida!", getWidth()/2 - 10, getHeight() - 10);
			
			inicio = true;
			
		}else {
			
			if(pista[pista.length - 1] == 0) {
				
				if(contemNumero(coelho.getNumero(), pista)) {
					
					g.drawString("Coelho", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(coelho.getNumero(), pista) );
					
				}
				
				if(contemNumero(tartaruga.getNumero(), pista)) {
					
					g.drawString("Tartaruga", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(tartaruga.getNumero(), pista) );
					
				}
			
				if(contemNumero(3, pista)) {
					
					g.drawString("Coelho", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(3, pista) );
					g.drawString("Tartaruga", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(3, pista) );
					
				}
				
			}else {
				
				if(pista[pista.length - 1] == coelho.getNumero()) {
					
					g.drawString("O COELHO VENCEU!!! =D", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(coelho.getNumero(), pista) );
					g.drawString("Tartaruga :c", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(tartaruga.getNumero(), pista) );
					
				}else if(pista[pista.length - 1] == tartaruga.getNumero()) {
					
					g.drawString("Coelho :c", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(coelho.getNumero(), pista) );
					g.drawString("A TARTARUGA VENCEU!!! =D", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(tartaruga.getNumero(), pista) );
					
				}else {
					
					g.drawString("HOUVE UM EMPATE!!!", getWidth()/2 - 10, getHeight() - getHeight() / 300 * buscaIndice(3, pista) );
					
				}
				
			}
			
		}
		
		if(!(pista[pista.length - 1] == coelho.getNumero() || pista[pista.length - 1] == tartaruga.getNumero() || pista[pista.length - 1] == 3 )) {
			
			atualizaCorrida();
			
		}
		
		
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {

		repaint();
		
	}

	public boolean contemNumero(int numero, int array[]) {
		
		for(int i = 0; i < array.length; i++) {
			
			if(numero == array[i]) {
				
				return true;
				
			}
			
		}
		
		return false;
	}
	
	public int buscaIndice(int numero, int array[]) {
		
		for(int i = 0; i < array.length; i++) {
			
			if(array[i] == numero) {
				
				return i;
				
			}
			
		}
		
		return 0;
	}
}
