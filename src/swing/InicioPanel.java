package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

import assets.Cor;
import principal.Sistema;
import swing.agenda.AgendamentoPanel;
import swing.agenda.NovoAgendamentoPanel;
import swing.alimentos.NovoAlimentoPanel;
import swing.pacientes.NovoPacientePanel;

public class InicioPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public InicioPanel() {
		setSize(540, 480);
		setLayout(null);
		
		JLabel lblConsultas = new JLabel("Próximas Consultas");
		lblConsultas.setFont(new Font("SanSerif", Font.BOLD, 14));
		lblConsultas.setForeground(Cor.principal);
		lblConsultas.setBounds(0, 0, 540, 30);
		add(lblConsultas);
		
		JLabel lblTarefas = new JLabel("Tarefas");
		lblTarefas.setFont(new Font("SanSerif", Font.BOLD, 14));
		lblTarefas.setForeground(Cor.principal);
		lblTarefas.setBounds(0, 270, 540, 30);
		add(lblTarefas);
		
		JLabel lblAgendarConsulta = new JLabel("Agendar Consulta...");
		lblAgendarConsulta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Janela janela = new Janela("Novo Agendamento");
				janela.setContent(new NovoAgendamentoPanel());
			}
		});
		lblAgendarConsulta.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAgendarConsulta.setForeground(Color.BLUE);
		lblAgendarConsulta.setBounds(20, 300, 110, 20);
		add(lblAgendarConsulta);
		
		JLabel lblCadastrarPaciente = new JLabel("Cadastrar Paciente...");
		lblCadastrarPaciente.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Janela janela = new Janela("Cadastrar Paciente");
				janela.setContent(new NovoPacientePanel());
			}
		});
		lblCadastrarPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCadastrarPaciente.setForeground(Color.BLUE);
		lblCadastrarPaciente.setBounds(20, 330, 120, 20);
		add(lblCadastrarPaciente);
		
		JLabel lblAdicionarAlimento = new JLabel("Adicionar Alimento no Cat\u00E1logo...");
		lblAdicionarAlimento.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Janela janela = new Janela("Adicionar Alimento");
				janela.setContent(new NovoAlimentoPanel());
			}
		});
		lblAdicionarAlimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblAdicionarAlimento.setForeground(Color.BLUE);
		lblAdicionarAlimento.setBounds(20, 360, 190, 20);
		add(lblAdicionarAlimento);
		
		JLabel lblCalcularImc = new JLabel("Calcular IMC...");
		lblCalcularImc.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Janela janela = new Janela("");
				janela.setContent(new ImcPanel());
			}
		});
		lblCalcularImc.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCalcularImc.setForeground(Color.BLUE);
		lblCalcularImc.setBounds(20, 390, 80, 20);
		add(lblCalcularImc);
		
		JLabel lblCalcularPesoIdeal = new JLabel("Calcular Peso Ideal...");
		lblCalcularPesoIdeal.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Janela janela = new Janela("");
				janela.setContent(new PesoIdealPanel());
			}
		});
		lblCalcularPesoIdeal.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		lblCalcularPesoIdeal.setForeground(Color.BLUE);
		lblCalcularPesoIdeal.setBounds(20, 420, 120, 20);
		add(lblCalcularPesoIdeal);
		
		for(int i = 0; i < 4; i++) {
			try {
				add(new AgendamentosPanel(30 + (60 * i), i));
			} catch (Exception e) {}
		}
	}
}

class AgendamentosPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	public AgendamentosPanel(int y, int index) {
		setBounds(0, y, 540, 60);
		setLayout(null);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				DefaultPanel.setPanel(new AgendamentoPanel(index));
			}
		});
		
		JLabel lblData = new JLabel(Sistema.getAgendamentos().get(index).getData().exibir());
		lblData.setBounds(20, 0, 520, 20);
		add(lblData);
		
		JLabel lblPaciente = new JLabel(Sistema.getAgendamentos().get(index).getPaciente().getNome());
		lblPaciente.setBounds(20, 20, 520, 20);
		add(lblPaciente);
	}
}
