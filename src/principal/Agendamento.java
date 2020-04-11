package principal;

public class Agendamento {
// Atributos
	private Data data;
	private Paciente paciente;
	private String descricao;
	

// Construtor
	public Agendamento(Data data, Paciente paciente, String descricao) {
		setData(data);
		setPaciente(paciente);
		setDescricao(descricao);
	}
	
// Getters e Setters
	public Paciente getPaciente() {
		return paciente;
	}
	
	private void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Data getData() {
		return data;
	}
	
	private void setData(Data data) {
		this.data = data;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
