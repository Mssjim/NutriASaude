package swing.agenda;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import principal.Agendamento;
import principal.Data;
import principal.Paciente;
import principal.Sistema;
import swing.DefaultPanel;
import swing.InicioPanel;

class ConsultarPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTextArea fldDescricao;
	private final JTextField fldNovaAltura;
	private final JTextField fldNovoPeso;
	
	private final int index;
	private final Paciente p1;

	public ConsultarPanel(int index) {
		setSize(540, 450);
		setLayout(null);
		this.index = index;
		
		Agendamento agendamento = Sistema.getAgendamentos().get(index);
		p1 = agendamento.getPaciente();
		
		JPanel paciente = new JPanel();
		paciente.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paciente.setBounds(0, 0, 540, 100);
		paciente.setLayout(null);
		add(paciente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNome.setBounds(10, 20, 45, 30);
		paciente.add(lblNome);

		JLabel fldNome = new JLabel(p1.getNome());
		fldNome.setBounds(60, 20, 300, 30);
		paciente.add(fldNome);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblGenero.setBounds(370, 20, 45, 30);
		paciente.add(lblGenero);

		JLabel fldGenero = new JLabel();
		fldGenero.setBounds(420, 20, 110, 30);
		if(p1.getGenero() == 1) {
			fldGenero.setText("Masculino");
		} else
			fldGenero.setText("Feminino");
		paciente.add(fldGenero);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImc.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblImc.setBounds(10, 50, 45, 30);
		paciente.add(lblImc);

		JLabel fldImc = new JLabel(p1.calcularIMC() + "");
		fldImc.setBounds(60, 50, 100, 30);
		paciente.add(fldImc);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAltura.setBounds(160, 50, 45, 30);
		paciente.add(lblAltura);

		JLabel fldAltura = new JLabel(p1.getAltura() + "");
		fldAltura.setBounds(210, 50, 50, 30);
		paciente.add(fldAltura);

		JLabel fldPeso = new JLabel(p1.getPeso() + "");
		fldPeso.setBounds(310, 50, 50, 30);
		paciente.add(fldPeso);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPeso.setBounds(260, 50, 45, 30);
		paciente.add(lblPeso);
		
		JLabel lblDataNascimento = new JLabel("Nasc:");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDataNascimento.setBounds(370, 50, 45, 30);
		paciente.add(lblDataNascimento);

		JLabel fldDataNascimento = new JLabel(String.format("%02d", p1.getDataNascimento().getDia()) + "/" + String.format("%02d", p1.getDataNascimento().getMes()) + "/" + p1.getDataNascimento().getAno());
		fldDataNascimento.setBounds(420, 50, 110, 30);
		paciente.add(fldDataNascimento);
		
		JPanel descricao = new JPanel();
		descricao.setLayout(null);
		descricao.setBorder(new TitledBorder(null, "Descrição", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		descricao.setBounds(0, 170, 540, 230);
		add(descricao);
		
		fldDescricao = new JTextArea();
		fldDescricao.setTabSize(4);
		fldDescricao.setColumns(10);
		fldDescricao.setBounds(0, 0, 520, 100);
		
		JScrollPane scrollPanel = new JScrollPane(fldDescricao);
		scrollPanel.setBounds(10, 20, 520, 195);
		descricao.add(scrollPanel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnOk.setBounds(450, 410, 80, 30);
		btnOk.addActionListener(ok);
		add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setBounds(360, 410, 80, 30);
		btnCancelar.addActionListener(cancelar);
		add(btnCancelar);
		
		JPanel dados = new JPanel();
		dados.setLayout(null);
		dados.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dados.setBounds(0, 100, 540, 70);
		add(dados);
		
		JLabel lblNovaAltura = new JLabel("Nova Altura (m):");
		lblNovaAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovaAltura.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNovaAltura.setBounds(85, 20, 95, 30);
		dados.add(lblNovaAltura);
		
		JLabel lblNovoPeso = new JLabel("Novo Peso (kg):");
		lblNovoPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNovoPeso.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNovoPeso.setBounds(245, 20, 95, 30);
		dados.add(lblNovoPeso);
		
		fldNovaAltura = new JTextField();
		fldNovaAltura.setBounds(185, 20, 50, 30);
		dados.add(fldNovaAltura);
		fldNovaAltura.setColumns(10);
		
		fldNovoPeso = new JTextField();
		fldNovoPeso.setColumns(10);
		fldNovoPeso.setBounds(345, 20, 50, 30);
		dados.add(fldNovoPeso);
	}
	
// Action Listeners	
	private final ActionListener ok = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(fldDescricao.getText().length() != 0) {
				p1.setDescricao(p1.getDescricao().concat(new Data().exibir() + " - " + fldDescricao.getText() + "\n\n"));
			}

			try {
				float altura = Float.parseFloat(fldNovaAltura.getText());
				if(p1.getAlturaInicial() == 0) {
					p1.setAlturaInicial(p1.getAltura());
				}
				p1.setAltura(altura);
			} catch (Exception e) {/* Campo Altura Vazio */}

			try {
				float peso = Float.parseFloat(fldNovoPeso.getText());
				if(p1.getPesoInicial() == 0) {
					p1.setPesoInicial(p1.getPeso());
				}
				p1.setPeso(peso);
			} catch (Exception e) {/* Campo Peso Vazio */}
			
			Sistema.getAgendamentos().remove(index);
			((JFrame) getRootPane().getParent()).dispose(); // Fecha a Janela de Consulta
			DefaultPanel.setPanel(new InicioPanel()); 	   // Retorna ao Menu Inicial
		}
	};
	
	private final ActionListener cancelar = arg0 -> {
        ((JFrame) getRootPane().getParent()).dispose(); // Fecha a Janela de Consulta
    };
}
