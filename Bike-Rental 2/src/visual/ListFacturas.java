package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import logica.Bike_Rental;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class ListFacturas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable tableF;
	private JTable tableP;
	private JTable tableS;
	private static Object[] filaF;
	private DefaultTableModel modelF;
	private static Object[] filaP;
	private DefaultTableModel modelP;
	private static Object[] filaS;
	private DefaultTableModel modelS;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListFacturas dialog = new ListFacturas();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListFacturas() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					loadFactura();
					loadProducto();
					loadServicio();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
			}
		});
		setTitle("Listado de Ventas");
		setResizable(false);
		setBounds(100, 100, 680, 530);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlFactura = new JPanel();
		pnlFactura.setBounds(75, 11, 487, 207);
		contentPanel.add(pnlFactura);
		pnlFactura.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		pnlFactura.add(scrollPane, BorderLayout.CENTER);
		
		tableF = new JTable();
		modelF = new DefaultTableModel();
		String[] columneNames = {"Id Factura", "Comprobante", "Fecha", "Id Cliente"};
		modelF.setColumnIdentifiers(columneNames);
		tableF.setModel(modelF);
		scrollPane.setViewportView(tableF);
		
		JPanel pnlProducto = new JPanel();
		pnlProducto.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlProducto.setBounds(10, 227, 351, 219);
		contentPanel.add(pnlProducto);
		pnlProducto.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		pnlProducto.add(scrollPane_1, BorderLayout.CENTER);
		
		tableP = new JTable();
		modelP = new DefaultTableModel();
		String[] columneNamesP = {"Id Factura", "Precio Venta", "Id Producto", "Cant. Venta"};
		modelP.setColumnIdentifiers(columneNamesP);
		tableP.setModel(modelP);
		scrollPane_1.setViewportView(tableP);
		
		JPanel pnlServicio = new JPanel();
		pnlServicio.setBorder(new TitledBorder(null, "Servicios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlServicio.setBounds(371, 229, 287, 219);
		contentPanel.add(pnlServicio);
		pnlServicio.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		pnlServicio.add(scrollPane_2, BorderLayout.CENTER);
		
		tableS = new JTable();
		modelS = new DefaultTableModel();
		String[] columneNamesS = {"Id Factura", "Id Servicio", "Precio"};
		modelS.setColumnIdentifiers(columneNamesS);
		tableS.setModel(modelS);
		scrollPane_2.setViewportView(tableS);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaptionBorder);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnCancelar = new JButton("Cancelar");
				btnCancelar.setIcon(new ImageIcon(ListFacturas.class.getResource("/icons/cancelar.png")));
				btnCancelar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose(); 
					}
				});
				btnCancelar.setActionCommand("Cancel");
				buttonPane.add(btnCancelar);
			}
		}
	}
	
	private void loadFactura() throws Exception{
		modelF.setRowCount(0);
		tableF.setModel(modelF);
		String sql = "select * from Factura"; 
		
			try {
				PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					filaF = new Object[modelF.getColumnCount()];
					for(int i = 0; i<modelF.getColumnCount(); i++) {
						filaF[i]=rs.getString(i+1);
					}
					modelF.addRow(filaF);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void loadProducto() throws Exception{
		modelP.setRowCount(0);
		tableP.setModel(modelP);
		String sql = "select * from ProductoFact"; 
		
			try {
				PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					filaP = new Object[modelP.getColumnCount()];
					for(int i = 0; i<modelP.getColumnCount(); i++) {
						filaP[i]=rs.getString(i+1);
					}
					modelP.addRow(filaP);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	private void loadServicio() throws Exception{
		modelS.setRowCount(0);
		tableS.setModel(modelS);
		String sql = "select * from ServiciosFact"; 
		
			try {
				PreparedStatement ps = Bike_Rental.getInstance().conectarSQL().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					filaS = new Object[modelS.getColumnCount()];
					for(int i = 0; i<modelS.getColumnCount(); i++) {
						filaS[i]=rs.getString(i+1);
					}
					modelS.addRow(filaS);
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
