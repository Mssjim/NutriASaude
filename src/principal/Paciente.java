package principal;

public class Paciente {
	private Data dataNascimento;   // Armazena a Data de Nascimento do Paciente
	private Endereco endereco;    // Armazena o Endereço do Paciente
	private String cpf;          // Armazena o CPF do Paciente
	private String descricao;   // Armazena a Descrição do Paciente
	private String email;      // Armazena o E-Mail do Paciente
	private String nome;      // Armazena o Nome do Paciente
	private String telefone; // Armazena o Telefone do Paciente
	private float altura;   // Armazena a Altura do Paciente em Metros
	private float peso;    // Armazena o Peso do Paciente em Quilos
	private int genero;   // Armazena o Gênero do Paciente [1 - Masculino; 2 - Feminino]
	private float alturaInicial; // Armazena a Altura Inicial do Paciente
	private float pesoInicial;  // Armazena o Peso Inicial do Paciente
	
// Construtor
	public Paciente(Data dataNascimento, Endereco endereco, String cpf, String descricao, String email, String nome, String telefone, float altura, float peso, int genero) {
		setDataNascimento(dataNascimento);
		setEndereco(endereco);
		setCpf(cpf);
		setDescricao(descricao);
		setEmail(email);
		setNome(nome);
		setTelefone(telefone);
		setAltura(altura);
		setPeso(peso);
		setGenero(genero);
	}

// Métodos
	// Retorna o IMC do Paciente
	public float calcularIMC() {
		return peso/(altura*altura);
	}

	// Retorna a Idade do Paciente
	public int calcularIdade() {
		Data dataAtual = new Data();
	
		int idade = dataAtual.getAno() - dataNascimento.getAno();
		
		if (dataAtual.getMes() < dataNascimento.getMes()) {
			idade--;
		} else if (dataAtual.getMes() == dataNascimento.getMes()) {
			if (dataAtual.getDia() < dataNascimento.getDia()) {
				idade--;
			}
		}
		
		return idade;
	}

// Getters e Setters
	public Data getDataNascimento() {
		return dataNascimento;
	}

	private void setDataNascimento(Data dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	private void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	private void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getEmail() {
		return email;
	}

	private void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	private void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	private void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public float getAltura() {
		return altura;
	}

	public void setAltura(float altura) {
		this.altura = altura;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getGenero() {
		return genero;
	}

	private void setGenero(int genero) {
		this.genero = genero;
	}

	public float getAlturaInicial() {
		return alturaInicial;
	}

	public void setAlturaInicial(float alturaInicial) {
		this.alturaInicial = alturaInicial;
	}

	public float getPesoInicial() {
		return pesoInicial;
	}

	public void setPesoInicial(float pesoInicial) {
		this.pesoInicial = pesoInicial;
	}	
}
