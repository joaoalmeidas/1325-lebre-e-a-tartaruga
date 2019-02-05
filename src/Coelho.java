
public class Coelho {
	
	private String nome;
	private int numero;

	public Coelho(String nome, int numero) {
		super();
		this.nome = nome;
		this.numero = numero;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int movimentaCoelho(int random){
		int movimento = 0;
		
		if(random >= 1 && random <= 2){
			//dormir
			movimento = 0;
		}
		else if(random > 2 && random <= 4){
			//salto grande
			movimento = 9;
		}
		else if(random > 4 && random <= 5){
			//escorregão grande
			movimento = -12;
		}
		else if(random > 5 && random <= 8){
			//salto pequeno
			movimento = 1;
		}
		else if(random > 8 && random <= 10){
			//escorregao pequeno
			movimento = -2;
		}
		
		return movimento;
	}
}
