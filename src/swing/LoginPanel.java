package swing;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import assets.URL;
import principal.Sistema;

public class LoginPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JLabel lblUsuario;
	private final JLabel lblSenha;
	private final JTextField fldUsuario;
	private final JTextField fldSenha;
	
	private String usuario;
	private String senha;
	
	public LoginPanel() {
		setLayout(null);
		setSize(300, 140);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEntrar.addActionListener(arg0 -> autenticar());
		btnEntrar.setFont(new Font("SanSerif", Font.BOLD, 12));
		btnEntrar.setBounds(180, 100, 100, 30);
		add(btnEntrar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Login", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(0, 5, 300, 97);
		panel.setLayout(null);
		add(panel);
		
		lblUsuario = new JLabel("Usuário:");
		lblUsuario.setBounds(20, 15, 55, 30);
		panel.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.RIGHT);
		lblUsuario.setFont(new Font("SanSerif", Font.BOLD, 12));
		
		fldUsuario = new JTextField();
		fldUsuario.setBounds(80, 15, 200, 30);
		fldUsuario.setColumns(10);
		panel.add(fldUsuario);
		
		lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(20, 55, 55, 30);
		panel.add(lblSenha);
		lblSenha.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSenha.setFont(new Font("SanSerif", Font.BOLD, 12));
		
		fldSenha = new JPasswordField();
		fldSenha.setBounds(80, 55, 200, 30);
		fldSenha.setColumns(10);
		panel.add(fldSenha);
		
		KeyListener listener = new KeyListener() {
			public void keyPressed(KeyEvent e) {
			    if (e.getKeyCode()==KeyEvent.VK_ENTER){
			    	autenticar();
			    }
			}

			@Override
			public void keyReleased(KeyEvent e) {}

			@Override
			public void keyTyped(KeyEvent e) {}
		};

		
		fldSenha.addKeyListener(listener);
		fldUsuario.addKeyListener(listener);
		btnEntrar.addKeyListener(listener);
		
		try {
			Scanner carregar = new Scanner(new File(URL.usuario));
			try {
				usuario = carregar.nextLine();
			} catch (Exception e) {	
				// Arquivo Vazio
				usuario = "";
			}
	        carregar.close();
	        
	        carregar = new Scanner(new File(URL.senha));
	        senha = carregar.nextLine();
	        carregar.close();	        
		} catch (IOException e1) {
		    usuario = JOptionPane.showInputDialog(null, "Informe Um Nome de Usuário:", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE);
		    senha = criptografar(JOptionPane.showInputDialog(null, "Informe Uma Senha:", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE));
		    
			new File(URL.diretorio).mkdirs();
	        try {
	        	FileWriter salvar = new FileWriter(URL.usuario);
				salvar.write(usuario);
				salvar.close();

	        	salvar = new FileWriter(URL.senha);
				salvar.write(senha);
				salvar.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
		}
	        
	}
	
	public static String criptografar(String s) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		Objects.requireNonNull(md).update(s.getBytes());
		
		return new BigInteger(1, md.digest()).toString(16);
	}
	
	private void autenticar() {		
		if(fldUsuario.getText().equals(usuario)) {      		  // Se o Usuário estiver Correto
			if(criptografar(fldSenha.getText()).equals(senha)) { // E a Senha Estiver Correta
				Sistema.inicio(usuario);                        // Inicia o Menu Principal do Sistema
			} else {                // Se a Senha Estiver Incorreta
				vibrar(lblSenha);  // Vibra o Label de Senha
				vibrar(fldSenha); // Vibra o Campo de Senha
			}
		} else {                  // Se o Nome de Usuário Estiver Incorreto
			vibrar(lblUsuario);  // Vibra o Label de Usuário
			vibrar(fldUsuario); // Vibra o Campo de Usuário
		}
	}
	
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
