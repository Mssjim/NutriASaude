package principal;

import java.util.*;

import javax.swing.WindowConstants;

import swing.DefaultPanel;
import swing.Janela;
import swing.LoginPanel;

public class Sistema {
	private static Janela janela;
	private static String usuario;
	
	private static final ArrayList<Paciente> Pacientes = new ArrayList<>();
	private static final ArrayList<Paciente> Inativos = new ArrayList<>();
	private static final ArrayList<Agendamento> Agendamentos = new ArrayList<>();
	private static final ArrayList<Alimento> Alimentos = new ArrayList<>();
	
	public static void main(String[] args) {
		janela = new Janela("Nutri A+Saúde");
		janela.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		login();
	}
	
	private static void login() {
		janela.setContent(new LoginPanel());
	}
	
	public static void inicio(String usuario) {
		setUsuario(usuario);
		janela.setContent(new DefaultPanel());
	}
	
	public static void encerrarSessao() {
		setUsuario(null);
		login();
	}
	
// Getters e Setters
	public static String getUsuario() {
		return usuario;
	}

	private static void setUsuario(String usuario) {
		Sistema.usuario = usuario;
	}

	public static ArrayList<Paciente> getPacientes() {
		// Ordena ArrayList
		Pacientes.sort(Comparator.comparing(Paciente::getNome));
		return Pacientes;
	}

	public static ArrayList<Paciente> getInativos() {
		// Ordena ArrayList
		Inativos.sort(Comparator.comparing(Paciente::getNome));
		return Inativos;
	}

	public static ArrayList<Agendamento> getAgendamentos() {
		// Ordena ArrayList
		Agendamentos.sort((a1, a2) -> {
			Data d1 = a1.getData();
			Data d2 = a2.getData();
			return new Date(d1.getAno(), d1.getMes() + 1, d1.getDia(), d1.getHora(), d1.getMinutos()).compareTo(new Date(d2.getAno(), d2.getMes() + 1, d2.getDia(), d2.getHora(), d2.getMinutos()));
		});
		return Agendamentos;
	}

	public static ArrayList<Alimento> getAlimentos() {
		// Ordena ArrayList
		Alimentos.sort(Comparator.comparing(Alimento::getNome));
		return Alimentos;
	}
}
