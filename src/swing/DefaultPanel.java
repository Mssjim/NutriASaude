package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import javax.swing.*;

import assets.Cor;
import assets.URL;
import principal.Sistema;
import swing.agenda.AgendaPanel;
import swing.alimentos.AlimentosPanel;
import swing.pacientes.PacientesPanel;
import java.awt.Cursor;

public class DefaultPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private final JButton btnInicio;
	private final JButton btnAgenda;
	private final JButton btnPacientes;
	private final JButton btnAlimentos;
	private final JButton btnFinanceiro;
	
	private static JPanel panel;
	private final JPanel menu;

	public DefaultPanel() {
		setSize(800, 600);
		setLayout(null);
				
		menu = new JPanel();
		menu.setLayout(null);
		menu.setBounds(640, 0, 160, 70);
		menu.setBackground(Cor.escura);
		menu.addMouseListener(menuListener);
		
		JLabel lblUsuario = new JLabel(Sistema.getUsuario());
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setFont(new Font("SanSerif", Font.BOLD, 14));
		lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsuario.setBounds(0, 0, 160, 70);
		menu.add(lblUsuario);
		
		JButton btnAlterarSenha = new JButton("Alterar Senha");
		btnAlterarSenha.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlterarSenha.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnAlterarSenha.setBackground(Cor.escura);
		btnAlterarSenha.setForeground(Color.WHITE);
		btnAlterarSenha.setBounds(0, 70, 160, 30);
		btnAlterarSenha.addMouseListener(menuListener);
		btnAlterarSenha.addActionListener(alterarSenha);
		menu.add(btnAlterarSenha);

		JButton btnEncerrarSessao = new JButton("Encerrar Sessão");
		btnEncerrarSessao.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEncerrarSessao.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEncerrarSessao.setBackground(Cor.escura);
		btnEncerrarSessao.setForeground(Color.WHITE);
		btnEncerrarSessao.setBounds(0, 105, 160, 30);
		btnEncerrarSessao.addMouseListener(menuListener);
		btnEncerrarSessao.addActionListener(encerrarSessao);
		menu.add(btnEncerrarSessao);

		JPanel menuBar = new JPanel();
		menuBar.setBackground(Cor.principal);
		menuBar.setBounds(0, 0, 800, 70);
		menuBar.setLayout(null);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(240, 100, 540, 480);
		
		btnInicio = new JButton(new ImageIcon(getClass().getResource(URL.btnInicio)));
		btnInicio.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInicio.setBounds(20, 100, 200, 60);
		btnInicio.addActionListener(inicio);
		
		btnAgenda = new JButton(new ImageIcon(getClass().getResource(URL.btnAgenda)));
		btnAgenda.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAgenda.setBounds(20, 180, 200, 60);
		btnAgenda.addActionListener(agenda);
		
		btnPacientes = new JButton(new ImageIcon(getClass().getResource(URL.btnPacientes)));
		btnPacientes.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPacientes.setBounds(20, 260, 200, 60);
		btnPacientes.addActionListener(pacientes);
		
		btnAlimentos = new JButton(new ImageIcon(getClass().getResource(URL.btnAlimentos)));
		btnAlimentos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAlimentos.setBounds(20, 340, 200, 60);
		btnAlimentos.addActionListener(alimentos);
		
		btnFinanceiro = new JButton(new ImageIcon(getClass().getResource(URL.btnFinanceiro)));
		btnFinanceiro.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnFinanceiro.setBounds(20, 420, 200, 60);
		btnFinanceiro.setEnabled(false);
		
		JLabel imgLogo = new JLabel(new ImageIcon(getClass().getResource(URL.logo)));
		imgLogo.setBounds(20, 0, 220, 70);
		menuBar.add(imgLogo);
		
		add(menu);
		add(menuBar);
		add(panel);
		add(btnInicio);
		add(btnAgenda);
		add(btnPacientes);
		add(btnAlimentos);
		add(btnFinanceiro);
	
		InicioPanel inicioPanel = new InicioPanel();
		panel.add(inicioPanel);                     // Inicia o Menu de Inicio por Padrão
		btnInicio.setBackground(Cor.principal);
	}

// Métodos
	private void resetarBotoes() {
		// Restaura a Cor de Fundo Padrão de Todos os Botões
		btnInicio.setBackground(null);
		btnAgenda.setBackground(null);
		btnPacientes.setBackground(null);
		btnAlimentos.setBackground(null);
		btnFinanceiro.setBackground(null);
	}
	
	public static void setPanel(JPanel p) {
		panel.removeAll(); // Remove o Panel Antigo
		panel.add(p);     // Insere um Novo Panel
		panel.repaint(); // Redesenha o Panel
	}

// Action Listeners
	private final ActionListener alterarSenha = arg0 -> {
        String senhaAtual = LoginPanel.criptografar(JOptionPane.showInputDialog(null, "Informe a Senha Atual", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE));
        String senha = "";
        try {
            Scanner carregar = new Scanner(new File(URL.senha));
            senha = carregar.nextLine();
            carregar.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(senhaAtual.equals(senha)) {
            String senhaNova = LoginPanel.criptografar(JOptionPane.showInputDialog(null, "Informe uma Nova Senha", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE));

            try {
                FileWriter salvar = new FileWriter(URL.senha);
                salvar.write(senhaNova);
                salvar.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Senha Incorreta!", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE);
        }
    };
	
	private final ActionListener encerrarSessao = arg0 -> Sistema.encerrarSessao();
	
	private final ActionListener inicio = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			resetarBotoes();
			btnInicio.setBackground(Cor.principal);
			setPanel(new InicioPanel());
		}
	};
	
	private final ActionListener agenda = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			resetarBotoes();
			btnAgenda.setBackground(Cor.principal);
			setPanel(new AgendaPanel());
		}
	};
	
	private final ActionListener pacientes = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			resetarBotoes();
			btnPacientes.setBackground(Cor.principal);
			setPanel(new PacientesPanel());
		}
	};
	
	private final ActionListener alimentos = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			resetarBotoes();
			btnAlimentos.setBackground(Cor.principal);
			setPanel(new AlimentosPanel());
		}
	};
	
	private final MouseAdapter menuListener = new MouseAdapter() {
		public void mouseEntered(MouseEvent arg0) {
			menu.setSize(160, 140);
		}
		public void mouseExited(MouseEvent e) {
			menu.setSize(160, 70);
		}
	};
}
