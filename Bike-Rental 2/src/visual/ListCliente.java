package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;

public class ListCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private static Object[] fila;
	private DefaultTableModel model;
	private Cliente micli; 

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
	 */
	public ListCliente() {
		setResizable(false);
		setTitle("Listar Cliente");
		setBounds(100, 100, 800, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
	//	loadTable();
		{
			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.inactiveCaptionBorder);
			panel.setBorder(new TitledBorder(null, "Lista de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel.setBounds(10, 11, 774, 414);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 24, 754, 368);
			panel.add(scrollPane);
			
			table = new JTable();
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int aux = table.getSelectedRow();

				}
			});
			scrollPane.setViewportView(table);
			model = new DefaultTableModel();
			String[] columneNames = { "Cédula", "Nombre", "Seg. Nombre", "Apellido", "Teléfono", "Calle", "Ciudad", "Provincia", "Cod. Postal" };
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
				JButton btnEliminar = new JButton("Eliminar");
				buttonPane.add(btnEliminar);
			}
			{
				JButton BtnModificar = new JButton("Modificar");
				BtnModificar.setActionCommand("OK");
				buttonPane.add(BtnModificar);
				getRootPane().setDefaultButton(BtnModificar);
			}
			{
				JButton BtnCancelar = new JButton("Cancelar");
				BtnCancelar.setActionCommand("Cancel");
				buttonPane.add(BtnCancelar);
			}
		}
	}
	
	/*private void loadTable() {
		model.setRowCount(0);
		fila = new Object[model.getColumnCount()];
		for (Cliente micl : Bike_Rental.getInstance().getMisClientes()) {
			fila[0] = micl.getCedula();
			fila[1] = micl.getFname();
			fila[2] = micl.getSname();
			fila[3] = micl.getLname();
			fila[4] = micl.getTel();
			fila[5] = micl.getCalle();
			fila[6] = micl.getCiudad();
			fila[7] = micl.getProvincia();
			fila[8] = micl.getPostalCode();
			model.addRow(fila);

		}
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.getTableHeader().setReorderingAllowed(false);
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(90);
		columnModel.getColumn(1).setPreferredWidth(80);
		columnModel.getColumn(2).setPreferredWidth(90);
		columnModel.getColumn(3).setPreferredWidth(90);
		columnModel.getColumn(4).setPreferredWidth(80);
		columnModel.getColumn(5).setPreferredWidth(80);
		columnModel.getColumn(6).setPreferredWidth(80);
		columnModel.getColumn(7).setPreferredWidth(85);
		columnModel.getColumn(8).setPreferredWidth(76);

	}*/
}
