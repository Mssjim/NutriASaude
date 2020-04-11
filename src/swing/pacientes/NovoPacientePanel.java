package swing.pacientes;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.MaskFormatter;

import principal.Data;
import principal.Endereco;
import principal.Paciente;
import principal.Sistema;

public class NovoPacientePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTextField fldNome;
	private JFormattedTextField fldCpf;
	private final JTextField fldAltura;
	private final JTextField fldPeso;
	private JFormattedTextField fldDataNascimento;
	private final JTextField fldEmail;
	private JFormattedTextField fldTelefone;
	private final JTextField fldBairro;
	private final JTextField fldCidade;
	private final JTextArea fldDescricao;
	private JFormattedTextField fldCep;
	private final JTextField fldRua;
	private final JTextField fldNumero;
	private final JComboBox<String> fldGenero;

	public NovoPacientePanel() {
		setSize(540, 450);
		setLayout(null);
		
		JPanel dadosPessoais = new JPanel();
		dadosPessoais.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dadosPessoais.setBounds(0, 5, 540, 110);
		dadosPessoais.setLayout(null);
		add(dadosPessoais);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNome.setBounds(10, 20, 45, 30);
		dadosPessoais.add(lblNome);
		
		fldNome = new JTextField();
		fldNome.setBounds(60, 20, 300, 30);
		fldNome.setColumns(10);
		dadosPessoais.add(fldNome);
		
		JLabel lblGenero = new JLabel("Gênero:");
		lblGenero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGenero.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblGenero.setBounds(370, 20, 45, 30);
		dadosPessoais.add(lblGenero);
		
		fldGenero = new JComboBox<>();
		fldGenero.setModel(new DefaultComboBoxModel<>(new String[]{"", "Masculino", "Feminino"}));
		fldGenero.setBounds(420, 20, 110, 30);
		dadosPessoais.add(fldGenero);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCpf.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCpf.setBounds(10, 60, 45, 30);
		dadosPessoais.add(lblCpf);
		
		try {
			fldCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldCpf.setColumns(10);
		fldCpf.setBounds(60, 60, 100, 30);
		dadosPessoais.add(fldCpf);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAltura.setBounds(160, 60, 45, 30);
		dadosPessoais.add(lblAltura);
		
		fldAltura = new JTextField();
		fldAltura.setColumns(10);
		fldAltura.setBounds(210, 60, 50, 30);
		dadosPessoais.add(fldAltura);
		
		fldPeso = new JTextField();
		fldPeso.setColumns(10);
		fldPeso.setBounds(310, 60, 50, 30);
		dadosPessoais.add(fldPeso);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPeso.setBounds(260, 60, 45, 30);
		dadosPessoais.add(lblPeso);
		
		JLabel lblDataNascimento = new JLabel("Nasc:");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDataNascimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblDataNascimento.setBounds(370, 60, 45, 30);
		dadosPessoais.add(lblDataNascimento);
		
		try {
			fldDataNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldDataNascimento.setColumns(10);
		fldDataNascimento.setBounds(420, 60, 110, 30);
		dadosPessoais.add(fldDataNascimento);
		
		JPanel contato = new JPanel();
		contato.setLayout(null);
		contato.setBorder(new TitledBorder(null, "Contato (Opcional)", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contato.setBounds(0, 115, 540, 150);
		add(contato);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblEmail.setBounds(10, 20, 45, 30);
		contato.add(lblEmail);
		
		fldEmail = new JTextField();
		fldEmail.setColumns(10);
		fldEmail.setBounds(60, 20, 250, 30);
		contato.add(fldEmail);
		
		JLabel lblTelefone = new JLabel("Tel/Cel:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblTelefone.setBounds(320, 20, 45, 30);
		contato.add(lblTelefone);
		
		try {
			fldTelefone = new JFormattedTextField(new MaskFormatter("(##) #########"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldTelefone.setColumns(10);
		fldTelefone.setBounds(370, 20, 160, 30);
		contato.add(fldTelefone);
		
		JLabel lblRua = new JLabel("End:");
		lblRua.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRua.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblRua.setBounds(10, 60, 45, 30);
		contato.add(lblRua);
		
		fldRua = new JTextField();
		fldRua.setColumns(10);
		fldRua.setBounds(60, 60, 320, 30);
		contato.add(fldRua);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumero.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNumero.setBounds(390, 60, 55, 30);
		contato.add(lblNumero);
		
		fldNumero = new JTextField();
		fldNumero.setColumns(10);
		fldNumero.setBounds(450, 60, 80, 30);
		contato.add(fldNumero);
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBairro.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblBairro.setBounds(10, 100, 45, 30);
		contato.add(lblBairro);
		
		fldBairro = new JTextField();
		fldBairro.setColumns(10);
		fldBairro.setBounds(60, 100, 180, 30);
		contato.add(fldBairro);
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCidade.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCidade.setBounds(250, 100, 45, 30);
		contato.add(lblCidade);
		
		fldCidade = new JTextField();
		fldCidade.setColumns(10);
		fldCidade.setBounds(300, 100, 100, 30);
		contato.add(fldCidade);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCep.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCep.setBounds(400, 100, 45, 30);
		contato.add(lblCep);
		
		try {
			fldCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		fldCep.setColumns(10);
		fldCep.setBounds(450, 100, 80, 30);
		contato.add(fldCep);
		
		JPanel descricao = new JPanel();
		descricao.setLayout(null);
		descricao.setBorder(new TitledBorder(null, "Descrição", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		descricao.setBounds(0, 265, 540, 135);
		add(descricao);
		
		fldDescricao = new JTextArea();
		fldDescricao.setTabSize(4);
		fldDescricao.setColumns(10);
		fldDescricao.setBounds(0, 0, 520, 100);
		
		JScrollPane scrollPanel = new JScrollPane(fldDescricao);
		scrollPanel.setBounds(10, 20, 520, 100);
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
	}
	
// Action Listeners
	private final ActionListener ok = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			boolean erro = false; // Caso Algum dado esteja Incompleto ou incorreto
			
			Data dataNascimento = new Data();
			Endereco endereco;

			if(fldDataNascimento.isEditValid()) {
    			try {
    				int dia = Integer.parseInt(fldDataNascimento.getText(0, 2));
    				int mes = Integer.parseInt(fldDataNascimento.getText(3, 2));
    				int ano = Integer.parseInt(fldDataNascimento.getText(6, 4));
    				dataNascimento = new Data(dia, mes, ano);
    			} catch (BadLocationException e) {
    				e.printStackTrace();
    			}
			} else {
				erro = true;
				vibrar(fldDataNascimento);
			}
			
			String bairro = fldBairro.getText();
			String cidade = fldCidade.getText();
			String rua = fldRua.getText();
			String cep = fldCep.getText();
			int numero;
			if(fldNumero.getText().length() > 0) {
				numero = Integer.parseInt(fldNumero.getText());
			} else {
				numero = -1; // Define Número como '-1' (Sem Valor Definido)
			}
			endereco = new Endereco(bairro, cep, cidade, rua, numero);
			
			if(!fldCpf.isEditValid()) {
        		erro = true;
        		vibrar(fldCpf);
			} else if(Sistema.getPacientes() != null) {
	        	for(int i = 0; i < Sistema.getPacientes().size(); i++) {
        			if(fldCpf.getText().equals(Sistema.getPacientes().get(i).getCpf())) {
        				erro = true;
        				JOptionPane.showMessageDialog(null,  "Paciente já Cadastrado!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
        				break;
        			}
	    		}
			}
			
			if(fldDescricao.getText().length() == 0) {
        		erro = true;
        		vibrar(fldDescricao);
			}
			
			if(fldNome.getText().length() == 0) {
        		erro = true;
        		vibrar(fldNome);
			}
			
			if(fldTelefone.getText().length() == 0) {
        		erro = true;
        		vibrar(fldTelefone);
			}
			
			if(fldGenero.getSelectedIndex() == 0) {
        		erro = true;
        		vibrar(fldGenero);
			}
			
			if(fldAltura.getText().length() == 0) {
        		erro = true;
        		vibrar(fldAltura);
			} else if(Float.parseFloat(fldAltura.getText().replace(',', '.')) > 5){
				erro = true;
				JOptionPane.showMessageDialog(null, "Informe a Altura em Metros!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(fldPeso.getText().length() == 0) {
        		erro = true;
        		vibrar(fldPeso);
			} else if(Float.parseFloat(fldPeso.getText().replace(',', '.')) > 1000){
				erro = true;
				JOptionPane.showMessageDialog(null, "Informe o Peso em Quilos!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
			}
			
			if(!erro) {
				String cpf = fldCpf.getText();
				String descricao = fldDescricao.getText();
				String email = fldEmail.getText();
    			String nome = fldNome.getText();
    			String telefone = fldTelefone.getText();
    			int genero = fldGenero.getSelectedIndex();
				float altura = Float.parseFloat(fldAltura.getText().replace(',', '.'));
				float peso = Float.parseFloat(fldPeso.getText().replace(',', '.'));
				
				Sistema.getPacientes().add(new Paciente(dataNascimento, endereco, cpf, descricao, email, nome, telefone, altura, peso, genero));
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
