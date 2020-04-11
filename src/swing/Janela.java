package swing;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import assets.URL;

public class Janela extends JFrame {
	private static final long serialVersionUID = 1L;
	private int largura;
	private int altura;

	public Janela(String titulo) {

		// Estilo da Janela
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("Nimbus".equals(info.getName())) {
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}
		}
		centralizar();
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource(URL.icone)).getImage());
		setTitle(titulo);
		setVisible(true);
	}

	public void setContent(JPanel panel) {
		setContentPane(panel);
		setLargura(panel.getWidth() + getInsets().left + getInsets().right);
		setAltura(panel.getHeight() + getInsets().top);
		centralizar();
	}

	private void centralizar() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((screenSize.width - getLargura()) / 2, (screenSize.height - getAltura()) / 2, getLargura(),
				getAltura());
	}

	private int getLargura() {
		return largura;
	}

	private void setLargura(int largura) {
		this.largura = largura;
	}

	private int getAltura() {
		return altura;
	}

	private void setAltura(int altura) {
		this.altura = altura;
	}
}
