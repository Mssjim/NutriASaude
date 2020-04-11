package swing.alimentos;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;

import principal.Alimento;
import principal.Sistema;

class EditarAlimentoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTextField fldNome;
	private final JTextField fldPorcao;
	private final JTextField fldCalorias;
	private final JTextField fldCarboidratos;
	private final JTextField fldSodio;
	private final JTextField fldGorduras;
	private final JTextField fldProteinas;
	
	private final int index;

	public EditarAlimentoPanel(int index) {
		setSize(540, 240);
		setLayout(null);
		
		this.index = index;
		Alimento alimento = Sistema.getAlimentos().get(index);
		
		JButton btnOk = new JButton("OK");
		btnOk.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnOk.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnOk.setBounds(450, 200, 80, 30);
		btnOk.addActionListener(ok);
		add(btnOk);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCancelar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnCancelar.setBounds(360, 200, 80, 30);
		btnCancelar.addActionListener(cancelar);
		add(btnCancelar);
		
		JPanel dados;
		dados = new JPanel();
		dados.setLayout(null);
		dados.setBorder(new TitledBorder(null, "Alimento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		dados.setBounds(0, 0, 540, 70);
		add(dados);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNome.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblNome.setBounds(10, 20, 45, 30);
		dados.add(lblNome);
		
		fldNome = new JTextField(alimento.getNome());
		fldNome.setColumns(10);
		fldNome.setBounds(60, 20, 260, 30);
		dados.add(fldNome);
		
		JLabel lblPorcao = new JLabel("Porção:");
		lblPorcao.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPorcao.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblPorcao.setBounds(330, 20, 45, 30);
		dados.add(lblPorcao);
		
		fldPorcao = new JTextField(alimento.getPorcao() + "");
		fldPorcao.setColumns(10);
		fldPorcao.setBounds(380, 20, 65, 30);
		dados.add(fldPorcao);
		
		JLabel lblGramas = new JLabel("g (Gramas)");
		lblGramas.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblGramas.setBounds(450, 20, 70, 30);
		dados.add(lblGramas);
		
		JPanel informacao = new JPanel();
		informacao.setBounds(0, 70, 540, 120);
		add(informacao);
		informacao.setBorder(new TitledBorder(null, "Informação Nutricional", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		informacao.setLayout(null);
		
		JLabel lblCalorias = new JLabel("Calorias (Kcal):");
		lblCalorias.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCalorias.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCalorias.setBounds(10, 20, 95, 30);
		informacao.add(lblCalorias);
		
		fldCalorias = new JTextField(alimento.getCalorias() + "");
		fldCalorias.setColumns(10);
		fldCalorias.setBounds(110, 20, 70, 30);
		informacao.add(fldCalorias);
		
		JLabel lblCarboidratos = new JLabel("Carboidratos (g):");
		lblCarboidratos.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCarboidratos.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblCarboidratos.setBounds(190, 20, 95, 30);
		informacao.add(lblCarboidratos);
		
		fldCarboidratos = new JTextField(alimento.getCarboidratos() + "");
		fldCarboidratos.setColumns(10);
		fldCarboidratos.setBounds(290, 20, 70, 30);
		informacao.add(fldCarboidratos);
		
		JLabel lblSodio = new JLabel("Sódio (mg):");
		lblSodio.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSodio.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblSodio.setBounds(370, 20, 75, 30);
		informacao.add(lblSodio);
		
		fldSodio = new JTextField(alimento.getSodio() + "");
		fldSodio.setColumns(10);
		fldSodio.setBounds(450, 20, 70, 30);
		informacao.add(fldSodio);
		
		JLabel lblGorduras = new JLabel("Gorduras Totais (mg):");
		lblGorduras.setHorizontalAlignment(SwingConstants.RIGHT);
		lblGorduras.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblGorduras.setBounds(80, 60, 125, 30);
		informacao.add(lblGorduras);
		
		fldGorduras = new JTextField(alimento.getGorduras() + "");
		fldGorduras.setColumns(10);
		fldGorduras.setBounds(210, 60, 70, 30);
		informacao.add(fldGorduras);
		
		JLabel lblProteinas = new JLabel("Proteínas (mg):");
		lblProteinas.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProteinas.setFont(new Font("SansSerif", Font.BOLD, 12));
		lblProteinas.setBounds(290, 60, 95, 30);
		informacao.add(lblProteinas);
		
		fldProteinas = new JTextField(alimento.getProteina() + "");
		fldProteinas.setColumns(10);
		fldProteinas.setBounds(390, 60, 70, 30);
		informacao.add(fldProteinas);
	}
	
// Action Listeners	
	private final ActionListener ok = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			boolean erro = false; // Caso Algum Campo Esteja Incompleto ou Incorreto
						
			if(fldNome.getText().length() == 0) {
        		erro = true;
        		vibrar(fldNome);
			}
			
			if(fldPorcao.getText().length() == 0) {
				erro = true;
				vibrar(fldPorcao);
			}
			
			if(!erro) {
				String nome = fldNome.getText();
				int calorias;
				int carboidratos;
				int gorduras;
				int porcao;
				int proteina;
				int sodio;
				
				try { calorias = Integer.parseInt(fldCalorias.getText()); }
				catch (Exception e) { calorias = 0; }
				
				try { carboidratos = Integer.parseInt(fldCarboidratos.getText()); }
				catch (Exception e) { carboidratos = 0; }
				
				try { gorduras = Integer.parseInt(fldGorduras.getText()); }
				catch (Exception e) { gorduras = 0; }
				
				try { porcao = Integer.parseInt(fldPorcao.getText()); }
				catch (Exception e) { porcao = 0; }
				
				try { proteina = Integer.parseInt(fldProteinas.getText()); }
				catch (Exception e) { proteina = 0; }
				
				try { sodio = Integer.parseInt(fldSodio.getText()); }
				catch (Exception e) { sodio = 0; }
				
				Sistema.getAlimentos().set(index, new Alimento(nome, calorias, carboidratos, gorduras, porcao, proteina, sodio));
				((JFrame) getRootPane().getParent()).dispose(); // Fecha a Janela de Inclusão
			}
		}
	};
	
	private final ActionListener cancelar = arg0 -> {
        ((JFrame) getRootPane().getParent()).dispose(); // Fecha a Janela de Inclusão
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
