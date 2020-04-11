package swing.pacientes;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.table.DefaultTableModel;

import assets.Cor;
import principal.Sistema;
import swing.DefaultPanel;
import swing.Janela;

public class PacientesPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTable table;
	private final DefaultTableModel model;
	
	private final JToggleButton btnInativos;

	public PacientesPanel() {
		setSize(540, 480);
		setLayout(null);
		
		model = new DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "Nome", "Descrição", "Idade"
	            }
	        ) {
			private static final long serialVersionUID = 1L;
	            final Class[] types = new Class [] {
	                String.class, String.class, Integer.class
	            };
	            final boolean[] canEdit = new boolean [] {
	                false, false, false
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
        table.getColumnModel().getColumn(0).setPreferredWidth(200);
        table.getColumnModel().getColumn(1).setPreferredWidth(270);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.addMouseListener(selecionar);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(10, 10, 520, 400);
		scrollPanel.setViewportView(table);
		add(scrollPanel);
		
		JButton btnNovoPaciente = new JButton("Novo Paciente");
		btnNovoPaciente.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoPaciente.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNovoPaciente.setBounds(410, 430, 120, 40);
		btnNovoPaciente.addActionListener(novoPaciente);
		add(btnNovoPaciente);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnPesquisar.setBounds(280, 430, 120, 40);
		btnPesquisar.addActionListener(pesquisar);
		add(btnPesquisar);
		
		btnInativos = new JToggleButton("Inativos");
		btnInativos.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnInativos.addActionListener(inativos);
		btnInativos.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnInativos.setBounds(150, 430, 120, 40);
		btnInativos.addActionListener(inativos);
		add(btnInativos);
	}
	
	private void atualizarTabela() {
		// Atualiza Tabela
		model.setRowCount(0);
		if(Sistema.getPacientes() != null) {
        	for(int i = 0; i < Sistema.getPacientes().size(); i++) {
        		model.addRow(new Object[] {
        			Sistema.getPacientes().get(i).getNome(),
        			Sistema.getPacientes().get(i).getDescricao(),
        			Sistema.getPacientes().get(i).calcularIdade()
        		});
    		}
		}
	}
	
// Action Listeners
	private final ActionListener novoPaciente = arg0 -> {
        Janela janela = new Janela("Cadastrar Paciente");
        janela.setContent(new NovoPacientePanel());
        janela.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                atualizarTabela();
            }
        });
    };
	
	private final ActionListener pesquisar = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String cpf = JOptionPane.showInputDialog(null, "Informe o CPF:", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE);
			
			if(cpf.length() == 11) {
    			StringBuilder sb = new StringBuilder(cpf);
    			sb.insert(3, '.');
    			sb.insert(7, '.');
    			sb.insert(11, '-');
    			cpf = sb.toString();

    			if(btnInativos.isSelected()) {
    				if(Sistema.getInativos() != null) {
        				for(int i = 0; i < Sistema.getInativos().size(); i++) {
            				if(cpf.equals(Sistema.getInativos().get(i).getCpf())) {
            					// Exibe Dados do Paciente
            					DefaultPanel.setPanel(new PacientePanel(i, true));
            					break;
            				} else if(i == Sistema.getInativos().size() - 1) {
            					JOptionPane.showMessageDialog(null, "Paciente Não Encontrado!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
            				}
    	    			}
    				}
    			} else {
    				if(Sistema.getPacientes() != null) {
    				for(int i = 0; i < Sistema.getPacientes().size(); i++) {
        				if(cpf.equals(Sistema.getPacientes().get(i).getCpf())) {
        					// Exibe Dados do Paciente
        					DefaultPanel.setPanel(new PacientePanel(i, false));
        					break;
        				} else if(i == Sistema.getPacientes().size() - 1) {
        					JOptionPane.showMessageDialog(null, "Paciente Não Encontrado!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
        				}
	    			}
    			}
    			
    			
    			}
			} else {
				JOptionPane.showMessageDialog(null, "Informe um CPF Valido!", "Nutri A+Saúde", JOptionPane.INFORMATION_MESSAGE);
				pesquisar.actionPerformed(null);
			}
		}
	};
	
	private final ActionListener inativos = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(btnInativos.isSelected()) {
				// Atualiza Tabela
				model.setRowCount(0);
				if(Sistema.getInativos() != null) {
		        	for(int i = 0; i < Sistema.getInativos().size(); i++) {
		        		model.addRow(new Object[] {
		        			Sistema.getInativos().get(i).getNome(),
		        			Sistema.getInativos().get(i).getDescricao(),
		        			Sistema.getInativos().get(i).calcularIdade()
		        		});
		    		}
				}
			} else {
				atualizarTabela();
			}
		}
	};
	
	private final MouseAdapter selecionar = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int index = table.getSelectedRow();
			if(btnInativos.isSelected())
				DefaultPanel.setPanel(new PacientePanel(index, true));
			else
				DefaultPanel.setPanel(new PacientePanel(index, false));
		}
	};
}
