package visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import logica.Bike_Rental;
import logica.Cliente;
import logica.Proveedor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class InsertProveedor extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField Fnametxt;
	private JTextField Snametxt;
	private JTextField Lnametxt;
	private JTextField Marcatxt;
	private JTextField CodPostxt;
	private JTextField Ciudadtxt;
	private JTextField Calletxt;
	private JFormattedTextField cedulaJF;
	private JFormattedTextField TelefonoJF;
	private JComboBox Provinciacbx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			InsertProveedor dialog = new InsertProveedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public InsertProveedor() {
		setTitle("Registrar Proveedor");
		setBounds(100, 100, 622, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel InfoProv = new JPanel();
			InfoProv.setBackground(SystemColor.inactiveCaptionBorder);
			InfoProv.setBorder(new TitledBorder(null, "Informaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			InfoProv.setToolTipText("");
			InfoProv.setBounds(10, 11, 586, 185);
			contentPanel.add(InfoProv);
			InfoProv.setLayout(null);
			{
				JLabel Fnamelbl = new JLabel("Primer nombre: ");
				Fnamelbl.setBounds(10, 34, 92, 14);
				InfoProv.add(Fnamelbl);
			}
			{
				JLabel Snamelbl = new JLabel("Segundo nombre: ");
				Snamelbl.setBounds(10, 86, 108, 14);
				InfoProv.add(Snamelbl);
			}
			{
				JLabel Lnamelbl = new JLabel("Apellido:");
				Lnamelbl.setBounds(10, 136, 66, 14);
				InfoProv.add(Lnamelbl);
			}
			
			Fnametxt = new JTextField();
			Fnametxt.setBackground(Color.WHITE);
			Fnametxt.setBounds(128, 31, 128, 20);
			InfoProv.add(Fnametxt);
			Fnametxt.setColumns(10);
			
			Snametxt = new JTextField();
			Snametxt.setBackground(Color.WHITE);
			Snametxt.setBounds(128, 83, 128, 20);
			InfoProv.add(Snametxt);
			Snametxt.setColumns(10);
			
			Lnametxt = new JTextField();
			Lnametxt.setBackground(Color.WHITE);
			Lnametxt.setBounds(128, 133, 128, 20);
			InfoProv.add(Lnametxt);
			Lnametxt.setColumns(10);
			
			JLabel cedulalbl = new JLabel("C\u00E9dula: ");
			cedulalbl.setBounds(324, 34, 66, 14);
			InfoProv.add(cedulalbl);
			
			JLabel Telflbl = new JLabel("Tel\u00E9fono:");
			Telflbl.setBounds(324, 86, 66, 14);
			InfoProv.add(Telflbl);
			
			JLabel marcalbl = new JLabel("Marca a suplir:");
			marcalbl.setBounds(319, 136, 97, 14);
			InfoProv.add(marcalbl);
			
			
			MaskFormatter mascaraCedula;
			try {
				mascaraCedula = new MaskFormatter("###-#######-#");
				mascaraCedula.setPlaceholderCharacter('_');
			    cedulaJF = new JFormattedTextField(mascaraCedula);
			    cedulaJF.setBackground(Color.WHITE);
				cedulaJF.setBounds(426, 31, 136, 20);
				InfoProv.add(cedulaJF);
				
			
			}catch (ParseException e) {
				e.printStackTrace();
			}
			
			
			MaskFormatter mascaratel;
			try {
				mascaratel = new MaskFormatter("###-###-####");
				
				TelefonoJF = new JFormattedTextField(mascaratel);
				TelefonoJF.setBackground(Color.WHITE);
				TelefonoJF.setColumns(10);
				TelefonoJF.setBounds(426, 83, 136, 20);
				InfoProv.add(TelefonoJF);
				
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			
			
			Marcatxt = new JTextField();
			Marcatxt.setBackground(Color.WHITE);
			Marcatxt.setText("");
			Marcatxt.setBounds(426, 133, 136, 20);
			InfoProv.add(Marcatxt);
			Marcatxt.setColumns(10);
		}
		{
			JPanel DireccionProv = new JPanel();
			DireccionProv.setBackground(SystemColor.inactiveCaptionBorder);
			DireccionProv.setBorder(new TitledBorder(null, "Direcci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			DireccionProv.setBounds(10, 207, 586, 146);
			contentPanel.add(DireccionProv);
			DireccionProv.setLayout(null);
			
			JLabel Callelbl = new JLabel("Calle: ");
			Callelbl.setBounds(301, 44, 46, 14);
			DireccionProv.add(Callelbl);
			
			JLabel ciudadlbl = new JLabel("Ciudad: ");
			ciudadlbl.setBounds(10, 101, 57, 14);
			DireccionProv.add(ciudadlbl);
			
			JLabel CodigoPostlbl = new JLabel("C\u00F3digo Postal: ");
			CodigoPostlbl.setBounds(301, 101, 91, 14);
			DireccionProv.add(CodigoPostlbl);
			
			CodPostxt = new JTextField();
			CodPostxt.setBackground(Color.WHITE);
			CodPostxt.setBounds(393, 98, 175, 20);
			DireccionProv.add(CodPostxt);
			CodPostxt.setColumns(10);
			
			Ciudadtxt = new JTextField();
			Ciudadtxt.setBackground(Color.WHITE);
			Ciudadtxt.setBounds(95, 98, 175, 20);
			DireccionProv.add(Ciudadtxt);
			Ciudadtxt.setColumns(10);
			
			Calletxt = new JTextField();
			Calletxt.setBackground(Color.WHITE);
			Calletxt.setBounds(393, 41, 175, 20);
			DireccionProv.add(Calletxt);
			Calletxt.setColumns(10);
			
			JLabel Provincialbl = new JLabel("Provincia: ");
			Provincialbl.setBounds(10, 43, 75, 14);
			DireccionProv.add(Provincialbl);
			
			Provinciacbx = new JComboBox();
			Provinciacbx.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ", "Dajab\u00F3n ", "Distrito Nacional ", "Duarte ", "El\u00EDas Pi\u00F1a ", "El Seibo ", "Espaillat ", "Hato Mayor ", "Independencia ", "La Altagracia ", "La Romana ", "La Vega ", "Mar\u00EDa Trinidad S\u00E1nchez ", "Monse\u00F1or Nouel ", "Montecristi ", "Monte Plata ", "Pedernales ", "Peravia ", "Puerto Plata ", "Hermanas Mirabal ", "Saman\u00E1 ", "S\u00E1nchez Ram\u00EDrez ", "San Crist\u00F3bal ", "San Jos\u00E9 de Ocoa ", "San Juan ", "San Pedro de Macor\u00EDs ", "Santiago ", "Santiago Rodr\u00EDguez ", "Santo Domingo ", "Valverde "}));
			Provinciacbx.setBounds(95, 40, 175, 22);
			DireccionProv.add(Provinciacbx);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Registrar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						Proveedor auxprov = null;
						/*if(cedulaJF.getText().equalsIgnoreCase(auxprov.getCedula())) {
							
							JOptionPane.showMessageDialog(null,"Ya existe un cliente registrado con esa cedula");
						}*/
						
						String cedula = cedulaJF.getText();
						String Fname = Fnametxt.getText();
						String Sname = Snametxt.getText();
						String Lname = Lnametxt.getText();
						String tel = TelefonoJF.getText();
						String Cod = CodPostxt.getText();
						String Ciudad = Ciudadtxt.getText();
						String Calle = Calletxt.getText();
						String Marca = Marcatxt.getText();
						String Provincia = Provinciacbx.getSelectedItem().toString();
						Proveedor miProveedor = new Proveedor(cedula, Fname, Sname, Lname, Calle, Ciudad, tel, Cod, Marca, Provincia);
		
						try {
							Bike_Rental.getInstance().insertProveedor(miProveedor);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
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
}
