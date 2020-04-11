package principal;

public class Endereco {
// Atributos
	private String bairro;   // Armazena o Bairro do Endereço
	private String cep;     // Armazena o CEP do Endereço
	private String cidade; // Armazena a Cidade do Endereço
	private String rua;   // Armazena a Rua do Endereço
	private int numero;  // Armazena o Número do Endereço

// Construtor
	public Endereco(String bairro, String cep, String cidade, String rua, int numero) {
		setBairro(bairro);     // Define o Bairro
		setCep(cep);          // Define o CEP
		setCidade(cidade);   // Define a Cidade
		setRua(rua);        // Define a Rua
		setNumero(numero); // Define o Número
	}

	// Getters e Setters
	public String getBairro() {
		return bairro;
	}

	private void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	private void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getRua() {
		return rua;
	}

	private void setRua(String rua) {
		this.rua = rua;
	}

	public String getCep() {
		return cep;
	}

	private void setCep(String cep) {
		this.cep = cep;
	}

	public int getNumero() {
		return numero;
	}

	private void setNumero(int numero) {
		this.numero = numero;
	}
}
