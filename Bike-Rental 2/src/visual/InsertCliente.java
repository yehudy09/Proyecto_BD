package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import java.text.ParseException;

import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import logica.Bike_Rental;
import logica.Cliente;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JFormattedTextField;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class InsertCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textFname;
	private JTextField textSname;
	private JTextField textCiudad;
	private JTextField textCalle;
	private JFormattedTextField ftextTelf;
	private JFormattedTextField ftextCedula;
	private JFormattedTextField ftextCodigo;
	private JTextField textLname;
	private JComboBox cbxProvincia;
	private Cliente miCliente = null; 

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public InsertCliente() {
		setTitle("Insertar Cliente");
		setResizable(false);
		setBounds(100, 100, 614, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel pnlInformacion = new JPanel();
		pnlInformacion.setLayout(null);
		pnlInformacion.setBorder(new TitledBorder(null, "Informaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlInformacion.setBackground(SystemColor.inactiveCaptionBorder);
		pnlInformacion.setBounds(10, 21, 588, 162);
		contentPanel.add(pnlInformacion);
		
		JLabel lblCedula = new JLabel("C\u00E9dula:");
		lblCedula.setBounds(313, 54, 46, 14);
		pnlInformacion.add(lblCedula);
		
		JLabel lblName = new JLabel("Primer Nombre:");
		lblName.setBounds(10, 32, 97, 14);
		pnlInformacion.add(lblName);
		
		JLabel lblSname = new JLabel("Segundo Nombre:");
		lblSname.setBounds(10, 70, 114, 14);
		pnlInformacion.add(lblSname);
		
		textFname = new JTextField();
		textFname.setColumns(10);
		textFname.setBackground(Color.WHITE);
		textFname.setBounds(117, 32, 174, 23);
		pnlInformacion.add(textFname);
		
		textSname = new JTextField();
		textSname.setColumns(10);
		textSname.setBackground(Color.WHITE);
		textSname.setBounds(117, 66, 174, 23);
		pnlInformacion.add(textSname);
		
		MaskFormatter mascara1;
		try {
			mascara1 = new MaskFormatter("###-###-####");
			ftextTelf = new JFormattedTextField(mascara1);
			ftextTelf.setColumns(10);
			ftextTelf.setBackground(Color.WHITE);
			ftextTelf.setBounds(404, 87, 174, 23);
			pnlInformacion.add(ftextTelf);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		JLabel lblTelf = new JLabel("Tel\u00E9fono:");
		lblTelf.setBounds(313, 91, 62, 14);
		pnlInformacion.add(lblTelf);
		
		MaskFormatter mascaraCedula;
		try {
			mascaraCedula = new MaskFormatter("###-#######-#");
			mascaraCedula.setPlaceholderCharacter('_');
		    ftextCedula = new JFormattedTextField(mascaraCedula);
		    ftextCedula.setBounds(404, 51, 174, 20);
		    pnlInformacion.add(ftextCedula);
		    
		    textLname = new JTextField();
		    textLname.setColumns(10);
		    textLname.setBackground(Color.WHITE);
		    textLname.setBounds(117, 105, 174, 23);
		    pnlInformacion.add(textLname);
		    
		    JLabel lblApellido = new JLabel("Apellido:");
		    lblApellido.setBounds(24, 108, 62, 14);
		    pnlInformacion.add(lblApellido);
		
		}catch (ParseException e) {
			e.printStackTrace();
		}
		
		JPanel pnlUbicacion = new JPanel();
		pnlUbicacion.setLayout(null);
		pnlUbicacion.setBorder(new TitledBorder(null, "Ubicaci\u00F3n:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlUbicacion.setBackground(SystemColor.inactiveCaptionBorder);
		pnlUbicacion.setBounds(10, 194, 588, 150);
		contentPanel.add(pnlUbicacion);
		
		JLabel lblProvincia = new JLabel("Provincia:   ");
		lblProvincia.setBounds(10, 44, 73, 14);
		pnlUbicacion.add(lblProvincia);
		
		cbxProvincia = new JComboBox();
		cbxProvincia.setModel(new DefaultComboBoxModel(new String[] {
				"<Seleccione>", "Azua ", "Bahoruco ", "Barahona ",
				"Dajabón ", "Distrito Nacional ", "Duarte ",
				"Elías Piña ", "El Seibo ", "Espaillat ",
				"Hato Mayor ", "Independencia ", "La Altagracia ",
				"La Romana ", "La Vega ", "María Trinidad Sánchez ",
				"Monseñor Nouel ", "Montecristi ", "Monte Plata ",
				"Pedernales ", "Peravia ", "Puerto Plata ",
				"Hermanas Mirabal ", "Samaná ",
				"Sánchez Ramírez ", "San Cristóbal ",
				"San José de Ocoa ", "San Juan ",
				"San Pedro de Macorís ", "Santiago ",
				"Santiago Rodríguez ", "Santo Domingo ", "Valverde "}));
		cbxProvincia.setBackground(Color.WHITE);
		cbxProvincia.setBounds(93, 44, 174, 23);
		pnlUbicacion.add(cbxProvincia);
		
		JLabel lblCode = new JLabel("C\u00F3digo Postal:");
		lblCode.setBounds(10, 90, 88, 14);
		pnlUbicacion.add(lblCode);
		
		textCiudad = new JTextField();
		textCiudad.setColumns(10);
		textCiudad.setBackground(Color.WHITE);
		textCiudad.setBounds(405, 41, 174, 23);
		pnlUbicacion.add(textCiudad);
		
		JLabel lblCiudad = new JLabel("Ciudad:");
		lblCiudad.setBounds(312, 41, 62, 14);
		pnlUbicacion.add(lblCiudad);
		
		JLabel lblCalle = new JLabel("Calle:");
		lblCalle.setBounds(312, 90, 46, 14);
		pnlUbicacion.add(lblCalle);
		
		textCalle = new JTextField();
		textCalle.setColumns(10);
		textCalle.setBackground(Color.WHITE);
		textCalle.setBounds(405, 87, 174, 23);
		pnlUbicacion.add(textCalle);
		
		MaskFormatter mascaraCodigo;
		try {
			mascaraCodigo = new MaskFormatter("#####");
			ftextCodigo = new JFormattedTextField(mascaraCodigo);
			ftextCodigo.setColumns(10);
			ftextCodigo.setBackground(Color.WHITE);
			ftextCodigo.setBounds(143, 87, 124, 20);
			pnlUbicacion.add(ftextCodigo);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SystemColor.inactiveCaption);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton BtnRegistrar = new JButton("Registrar");
				BtnRegistrar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String cedula = ftextCedula.getText();
						String Fname = textFname.getText();
						String Sname = textSname.getText();
						String Lname = textLname.getText();
						String tel = ftextTelf.getText();
						String Cod = ftextCodigo.getText();
						String Ciudad = textCiudad.getText();
						String Calle = textCalle.getText();
						String Provincia = cbxProvincia.getSelectedItem().toString();
						Cliente miCliente = new Cliente(cedula, Fname, Sname, Lname, Calle, Ciudad, tel, Cod, Provincia);
						try {
							Bike_Rental.getInstance().insertCliente(miCliente);
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				});
				BtnRegistrar.setActionCommand("OK");
				buttonPane.add(BtnRegistrar);
				getRootPane().setDefaultButton(BtnRegistrar);
			}
			{
				JButton BtnCancelar = new JButton("Cancelar");
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
}
