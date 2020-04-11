package principal;

public class Alimento {
// Atributos
	private String nome;
	private int calorias;
	private int carboidratos; // gramas
	private int gorduras;    // miligramas
	private int porcao;     // gramas
	private int proteina;  // miligramas
	private int sodio;    // miligramas
	
// Construtor
	public Alimento(String nome, int calorias, int carboidratos, int gorduras, int porcao, int proteina, int sodio) {
		setNome(nome);
		setCalorias(calorias);
		setCarboidratos(carboidratos);
		setGorduras(gorduras);
		setPorcao(porcao);
		setProteina(proteina);
		setSodio(sodio);
	}
	
// Getters e Setters
	public String getNome() {
		return nome;
	}
	
	private void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getCalorias() {
		return calorias;
	}
	
	private void setCalorias(int calorias) {
		this.calorias = calorias;
	}
	
	public int getCarboidratos() {
		return carboidratos;
	}
	
	private void setCarboidratos(int carboidratos) {
		this.carboidratos = carboidratos;
	}
	
	public int getGorduras() {
		return gorduras;
	}
	
	private void setGorduras(int gorduras) {
		this.gorduras = gorduras;
	}
	
	public int getPorcao() {
		return porcao;
	}
	
	private void setPorcao(int porcao) {
		this.porcao = porcao;
	}
	
	public int getProteina() {
		return proteina;
	}
	
	private void setProteina(int proteina) {
		this.proteina = proteina;
	}
	
	public int getSodio() {
		return sodio;
	}
	
	private void setSodio(int sodio) {
		this.sodio = sodio;
	}
}
