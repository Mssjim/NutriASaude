package swing.pacientes;

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
import javax.swing.JToggleButton;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import assets.Cor;
import principal.Paciente;
import principal.Sistema;
import swing.DefaultPanel;
import swing.Janela;

class PacientePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final int index;
	private boolean inativo;

    private final JToggleButton btnInativar;
	
	public PacientePanel(int index, boolean inativo) {
		this.index = index;
        Paciente paciente;
        if(inativo)
			paciente = Sistema.getInativos().get(index);
		else
			paciente = Sistema.getPacientes().get(index);
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
		
		btnInativar = new JToggleButton("Inativar");
		btnInativar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInativar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnInativar.setBounds(280, 430, 120, 40);
		btnInativar.addActionListener(inativar);
		if(inativo)
			btnInativar.setSelected(true);
		add(btnInativar);
		
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(10, 10, 520, 400);	
		scrollPanel.setViewportView(panel);
		
		JPanel dadosPessoais = new JPanel();
		dadosPessoais.setBorder(new TitledBorder(null, "Dados Pessoais", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dadosPessoais.setBounds(0, 0, 515, 160);
		panel.add(dadosPessoais);
		dadosPessoais.setLayout(null);
		
		JLabel fldGenero = new JLabel();
		fldGenero.setBounds(470, 5, 40, 40);
		fldGenero.setFont(new Font("SansSerif", Font.BOLD, 30));
		fldGenero.setHorizontalAlignment(SwingConstants.CENTER);
		if(paciente.getGenero() == 1) {
			fldGenero.setText("♂");
			fldGenero.setForeground(Cor.masculino);
		} else {
			fldGenero.setText("♀");
			fldGenero.setForeground(Cor.feminino);
		}
		dadosPessoais.add(fldGenero);
		
		JLabel lblNome = new JLabel(paciente.getNome());
		lblNome.setBounds(0, 0, 515, 60);
		dadosPessoais.add(lblNome);
		lblNome.setForeground(Cor.principal);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 28));
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblIdade = new JLabel("Idade:");
		lblIdade.setBounds(10, 70, 80, 30);
		dadosPessoais.add(lblIdade);
		lblIdade.setForeground(Cor.principal);
		lblIdade.setHorizontalAlignment(SwingConstants.RIGHT);
		lblIdade.setFont(new Font("SansSerif", Font.BOLD, 16));
		
		JLabel fldIdade = new JLabel(paciente.calcularIdade() + " Anos");
		fldIdade.setBounds(95, 70, 80, 30);
		dadosPessoais.add(fldIdade);
		fldIdade.setHorizontalAlignment(SwingConstants.LEFT);
		fldIdade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setForeground(new Color(29, 131, 72));
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblAltura.setBounds(180, 70, 80, 30);
		dadosPessoais.add(lblAltura);
		
		JLabel fldAltura = new JLabel(paciente.getAltura() + "m");
		fldAltura.setHorizontalAlignment(SwingConstants.LEFT);
		fldAltura.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldAltura.setBounds(265, 70, 80, 30);
		dadosPessoais.add(fldAltura);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setForeground(new Color(29, 131, 72));
		lblPeso.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblPeso.setBounds(350, 70, 80, 30);
		dadosPessoais.add(lblPeso);
		
		JLabel fldPeso = new JLabel(paciente.getPeso() + "kg");
		fldPeso.setHorizontalAlignment(SwingConstants.LEFT);
		fldPeso.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldPeso.setBounds(435, 70, 80, 30);
		dadosPessoais.add(fldPeso);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImc.setForeground(new Color(29, 131, 72));
		lblImc.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblImc.setBounds(10, 110, 80, 30);
		dadosPessoais.add(lblImc);
		
		JLabel fldImc = new JLabel(String.format("%.2f", paciente.calcularIMC()));
		fldImc.setHorizontalAlignment(SwingConstants.LEFT);
		fldImc.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldImc.setBounds(95, 110, 80, 30);
		dadosPessoais.add(fldImc);
		
		JLabel lblAlturaInicial = new JLabel("Inicial:");
		lblAlturaInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAlturaInicial.setForeground(new Color(29, 131, 72));
		lblAlturaInicial.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblAlturaInicial.setBounds(180, 95, 80, 15);
		
		JLabel fldAlturaInicial = new JLabel(paciente.getAlturaInicial() + "m");
		fldAlturaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		fldAlturaInicial.setFont(new Font("SansSerif", Font.PLAIN, 11));
		fldAlturaInicial.setBounds(265, 95, 80, 15);
		
		JLabel lblPesoInicial = new JLabel("Inicial:");
		lblPesoInicial.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoInicial.setForeground(new Color(29, 131, 72));
		lblPesoInicial.setFont(new Font("SansSerif", Font.BOLD, 11));
		lblPesoInicial.setBounds(350, 95, 80, 15);
		
		JLabel fldPesoInicial = new JLabel(paciente.getPesoInicial() + "kg");
		fldPesoInicial.setHorizontalAlignment(SwingConstants.LEFT);
		fldPesoInicial.setFont(new Font("SansSerif", Font.PLAIN, 11));
		fldPesoInicial.setBounds(435, 95, 80, 15);
		
		JLabel fldIMC = new JLabel();
		fldIMC.setHorizontalAlignment(SwingConstants.CENTER);
		fldIMC.setForeground(new Color(29, 131, 72));
		fldIMC.setFont(new Font("SansSerif", Font.BOLD, 11));
		fldIMC.setBounds(10, 135, 165, 15);
		
		// Avalia Situação
		if(paciente.calcularIMC() < 17)
			fldIMC.setText("Muito Abaixo do Peso");
		else if(paciente.calcularIMC() < 18.5)
			fldIMC.setText("Abaixo do Peso");
		else if(paciente.calcularIMC() < 25)
			fldIMC.setText("Peso Normal");
		else if(paciente.calcularIMC() < 30)
			fldIMC.setText("Acima do Peso");
		else if(paciente.calcularIMC() < 35)
			fldIMC.setText("Obesidade I");
		else if(paciente.calcularIMC() < 40)
			fldIMC.setText("Obesidade II");
		else
			fldIMC.setText("Obesidade III");
		
		dadosPessoais.add(fldIMC);
		
		JLabel lblMeta = new JLabel("Meta:");
		lblMeta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMeta.setForeground(new Color(29, 131, 72));
		lblMeta.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblMeta.setBounds(180, 110, 80, 30);
		dadosPessoais.add(lblMeta);
		
		float meta = 22 * (paciente.getAltura()* paciente.getAltura());
		
		JLabel fldMeta = new JLabel(String.format("%.2f", meta) + "kg");
		fldMeta.setHorizontalAlignment(SwingConstants.LEFT);
		fldMeta.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldMeta.setBounds(265, 110, 80, 30);
		dadosPessoais.add(fldMeta);
		
		JLabel fldMETA = new JLabel();
		fldMETA.setHorizontalAlignment(SwingConstants.CENTER);
		fldMETA.setForeground(new Color(29, 131, 72));
		fldMETA.setFont(new Font("SansSerif", Font.BOLD, 11));
		fldMETA.setBounds(180, 135, 165, 15);
		if(meta - paciente.getPeso() == 0) {
			fldMETA.setText("Peso Ideal");
		} else if(meta - paciente.getPeso() < 0) {
			fldMETA.setText("Perda de " + String.format("%.2f", (paciente.getPeso() - meta)) + "kg");
		} else {
			fldMETA.setText("Ganho de " + String.format("%.2f", (meta - paciente.getPeso())) + "kg");
		}
		dadosPessoais.add(fldMETA);
		
		JLabel fldCpf = new JLabel(paciente.getCpf());
		fldCpf.setHorizontalAlignment(SwingConstants.CENTER);
		fldCpf.setForeground(new Color(29, 131, 72));
		fldCpf.setFont(new Font("SansSerif", Font.BOLD, 14));
		fldCpf.setBounds(0, 45, 515, 20);
		dadosPessoais.add(fldCpf);
		
		JPanel contato = new JPanel();
		contato.setLayout(null);
		contato.setBorder(new TitledBorder(null, "Contato", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contato.setBounds(0, 160, 515, 135);
		panel.add(contato);
		
		JLabel lblEmail = new JLabel("E-Mail:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setForeground(new Color(29, 131, 72));
		lblEmail.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblEmail.setBounds(10, 20, 80, 30);
		contato.add(lblEmail);
		
		JLabel fldEmail = new JLabel(paciente.getEmail());
		fldEmail.setHorizontalAlignment(SwingConstants.LEFT);
		fldEmail.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldEmail.setBounds(95, 20, 200, 30);
		contato.add(fldEmail);
		
		JLabel lblTelefone = new JLabel("Tel/Cel:");
		lblTelefone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTelefone.setForeground(new Color(29, 131, 72));
		lblTelefone.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblTelefone.setBounds(300, 20, 80, 30);
		contato.add(lblTelefone);
		
    	JLabel fldTelefone = new JLabel(paciente.getTelefone());
    	fldTelefone.setHorizontalAlignment(SwingConstants.LEFT);
    	fldTelefone.setFont(new Font("SansSerif", Font.PLAIN, 16));
    	fldTelefone.setBounds(385, 20, 130, 30);
    	contato.add(fldTelefone);
		
		JLabel lblEndereco = new JLabel("Endereço:");
		lblEndereco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEndereco.setForeground(new Color(29, 131, 72));
		lblEndereco.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblEndereco.setBounds(10, 60, 80, 30);
		contato.add(lblEndereco);
		
		JPanel descricao = new JPanel();
		descricao.setLayout(null);
		descricao.setBorder(new TitledBorder(null, "Descrição", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		descricao.setBounds(0, 295, 515, 100);
		panel.add(descricao);
		
		JTextArea fldDescricao = new JTextArea(paciente.getDescricao());
		fldDescricao.setEditable(false);
		fldDescricao.setBounds(0, 0, 495, 70);
		fldDescricao.setBackground(new Color(0, 0, 0, 0));
		
		JScrollPane scrollDescricao = new JScrollPane(fldDescricao);
		scrollDescricao.setBounds(10, 20, 495, 70);
		descricao.add(scrollDescricao);
		
		if(paciente.getEndereco().getNumero() != -1) {
    		JLabel fldEndereco = new JLabel(paciente.getEndereco().getRua() + ", nº" + paciente.getEndereco().getNumero());
    		fldEndereco.setHorizontalAlignment(SwingConstants.LEFT);
    		fldEndereco.setFont(new Font("SansSerif", Font.PLAIN, 16));
    		fldEndereco.setBounds(95, 60, 420, 30);
    		contato.add(fldEndereco);
		}
		
		
		JLabel fldBairro = new JLabel(paciente.getEndereco().getBairro());
		fldBairro.setHorizontalAlignment(SwingConstants.LEFT);
		fldBairro.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldBairro.setBounds(10, 90, 250, 30);
		contato.add(fldBairro);
    		
		
		JLabel fldCidade = new JLabel(paciente.getEndereco().getCidade());
		fldCidade.setHorizontalAlignment(SwingConstants.LEFT);
		fldCidade.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldCidade.setBounds(260, 90, 125, 30);
		contato.add(fldCidade);
    		
		JLabel fldCep = new JLabel(paciente.getEndereco().getCep());
		fldCep.setHorizontalAlignment(SwingConstants.LEFT);
		fldCep.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldCep.setBounds(385, 90, 130, 30);
		contato.add(fldCep);
		
		if(paciente.getAlturaInicial() > 0) {
    		dadosPessoais.add(lblAlturaInicial);
    		dadosPessoais.add(fldAlturaInicial);
		}
		if(paciente.getPesoInicial() > 0) {
    		dadosPessoais.add(lblPesoInicial);
    		dadosPessoais.add(fldPesoInicial);
		}
		add(scrollPanel);
	}
	
// Action Listeners
	private final ActionListener editar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(btnInativar.isSelected()) {
				JOptionPane.showMessageDialog(null, "Paciente Inativo!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
			} else {
    			Janela janela = new Janela("Editar Paciente");
    			janela.setContent(new EditarPacientePanel(index));
    			janela.addWindowListener(new WindowAdapter() {
    				@Override
    				public void windowClosed(WindowEvent e) {					
    					DefaultPanel.setPanel(new PacientePanel(index, inativo));
    				}
    			});
			}
		}
	};
	private final ActionListener inativar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(btnInativar.isSelected()) {
    			Sistema.getInativos().add(Sistema.getPacientes().get(index));
    			Sistema.getPacientes().remove(index);
			} else {
				Sistema.getPacientes().add(Sistema.getInativos().get(index));
				Sistema.getInativos().remove(index);
			}
		}
	};
}
