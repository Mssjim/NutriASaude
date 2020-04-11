package swing;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import assets.Cor;

class ImcPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTextField fldAltura;
	private final JTextField fldPeso;
	private final JLabel fldImc;
	private final JLabel fldIMC;

	public ImcPanel() {
		setSize(200, 220);
		setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura (m):");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAltura.setBounds(10, 50, 65, 30);
		add(lblAltura);
		
		JLabel lblTitle = new JLabel("Calcular IMC");
		lblTitle.setForeground(Cor.escura);
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblTitle.setBounds(0, 10, 200, 30);
		add(lblTitle);
		
		fldAltura = new JTextField();
		fldAltura.setBounds(80, 50, 110, 30);
		add(fldAltura);
		fldAltura.setColumns(10);
		
		JLabel lblPeso = new JLabel("Peso (kg):");
		lblPeso.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPeso.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPeso.setBounds(10, 90, 65, 30);
		add(lblPeso);
		
		fldPeso = new JTextField();
		fldPeso.setColumns(10);
		fldPeso.setBounds(80, 90, 110, 30);
		add(fldPeso);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(calcular);
		btnCalcular.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCalcular.setBounds(50, 180, 100, 30);
		add(btnCalcular);
		
		JLabel lblImc = new JLabel("IMC:");
		lblImc.setHorizontalAlignment(SwingConstants.RIGHT);
		lblImc.setForeground(new Color(29, 131, 72));
		lblImc.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblImc.setBounds(10, 130, 90, 30);
		add(lblImc);
		
		fldImc = new JLabel();
		fldImc.setHorizontalAlignment(SwingConstants.LEFT);
		fldImc.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldImc.setBounds(110, 130, 80, 30);
		add(fldImc);
		
		fldIMC = new JLabel();
		fldIMC.setHorizontalAlignment(SwingConstants.CENTER);
		fldIMC.setForeground(new Color(29, 131, 72));
		fldIMC.setFont(new Font("SansSerif", Font.BOLD, 11));
		fldIMC.setBounds(10, 155, 180, 15);
		add(fldIMC);
	}
	
// Action Listeners
	private final ActionListener calcular = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			float altura = Float.parseFloat(fldAltura.getText());
			float peso = Float.parseFloat(fldPeso.getText());
			float imc = peso/(altura*altura);
			
			fldImc.setText(String.format("%.2f", imc));
			
			if(imc < 17)
				fldIMC.setText("Muito Abaixo do Peso");
			else if(imc < 18.5)
				fldIMC.setText("Abaixo do Peso");
			else if(imc < 25)
				fldIMC.setText("Peso Normal");
			else if(imc < 30)
				fldIMC.setText("Acima do Peso");
			else if(imc < 35)
				fldIMC.setText("Obesidade I");
			else if(imc < 40)
				fldIMC.setText("Obesidade II");
			else
				fldIMC.setText("Obesidade III");
		}
	};
}

