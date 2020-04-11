package swing.agenda;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import assets.Cor;
import principal.Agendamento;
import principal.Sistema;
import swing.DefaultPanel;
import swing.Janela;

public class AgendamentoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int index;

	public AgendamentoPanel(int index) {
		this.index = index;
		Agendamento agendamento = Sistema.getAgendamentos().get(index);
		setSize(540, 480);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 520, 400);
		panel.setLayout(null);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditar.setBounds(410, 430, 120, 40);
		btnEditar.addActionListener(editar);
		add(btnEditar);
				
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(10, 10, 520, 400);	
		scrollPanel.setViewportView(panel);
		
		JPanel data = new JPanel();
		data.setLayout(null);
		data.setBorder(new TitledBorder(null, "Data / Horário", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		data.setBounds(0, 0, 515, 70);
		panel.add(data);
		
		JLabel fldData = new JLabel(agendamento.getData().exibir());
		fldData.setHorizontalAlignment(SwingConstants.CENTER);
		fldData.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldData.setBounds(5, 20, 505, 30);
		data.add(fldData);
		
		JPanel paciente = new JPanel();
		paciente.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paciente.setBounds(0, 70, 515, 160);
		panel.add(paciente);
		paciente.setLayout(null);
		
		JLabel fldGenero = new JLabel();
		fldGenero.setBounds(470, 5, 40, 40);
		fldGenero.setFont(new Font("SansSerif", Font.BOLD, 30));
		fldGenero.setHorizontalAlignment(SwingConstants.CENTER);
		if(agendamento.getPaciente().getGenero() == 1) {
			fldGenero.setText("♂");
			fldGenero.setForeground(Cor.masculino);
		} else {
			fldGenero.setText("♀");
			fldGenero.setForeground(Cor.feminino);
		}
		paciente.add(fldGenero);
		
		JLabel lblNome = new JLabel(agendamento.getPaciente().getNome());
		lblNome.setBounds(0, 0, 515, 60);
		paciente.add(lblNome);
		lblNome.setForeground(Cor.principal);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 70, 80, 30);
		paciente.add(lblIdade);
		lblIdade.setForeground(Cor.principal);
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JLabel fldIdade = new JLabel(agendamento.getPaciente().calcularIdade() + " Anos");
		fldIdade.setBounds(95, 70, 80, 30);
		paciente.add(fldIdade);
		fldIdade.setHorizontalAlignment(SwingConstants.LEFT);
		fldIdade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setForeground(new Color(29, 131, 72));
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAltura.setBounds(180, 70, 80, 30);
		paciente.add(lblAltura);
		
		JLabel fldAltura = new JLabel(agendamento.getPaciente().getAltura() + "m");
		fldAltura.setHorizontalAlignment(SwingConstants.LEFT);
		fldAltura.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldAltura.setBounds(265, 70, 80, 30);
		paciente.add(fldAltura);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setForeground(new Color(29, 131, 72));
		lblPeso.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblPeso.setBounds(350, 70, 80, 30);
		paciente.add(lblPeso);
		
		JLabel fldPeso = new JLabel(agendamento.getPaciente().getPeso() + "kg");
		fldPeso.setHorizontalAlignment(SwingConstants.LEFT);
		fldPeso.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldPeso.setBounds(435, 70, 80, 30);
		paciente.add(fldPeso);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImc.setForeground(new Color(29, 131, 72));
		lblImc.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblImc.setBounds(10, 110, 80, 30);
		paciente.add(lblImc);
		
		JLabel fldImc = new JLabel(String.format("%.2f", agendamento.getPaciente().calcularIMC()));
		fldImc.setHorizontalAlignment(SwingConstants.LEFT);
		fldImc.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldImc.setBounds(95, 110, 80, 30);
		paciente.add(fldImc);
		
		JLabel lblAlturaInicial = new JLabel("Inicial:");
		lblAlturaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlturaInicial.setForeground(new Color(29, 131, 72));
		lblAlturaInicial.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblAlturaInicial.setBounds(180, 95, 80, 15);
		
		JLabel fldAlturaInicial = new JLabel(agendamento.getPaciente().getAlturaInicial() + "m");
		fldAlturaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		fldAlturaInicial.setFont(new Font("SansSerif", Font.PLAIN, 11));
		fldAlturaInicial.setBounds(265, 95, 80, 15);
		
		JLabel lblPesoInicial = new JLabel("Inicial:");
		lblPesoInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoInicial.setForeground(new Color(29, 131, 72));
		lblPesoInicial.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblPesoInicial.setBounds(350, 95, 80, 15);
		
		JLabel fldPesoInicial = new JLabel(agendamento.getPaciente().getPesoInicial() + "kg");
		fldPesoInicial.setHorizontalAlignment(SwingConstants.LEFT);
		fldPesoInicial.setFont(new Font("SansSerif", Font.PLAIN, 11));
		fldPesoInicial.setBounds(435, 95, 80, 15);
		
		JLabel fldIMC = new JLabel();
		fldIMC.setHorizontalAlignment(SwingConstants.CENTER);
		fldIMC.setForeground(new Color(29, 131, 72));
		fldIMC.setFont(new Font("SansSerif", Font.BOLD, 11));
		fldIMC.setBounds(10, 135, 165, 15);
		
		// Avalia Situação
		if(agendamento.getPaciente().calcularIMC() < 17)
			fldIMC.setText("Muito Abaixo do Peso");
		else if(agendamento.getPaciente().calcularIMC() < 18.5)
			fldIMC.setText("Abaixo do Peso");
		else if(agendamento.getPaciente().calcularIMC() < 25)
			fldIMC.setText("Peso Normal");
		else if(agendamento.getPaciente().calcularIMC() < 30)
			fldIMC.setText("Acima do Peso");
		else if(agendamento.getPaciente().calcularIMC() < 35)
			fldIMC.setText("Obesidade I");
		else if(agendamento.getPaciente().calcularIMC() < 40)
			fldIMC.setText("Obesidade II");
		else
			fldIMC.setText("Obesidade III");
		
		paciente.add(fldIMC);
		
		JLabel lblMeta = new JLabel("Meta:");
		lblMeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMeta.setForeground(new Color(29, 131, 72));
		lblMeta.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMeta.setBounds(180, 110, 80, 30);
		paciente.add(lblMeta);
		
		float meta = 22 * (agendamento.getPaciente().getAltura()* agendamento.getPaciente().getAltura());
		
		JLabel fldMeta = new JLabel(String.format("%.2f", meta) + "kg");
		fldMeta.setHorizontalAlignment(SwingConstants.LEFT);
		fldMeta.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldMeta.setBounds(265, 110, 80, 30);
		paciente.add(fldMeta);
		
		JLabel fldMETA = new JLabel();
		fldMETA.setHorizontalAlignment(SwingConstants.CENTER);
		fldMETA.setForeground(new Color(29, 131, 72));
		fldMETA.setFont(new Font("SansSerif", Font.BOLD, 11));
		fldMETA.setBounds(180, 135, 165, 15);
		if(meta - agendamento.getPaciente().getPeso() == 0) {
			fldMETA.setText("Peso Ideal");
		} else if(meta - agendamento.getPaciente().getPeso() < 0) {
			fldMETA.setText("Perda de " + String.format("%.2f", (agendamento.getPaciente().getPeso() - meta)) + "kg");
		} else {
			fldMETA.setText("Ganho de " + String.format("%.2f", (meta - agendamento.getPaciente().getPeso())) + "kg");
		}
		paciente.add(fldMETA);
		
		JLabel fldCpf = new JLabel(agendamento.getPaciente().getCpf());
		fldCpf.setHorizontalAlignment(SwingConstants.CENTER);
		fldCpf.setForeground(new Color(29, 131, 72));
		fldCpf.setFont(new Font("SansSerif", Font.BOLD, 14));
		fldCpf.setBounds(0, 45, 515, 20);
		paciente.add(fldCpf);
		
		JPanel descricao = new JPanel();
		descricao.setLayout(null);
		descricao.setBorder(new TitledBorder(null, "Descrição", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		descricao.setBounds(0, 230, 515, 165);
		panel.add(descricao);
		
		JTextArea fldDescricao = new JTextArea(agendamento.getDescricao());
		fldDescricao.setEditable(false);
		fldDescricao.setBounds(0, 0, 495, 70);
		fldDescricao.setBackground(new Color(0, 0, 0, 0));
		
		JScrollPane scrollDescricao = new JScrollPane(fldDescricao);
		scrollDescricao.setBounds(10, 20, 495, 135);
		descricao.add(scrollDescricao);
		
		if(agendamento.getPaciente().getEndereco().getNumero() != -1) {
    		JLabel fldEndereco = new JLabel(agendamento.getPaciente().getEndereco().getRua() + ", nº" + agendamento.getPaciente().getEndereco().getNumero());
    		fldEndereco.setHorizontalAlignment(SwingConstants.LEFT);
    		fldEndereco.setFont(new Font("SansSerif", Font.PLAIN, 16));
    		fldEndereco.setBounds(95, 60, 420, 30);
    		data.add(fldEndereco);
		}
		
		if(agendamento.getPaciente().getAlturaInicial() > 0) {
    		paciente.add(lblAlturaInicial);
    		paciente.add(fldAlturaInicial);
		}
		if(agendamento.getPaciente().getPesoInicial() > 0) {
    		paciente.add(lblPesoInicial);
    		paciente.add(fldPesoInicial);
		}
		add(scrollPanel);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(excluir);
		btnExcluir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnExcluir.setBounds(280, 430, 120, 40);
		add(btnExcluir);
		
		JButton btnIniciarConsulta = new JButton("Iniciar Consulta");
		btnIniciarConsulta.addActionListener(iniciarConsulta);
		btnIniciarConsulta.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnIniciarConsulta.setBounds(10, 430, 120, 40);
		add(btnIniciarConsulta);
	}

// Action Listeners
	private final ActionListener iniciarConsulta = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Janela janela = new Janela("Consultar Paciente");
			janela.setContent(new ConsultarPanel(index));
		}
	};

	private final ActionListener editar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Janela janela = new Janela("Editar Paciente");
			janela.setContent(new EditarAgendamentoPanel(index));
			janela.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					DefaultPanel.setPanel(new AgendamentoPanel(index));
				}
			});
		}
	};

	private final ActionListener excluir = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Excluir Este Agendamento?", "Nutri A+Saúde", JOptionPane.YES_NO_OPTION);
			if(confirmar == 0) {
				Sistema.getAgendamentos().remove(index);
				DefaultPanel.setPanel(new AgendaPanel());
			}
		}
	};
}
