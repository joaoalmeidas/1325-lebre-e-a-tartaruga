
public class Tartaruga {
	
	private String nome;
	private int numero;

	public Tartaruga(String nome, int numero) {
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

	public int movimentaTartaruga(int random){
		int movimento = 0;
		
		if(random >= 1 && random <= 5){
			//caminha rapida
			movimento = 3;
		}
		else if(random > 5 && random <= 7){
			//escorregão
			movimento = -6;
		}
		else if(random > 7 && random <= 10){
			//caminha lenta
			movimento = 1;
		}
		return movimento;
	}
}
