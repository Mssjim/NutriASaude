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

class PesoIdealPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTextField fldAltura;
	private final JTextField fldPeso;
	private final JLabel fldPesoIdeal;
	private final JLabel fldPESOIDEAL;

	public PesoIdealPanel() {
		setSize(200, 220);
		setLayout(null);
		
		JLabel lblAltura = new JLabel("Altura (m):");
		lblAltura.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAltura.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblAltura.setBounds(10, 50, 65, 30);
		add(lblAltura);
		
		JLabel lblTitle = new JLabel("Calcular Peso Ideal");
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
		
		JLabel lblPesoIdeal = new JLabel("Peso Ideal:");
		lblPesoIdeal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPesoIdeal.setForeground(new Color(29, 131, 72));
		lblPesoIdeal.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblPesoIdeal.setBounds(10, 130, 90, 30);
		add(lblPesoIdeal);
		
		fldPesoIdeal = new JLabel();
		fldPesoIdeal.setHorizontalAlignment(SwingConstants.LEFT);
		fldPesoIdeal.setFont(new Font("SansSerif", Font.PLAIN, 16));
		fldPesoIdeal.setBounds(110, 130, 80, 30);
		add(fldPesoIdeal);
		
		fldPESOIDEAL = new JLabel();
		fldPESOIDEAL.setHorizontalAlignment(SwingConstants.CENTER);
		fldPESOIDEAL.setForeground(new Color(29, 131, 72));
		fldPESOIDEAL.setFont(new Font("SansSerif", Font.BOLD, 11));
		fldPESOIDEAL.setBounds(10, 155, 180, 15);
		add(fldPESOIDEAL);
	}
	
// Action Listeners
	private final ActionListener calcular = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			float altura = Float.parseFloat(fldAltura.getText());
			float peso = Float.parseFloat(fldPeso.getText());
			float pesoIdeal = 22 * (altura*altura);
			
			fldPesoIdeal.setText(String.format("%.2f", pesoIdeal) + "kg");
			
			if(pesoIdeal - peso == 0) {
				fldPESOIDEAL.setText("Peso Ideal");
			} else if(pesoIdeal - peso < 0) {
				fldPESOIDEAL.setText("Perda de " + String.format("%.2f", (peso - pesoIdeal)) + "kg");
			} else {
				fldPESOIDEAL.setText("Ganho de " + String.format("%.2f", (pesoIdeal - peso)) + "kg");
			}
		}
	};
}

