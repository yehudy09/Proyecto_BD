package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import logica.Bike_Rental;
import logica.Proveedor;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static Object[] fila;
	private DefaultTableModel model;
	private JTable table;
	private String auxi;
	private JButton modificarbtt;
	private JButton eliminarbtt;
	private Proveedor prov = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListProveedor dialog = new ListProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListProveedor() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					cargarProveedor();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setBounds(100, 100, 833, 498);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Lista de proveedores", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		panel.setBounds(10, 11, 797, 414);
		contentPanel.add(panel);
		panel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 24, 777, 368);
			panel.add(scrollPane);
			{
				table = new JTable();
				table.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						int aux = table.getSelectedRow();
						
						if (aux > -1) {

							modificarbtt.setEnabled(true);
							eliminarbtt.setEnabled(true);
							auxi = (String) table.getModel().getValueAt(aux, 1);

						} else {
							modificarbtt.setEnabled(false);
							eliminarbtt.setEnabled(false);
							String cod = "";
						}
					}
				});
				scrollPane.setViewportView(table);
				model = new DefaultTableModel();
				String[] columneNames = {"ID", "Cédula", "Nombre", "Seg. Nombre", "Apellido", "Calle", "Ciudad",  "Cod. Postal", "Télefono", "Marca a suplir",  "Provincia", };
				model.setColumnIdentifiers(columneNames);
				table.setModel(model);
				table.getTableHeader().setResizingAllowed(false);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				eliminarbtt = new JButton("Eliminar");
				eliminarbtt.setEnabled(false);
				eliminarbtt.setActionCommand("OK");
				buttonPane.add(eliminarbtt);
				getRootPane().setDefaultButton(eliminarbtt);
			}
			{
				modificarbtt = new JButton("Modificar");
				modificarbtt.setEnabled(false);
				modificarbtt.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				buttonPane.add(modificarbtt);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
			
			
		}
	}
	
	
	
	private void cargarProveedor() throws Exception{
		model.setRowCount(0);
		table.setModel(model);
		String sql = "select * from Proveedor"; 
		
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
			columnModel.getColumn(5).setPreferredWidth(90);
			columnModel.getColumn(6).setPreferredWidth(80);
			columnModel.getColumn(7).setPreferredWidth(80);
			columnModel.getColumn(8).setPreferredWidth(90);
			columnModel.getColumn(9).setPreferredWidth(90);
		
}
}
