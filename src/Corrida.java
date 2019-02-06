import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.swing.JPanel;

public class Corrida extends JPanel{

	private Coelho coelho;
	private Tartaruga tartaruga;
	private int[] pista;
	
	public Corrida() {
		
		coelho = new Coelho("Coelho", 1);
		tartaruga = new Tartaruga("Tartaruga", 2);
		pista = new int[300];
		pista[0] += coelho.getNumero();
		pista[0] += tartaruga.getNumero();
	}
	
	public void geraRodadaCorrida() {
		
		final SecureRandom aleatorio = new SecureRandom();
		final int posicaoTartaruga;
		final int posicaoCoelho;
		int movimentoCoelho, movimentoTartaruga;
		
		System.out.println(pista.toString());
		
		if(contemNumero(3, pista)) {
			
			System.out.println(pista.toString().indexOf("3"));
			
			posicaoTartaruga = pista[pista.toString().indexOf("3")];
			pista[pista.toString().indexOf("3")] -= tartaruga.getNumero();
			System.out.println(pista[0]);
			posicaoCoelho = pista[pista.toString().indexOf("1")];
			pista[pista.toString().indexOf("1")] -= coelho.getNumero();
			
			
		}else {
			
			posicaoTartaruga = pista[pista.toString().indexOf("2")];
			pista[pista.toString().indexOf("2")] -= tartaruga.getNumero();
			posicaoCoelho = pista[pista.toString().indexOf("1")];
			pista[pista.toString().indexOf("1")] -= coelho.getNumero();
			
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
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillArc(0, 20, getWidth(), getHeight() * 2, 0, 180);
		
		g.setColor(Color.GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		
		if(pista.toString().contains("3") == true) {
			
			g.drawString("Coelho Tartaruga", getWidth()/4, getHeight() - getHeight() / pista.length * pista.toString().indexOf("3"));
			
		}
		
		geraRodadaCorrida();
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
				
				return numero;
				
			}
			
		}
		
		return false;
	}
}
