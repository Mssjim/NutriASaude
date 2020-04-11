package swing.agenda;

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
import javax.swing.table.DefaultTableModel;

import assets.Cor;
import principal.Data;
import principal.Sistema;
import swing.DefaultPanel;
import swing.Janela;

public class AgendaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private final JTable table;
	private final DefaultTableModel model;

	public AgendaPanel() {
		setSize(540, 480);
		setLayout(null);
		
		model = new DefaultTableModel(
	            new Object [][] {},
	            new String [] {
	                "Horário - Data", "Paciente"
	            }
	        ) {
			private static final long serialVersionUID = 1L;
	            final Class[] types = new Class [] {
	                Data.class, String.class
	            };
	            final boolean[] canEdit = new boolean [] {
	                false, false
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
        table.getColumnModel().getColumn(1).setPreferredWidth(320);
        table.addMouseListener(selecionar);
		JScrollPane scrollPanel = new JScrollPane();
		scrollPanel.setBounds(10, 10, 520, 400);
		scrollPanel.setViewportView(table);
		add(scrollPanel);
		
		JButton btnNovoAgendamento = new JButton("Novo Agendamento");
		btnNovoAgendamento.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNovoAgendamento.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnNovoAgendamento.setBounds(390, 430, 140, 40);
		btnNovoAgendamento.addActionListener(novoAgendamento);
		add(btnNovoAgendamento);
		
		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisar.setFont(new Font("SansSerif", Font.BOLD, 12));
		btnPesquisar.setBounds(260, 430, 120, 40);
		btnPesquisar.addActionListener(pesquisar);
		add(btnPesquisar);
	}
	
	private void atualizarTabela() {
		// Atualiza Tabela
		model.setRowCount(0);
		if(Sistema.getAgendamentos() != null) {
        	for(int i = 0; i < Sistema.getAgendamentos().size(); i++) {
        		model.addRow(new Object[] {
        			Sistema.getAgendamentos().get(i).getData().exibir(),
        			Sistema.getAgendamentos().get(i).getPaciente().getNome()
        		});
    		}
		}
	}
	
// Action Listeners
	private final ActionListener novoAgendamento = arg0 -> {
		Janela janela = new Janela("Novo Agendamento");
		janela.setContent(new NovoAgendamentoPanel());
		janela.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosed(WindowEvent e) {
				atualizarTabela();
			}
		});
	};
	
	private final ActionListener pesquisar = new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			String cpf = JOptionPane.showInputDialog(null, "Informe o CPF do Paciente:", "Nutri A+Saúde", JOptionPane.PLAIN_MESSAGE);
			
			if(cpf.length() == 11) {
    			StringBuilder sb = new StringBuilder(cpf);
    			sb.insert(3, '.');
    			sb.insert(7, '.');
    			sb.insert(11, '-');
    			cpf = sb.toString();
    			
    			if(Sistema.getAgendamentos() != null) {
					model.setRowCount(0);
					for(int i = 0; i < Sistema.getAgendamentos().size(); i++) {
        				if(cpf.equals(Sistema.getAgendamentos().get(i).getPaciente().getCpf())) {
        					// Exibe Dados do Agendamento
        					model.addRow(new Object[] {
    		        			Sistema.getAgendamentos().get(i).getData().exibir(),
    		        			Sistema.getAgendamentos().get(i).getPaciente().getNome()
    		        		});
        				}
	    			}
    			}
    		} else {
    			JOptionPane.showMessageDialog(null, "Informe um CPF Valido!", "Nutri A+Saude", JOptionPane.INFORMATION_MESSAGE);
    			pesquisar.actionPerformed(null);
    		}
		}
	};
		
	private final MouseAdapter selecionar = new MouseAdapter() {
		public void mouseClicked(MouseEvent e) {
			int index = table.getSelectedRow();
			DefaultPanel.setPanel(new AgendamentoPanel(index));
		}
	};
}
