package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logica.Bike_Rental;
import logica.Cliente;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class ListCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private DefaultTableModel model;
	private String cod; 
	private JButton BtnModificar;
	private JButton btnEliminar;
	private Cliente cli = null; 
	

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { try { ListCliente dialog = new
	 * ListCliente(); dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
	 * dialog.setVisible(true); } catch (Exception e) { e.printStackTrace(); } }
	 */

	/**
	 * Create the dialog.
	 * @throws Exception 
	 */
	public ListCliente() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ListCliente.class.getResource("/icons/Listas.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					loadTable();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setResizable(false);
		setTitle("Listar Cliente");
		setBounds(100, 100, 825, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new TitledBorder(null, "Lista de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 799, 414);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 24, 779, 368);
			panel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int aux = table.getSelectedRow();
					
					if (aux > -1) {

						BtnModificar.setEnabled(true);
						btnEliminar.setEnabled(true);
						cod = (String) table.getModel().getValueAt(aux, 1);

					} else {
						BtnModificar.setEnabled(false);
						btnEliminar.setEnabled(false);
						String cod = "";
					}

				}
			});
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			scrollPane.setViewportView(table);
			model = new DefaultTableModel();
			String[] columneNames = {"Id", "C�dula", "Nombre", "Seg. Nombre", "Apellido", "Calle", "Ciudad", "Cod. Postal", "Tel�fono", "Provincia" };
			model.setColumnIdentifiers(columneNames);
			table.setModel(model);
			table.getTableHeader().setResizingAllowed(false);
			
			scrollPane.setViewportView(table);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnEliminar = new JButton("Eliminar");
				btnEliminar.setIcon(new ImageIcon(ListCliente.class.getResource("/icons/borrar.png")));
				btnEliminar.setEnabled(false);
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cod != "") {
							int answer = JOptionPane.showConfirmDialog(null, "Seguro que desea eliminar el cliente?",
									"Devolver publicacion", JOptionPane.YES_NO_CANCEL_OPTION,
									JOptionPane.QUESTION_MESSAGE, null);
							if (answer == JOptionPane.YES_OPTION) {
								BtnModificar.setEnabled(false);
								btnEliminar.setEnabled(false);
								try {
									Bike_Rental.getInstance().deleteCliente(cod);
									loadTable();
								} catch (Exception e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								
							}

						
						}
					}
				});
				buttonPane.add(btnEliminar);
			}
			{
				BtnModificar = new JButton("Modificar");
				BtnModificar.setIcon(new ImageIcon(ListCliente.class.getResource("/icons/modificar.png")));
				BtnModificar.setEnabled(false);
				BtnModificar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if (cod != "") {
							try {
								cli = Bike_Rental.getInstance().searchClienteByCed(cod);
							} catch (SQLException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						

						}
							InsertCliente modificarClient = new InsertCliente("Modificar Cliente", true, cli);
							modificarClient.setModal(true);
							modificarClient.setLocationRelativeTo(null);
							modificarClient.setVisible(true);
							BtnModificar.setEnabled(false);
							btnEliminar.setEnabled(false);
							try {
								loadTable();
							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
					}
				});
				BtnModificar.setActionCommand("OK");
				buttonPane.add(BtnModificar);
				getRootPane().setDefaultButton(BtnModificar);
			}
			{
				JButton BtnCancelar = new JButton("Cancelar");
				BtnCancelar.setIcon(new ImageIcon(ListCliente.class.getResource("/icons/cancelar.png")));
				BtnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				BtnCancelar.setActionCommand("Cancel");
				buttonPane.add(BtnCancelar);
			}
		}
	}
	
	private void loadTable() throws Exception{
		model.setRowCount(0);
		table.setModel(model);
		String sql = "select * from Cliente"; 
		
			try {
				PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					fila = new Object[model.getColumnCount()];
					for(int i = 0; i<model.getColumnCount(); i++) {
						fila[i]=rs.getString(i+1);
					}
					model.addRow(fila);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			table.getTableHeader().setReorderingAllowed(false);
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(40);
			columnModel.getColumn(1).setPreferredWidth(90);
			columnModel.getColumn(2).setPreferredWidth(70);
			columnModel.getColumn(3).setPreferredWidth(80);
			columnModel.getColumn(4).setPreferredWidth(75);
			columnModel.getColumn(5).setPreferredWidth(80);
			columnModel.getColumn(6).setPreferredWidth(80);
			columnModel.getColumn(7).setPreferredWidth(80);
			columnModel.getColumn(8).setPreferredWidth(90);
			columnModel.getColumn(9).setPreferredWidth(90);
		}


}

