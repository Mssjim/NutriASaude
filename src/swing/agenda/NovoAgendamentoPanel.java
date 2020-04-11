package swing.agenda;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

import assets.URL;
import principal.Agendamento;
import principal.Data;
import principal.Paciente;
import principal.Sistema;
import swing.Janela;
import swing.pacientes.NovoPacientePanel;

public class NovoAgendamentoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JLabel fldNome;
	private final JLabel fldImc;
	private final JLabel fldAltura;
	private final JLabel fldPeso;
	private final JLabel fldDataNascimento;
	private final JTextArea fldDescricao;
	private final JLabel fldGenero;
	private JFormattedTextField fldCpf;
	private JFormattedTextField fldData;
	private JFormattedTextField fldHorario;
	private final JLabel imgAgenda;
	
	private Paciente paciente;

	public NovoAgendamentoPanel() {
		setSize(540, 450);
		setLayout(null);
		
		JPanel paciente = new JPanel();
		paciente.setBorder(new TitledBorder(null, "Paciente", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		paciente.setBounds(0, 75, 540, 140);
		paciente.setLayout(null);
		add(paciente);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNome.setBounds(10, 50, 45, 30);
		paciente.add(lblNome);
		
		fldNome = new JLabel();
		fldNome.setBounds(60, 50, 300, 30);
		paciente.add(fldNome);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblGenero.setBounds(370, 50, 45, 30);
		paciente.add(lblGenero);
		
		fldGenero = new JLabel();
		fldGenero.setBounds(420, 50, 110, 30);
		paciente.add(fldGenero);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImc.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblImc.setBounds(10, 90, 45, 30);
		paciente.add(lblImc);
		
		fldImc = new JLabel();
		fldImc.setBounds(60, 90, 100, 30);
		paciente.add(fldImc);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAltura.setBounds(160, 90, 45, 30);
		paciente.add(lblAltura);
		
		fldAltura = new JLabel();
		fldAltura.setBounds(210, 90, 50, 30);
		paciente.add(fldAltura);
		
		fldPeso = new JLabel();
		fldPeso.setBounds(310, 90, 50, 30);
		paciente.add(fldPeso);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPeso.setBounds(260, 90, 45, 30);
		paciente.add(lblPeso);
		
		JLabel lblDataNascimento = new JLabel("Nasc:");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDataNascimento.setBounds(370, 90, 45, 30);
		paciente.add(lblDataNascimento);
		
		fldDataNascimento = new JLabel();
		fldDataNascimento.setBounds(420, 90, 110, 30);
		paciente.add(fldDataNascimento);
		
		JButton btnNovoPaciente = new JButton("Novo Paciente");
		btnNovoPaciente.addActionListener(novoPaciente);
		btnNovoPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoPaciente.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNovoPaciente.setBounds(390, 20, 120, 30);
		paciente.add(btnNovoPaciente);
		
		try {
			fldCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldCpf.setColumns(10);
		fldCpf.setBounds(60, 20, 100, 30);
		paciente.add(fldCpf);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCpf.setBounds(10, 20, 45, 30);
		paciente.add(lblCpf);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.addActionListener(pesquisar);
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnPesquisar.setBounds(170, 20, 120, 30);
		paciente.add(btnPesquisar);
		
		JPanel descricao = new JPanel();
		descricao.setLayout(null);
		descricao.setBorder(new TitledBorder(null, "Descrição", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		descricao.setBounds(0, 215, 540, 185);
		add(descricao);
		
		fldDescricao = new JTextArea();
		fldDescricao.setTabSize(4);
		fldDescricao.setColumns(10);
		fldDescricao.setBounds(0, 0, 520, 100);
		
		JScrollPane scrollPanel = new JScrollPane(fldDescricao);
		scrollPanel.setBounds(10, 20, 520, 150);
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
		
		JPanel data = new JPanel();
		data.setLayout(null);
		data.setBorder(new TitledBorder(null, "Data / Horário", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		data.setBounds(0, 5, 540, 70);
		add(data);
		
		try {
			fldData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldData.setColumns(10);
		fldData.setBounds(60, 20, 100, 30);
		data.add(fldData);
		
		JLabel lblData = new JLabel("Data:");
		lblData.setHorizontalAlignment(SwingConstants.RIGHT);
		lblData.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblData.setBounds(10, 20, 45, 30);
		data.add(lblData);
		
		JLabel lblHorario = new JLabel("Horário:");
		lblHorario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHorario.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblHorario.setBounds(170, 20, 45, 30);
		data.add(lblHorario);
		
		try {
			fldHorario = new JFormattedTextField(new MaskFormatter("##:##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldHorario.setColumns(10);
		fldHorario.setBounds(220, 20, 50, 30);
		data.add(fldHorario);
		
		JButton btnVerificarAgenda = new JButton("Verificar Agenda");
		btnVerificarAgenda.addActionListener(verificarAgenda);
		btnVerificarAgenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnVerificarAgenda.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnVerificarAgenda.setBounds(280, 20, 140, 30);
		data.add(btnVerificarAgenda);
		
		imgAgenda = new JLabel();
		imgAgenda.setBounds(430, 20, 30, 30);
		data.add(imgAgenda);
	}
	
// Action Listeners
	private final ActionListener verificarAgenda = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			int dia = 0, mes = 0, ano = 0, hora = 0, minutos = 0;
			if(fldData.isEditValid()) {
    			try {
    				dia = Integer.parseInt(fldData.getText(0, 2));
    				mes = Integer.parseInt(fldData.getText(3, 2));
    				ano = Integer.parseInt(fldData.getText(6, 4));
    			} catch (BadLocationException e) {
    				e.printStackTrace();
    			}
			} else {
				vibrar(fldData);
			}
			if(fldHorario.isEditValid()) {
				try {
					hora = Integer.parseInt(fldHorario.getText(0, 2));
    				minutos = Integer.parseInt(fldHorario.getText(3, 2));
    			} catch (BadLocationException e) {
    				e.printStackTrace();
    			}
			} else {
				vibrar(fldHorario);
			}
			
			Data data = new Data(dia, mes, ano, hora, minutos);
			
			if(Sistema.getAgendamentos() != null) {
				for(int i = 0; i < Sistema.getAgendamentos().size(); i++) {
    				if(Data.comparar(data, Sistema.getAgendamentos().get(i).getData())) {
    					imgAgenda.setIcon(new ImageIcon(getClass().getResource(URL.cancel)));
    					break;
    				} else if(i == Sistema.getAgendamentos().size() - 1) {
    					imgAgenda.setIcon(new ImageIcon(getClass().getResource(URL.ok)));
    				}
    			}
			}
		}
	};
	
	private final ActionListener novoPaciente = arg0 -> {
		Janela janela = new Janela("Cadastrar Paciente");
		janela.setContent(new NovoPacientePanel());
	};
	
	private final ActionListener pesquisar = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {			
			if(fldCpf.isEditValid()) {
    			String cpf = fldCpf.getText();

    			if(Sistema.getPacientes() != null) {
    				for(int i = 0; i < Sistema.getPacientes().size(); i++) {
        				if(cpf.equals(Sistema.getPacientes().get(i).getCpf())) {
        					paciente = Sistema.getPacientes().get(i);
        					// Exibe Dados do Paciente
        					fldNome.setText(paciente.getNome());
        					if(paciente.getGenero() == 1) {
        						fldGenero.setText("Masculino");
        					} else {
        						fldGenero.setText("Feminino");
        					}
        					fldImc.setText(String.format("%.2f", paciente.calcularIMC()));
        					fldAltura.setText(String.format("%.2f", paciente.getAltura()) + "m");
        					fldPeso.setText(String.format("%.2f", paciente.getPeso()) + "kg");
        					fldDataNascimento.setText(String.format("%02d", paciente.getDataNascimento().getDia()) + "/" + String.format("%02d", paciente.getDataNascimento().getMes()) + "/" + paciente.getDataNascimento().getAno());
        					break;
        				} else if(i == Sistema.getPacientes().size() - 1) {
        					JOptionPane.showMessageDialog(null, "Paciente Não Encontrado!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
        				}
	    			}
    			}
			} else {
				JOptionPane.showMessageDialog(null, "Informe um CPF Valido!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	};
	
	private final ActionListener ok = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			boolean erro = false; // Caso Algum Campo Esteja Incompleto ou Incorreto
			
			int dia = 0, mes = 0, ano = 0, hora = 0, minutos = 0;
			if(fldData.isEditValid()) {
    			try {
    				dia = Integer.parseInt(fldData.getText(0, 2));
    				mes = Integer.parseInt(fldData.getText(3, 2));
    				ano = Integer.parseInt(fldData.getText(6, 4));
    			} catch (BadLocationException e) {
    				e.printStackTrace();
    			}
			} else {
				vibrar(fldData);
				erro = true;
			}
			if(fldHorario.isEditValid()) {
				try {
					hora = Integer.parseInt(fldHorario.getText(0, 2));
    				minutos = Integer.parseInt(fldHorario.getText(3, 2));
    			} catch (BadLocationException e) {
    				e.printStackTrace();
    			}
			} else {
				vibrar(fldHorario);
				erro = true;
			}
			
			Data data = new Data(dia, mes, ano, hora, minutos);
			
			if(paciente == null) {
				erro = true;
				JOptionPane.showMessageDialog(null, "Nenhum Paciente Informado!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(fldDescricao.getText().length() == 0) {
        		erro = true;
        		vibrar(fldDescricao);
			}
			
			if(!erro) {
				Sistema.getAgendamentos().add(new Agendamento(data, paciente, fldDescricao.getText()));
				((JFrame) getRootPane().getParent()).dispose(); // Fecha a Janela de Cadastro
			}
		}
	};
	
	private final ActionListener cancelar = arg0 -> {
		((JFrame) getRootPane().getParent()).dispose(); // Fecha a Janela de Cadastro
	};
	
	private void vibrar(JComponent j) {
		Thread thread = new Thread(() -> {
			try {
				Point p = j.getLocation();
				j.setLocation(p.x + 5, p.y);
				Thread.sleep(20);
				j.setLocation(p.x - 5, p.y);
				Thread.sleep(20);
				j.setLocation(p.x + 5, p.y);
				Thread.sleep(20);
				j.setLocation(p.x - 5, p.y);
				Thread.sleep(20);
				j.setLocation(p.x, p.y);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		thread.start();
	}
}
