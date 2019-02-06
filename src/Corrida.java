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
		
		if(contemNumero(3, pista)) {
			
			posicaoTartaruga = pista[buscaIndice(3, pista)];
			pista[buscaIndice(3, pista)] -= tartaruga.getNumero();
			posicaoCoelho = pista[buscaIndice(coelho.getNumero(), pista)];
			pista[buscaIndice(coelho.getNumero(), pista)] -= coelho.getNumero();
			
			
		}else {
			
			posicaoTartaruga = pista[buscaIndice(tartaruga.getNumero(), pista)];
			pista[buscaIndice(tartaruga.getNumero(), pista)] -= tartaruga.getNumero();
			posicaoCoelho = pista[buscaIndice(coelho.getNumero(), pista)];
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
		System.out.println(posicaoCoelho);
		
	}
	
	@Override
	public void paintComponent(Graphics g) {
		
		g.setColor(Color.GREEN);
		g.fillArc(0, 20, getWidth(), getHeight() * 2, 0, 180);
		
		g.setColor(Color.GRAY);
		g.setFont(new Font("Arial", Font.PLAIN, 20));
		
		
		
		
		if(contemNumero(3, pista)) {
			
			g.drawString("Coelho Tartaruga", getWidth()/2 - 20, getHeight() - getHeight() / pista.length * pista.toString().indexOf("3"));
			
		}else if(contemNumero(1, pista)) {
			
			//g.drawString("Coelho", getWidth()/2, );
			
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
		
		return 0;
	}
}
