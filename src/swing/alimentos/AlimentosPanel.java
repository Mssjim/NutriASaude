package swing.alimentos;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import assets.Cor;
import principal.Sistema;
import swing.DefaultPanel;
import swing.Janela;

public class AlimentosPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTable table;
	private final DefaultTableModel model;

	public AlimentosPanel() {
		setSize(540, 480);
		setLayout(null);
		
		model = new DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "Nome", "Porção", "Kcal", "Carboidratos", "G. Totais", "Proteina", "Sódio"
	            }
	        ) {
			private static final long serialVersionUID = 1L;
				final Class[] types = new Class [] {
	                String.class, String.class, Integer.class, String.class, String.class, String.class, String.class
	            };
	            final boolean[] canEdit = new boolean [] {
	            	false, false, false, false, false, false, false
	            };

	            public Class<?> getColumnClass(int columnIndex) {
	                return types [columnIndex];
	            }

	            public boolean isCellEditable(int rowIndex, int columnIndex) {
	                return canEdit [columnIndex];
	            }
	        };
		atualizarTabela();

		table = new JTable();
		table.setSelectionBackground(Cor.principal);
		table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		table.setModel(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(135);
        table.getColumnModel().getColumn(1).setPreferredWidth(60);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(90);
        table.getColumnModel().getColumn(4).setPreferredWidth(65);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);
        table.getColumnModel().getColumn(6).setPreferredWidth(60);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(10, 10, 520, 400);
		scrollPanel.setViewportView(table);
		add(scrollPanel);
		
		JButton btnNovoAlimento = new JButton("Novo Alimento");
		btnNovoAlimento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoAlimento.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNovoAlimento.setBounds(390, 430, 140, 40);
		btnNovoAlimento.addActionListener(novoAlimento);
		add(btnNovoAlimento);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnExcluir.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnExcluir.setBounds(280, 430, 100, 40);
		btnExcluir.addActionListener(excluir);
		add(btnExcluir);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(editar);
		btnEditar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnEditar.setBounds(170, 430, 100, 40);
		add(btnEditar);
	}
	
	private void atualizarTabela() {
		// Atualiza Tabela
		model.setRowCount(0);
		if(Sistema.getAlimentos() != null) {
        	for(int i = 0; i < Sistema.getAlimentos().size(); i++) {
        		model.addRow(new Object[] {
        			Sistema.getAlimentos().get(i).getNome(),
        			Sistema.getAlimentos().get(i).getPorcao() + "g",
        			Sistema.getAlimentos().get(i).getCalorias(),
        			Sistema.getAlimentos().get(i).getCarboidratos() + "g",
        			Sistema.getAlimentos().get(i).getGorduras() + "mg",
        			Sistema.getAlimentos().get(i).getProteina() + "mg",
        			Sistema.getAlimentos().get(i).getSodio() + "mg"
        		});
    		}
		}
	}
	
// Action Listeners
	private final ActionListener novoAlimento = arg0 -> {
		Janela janela = new Janela("Novo Alimento");
		janela.setContent(new NovoAlimentoPanel());
		janela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				atualizarTabela();
			}
		});
	};

	private final ActionListener excluir = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
    			int index = table.getSelectedRow();
    			int confirmar = JOptionPane.showConfirmDialog(null, "Deseja Excluir " + Sistema.getAlimentos().get(index).getNome() + "?", "Nutri A+Saúde", JOptionPane.YES_NO_OPTION);
    			if(confirmar == 0) {
    				Sistema.getAlimentos().remove(index);
    				atualizarTabela();
    			}
			} catch (Exception e) { /* Nenhum Item Selecionado */ }
		}
	};
	
	private final ActionListener editar = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			try {
    			int index = table.getSelectedRow();
    			Janela janela = new Janela("Editar Alimento");
    			janela.setContent(new EditarAlimentoPanel(index));
    			janela.addWindowListener(new WindowAdapter() {
    				@Override
    				public void windowClosed(WindowEvent e) {					
    					DefaultPanel.setPanel(new AlimentosPanel());
    				}
    			});
			} catch (Exception e) { /* Nenhum Item Selecionado */ }
		}
	};
}
