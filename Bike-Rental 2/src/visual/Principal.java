package visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

import logica.Bike_Rental;

import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

public class Principal extends JFrame {

	private JPanel contentPane;
	private Dimension dim = null;
	private JLabel lblhora; 
	private JLabel lblyear; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					Bike_Rental.getInstance().deleteLogUser();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setIconImage(Toolkit.getDefaultToolkit().getImage(Principal.class.getResource("/icons/Cyclist-icon.png")));
		setTitle("BIKE-RENTAL, STORE MANAGER");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		dim = super.getToolkit().getScreenSize();
		super.setSize(dim.width, (dim.height-50));
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.activeCaption);
		setJMenuBar(menuBar);
		
		JMenu mnRegistrar = new JMenu("Registrar");
		mnRegistrar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnRegistrar);
		
		JMenuItem mntmCliente = new JMenuItem("Cliente");
		mntmCliente.setIcon(new ImageIcon(Principal.class.getResource("/icons/agregarSolicitante.png")));
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsertCliente cl;
				cl = new InsertCliente("Insertar Cliente", false, null);
				cl.setModal(true);
				cl.setLocationRelativeTo(null);
				cl.setVisible(true);
			}
		});
		mnRegistrar.add(mntmCliente);
		
		JMenuItem mntmEmpleado = new JMenuItem("Empleado");
		mntmEmpleado.setIcon(new ImageIcon(Principal.class.getResource("/icons/agregarSolicitante.png")));
		mntmEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablaEmpleados e1;
				e1 = new tablaEmpleados();
				e1.setLocationRelativeTo(null);
				e1.setVisible(true);
			}
		});
		mnRegistrar.add(mntmEmpleado);
		
		JMenuItem mntmProv = new JMenuItem("Proveedor");
		mntmProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				InsertProveedor miprov;
				miprov = new InsertProveedor("Insertar Proveedor", false, null);
				miprov.setModal(true);
				miprov.setLocationRelativeTo(null);
				miprov.setVisible(true);
			}
		});
		mntmProv.setIcon(new ImageIcon(Principal.class.getResource("/icons/agregarSolicitante.png")));
		mnRegistrar.add(mntmProv);
		
		JMenuItem mntmProd = new JMenuItem("Producto");
		mntmProd.setIcon(new ImageIcon(Principal.class.getResource("/icons/add.png")));
		mntmProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertProducto miProd;
				miProd = new insertProducto("Insertar producto", false, null);
				miProd.setModal(true);
				miProd.setLocationRelativeTo(null);
				miProd.setVisible(true);
			}
		});
		mnRegistrar.add(mntmProd);
		
		JMenuItem mntmServicio = new JMenuItem("Servicio");
		mntmServicio.setIcon(new ImageIcon(Principal.class.getResource("/icons/add.png")));
		mntmServicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertServicio s1;
				s1 = new insertServicio();
				s1.setLocationRelativeTo(null);
				s1.setVisible(true);
			}
		});
		mnRegistrar.add(mntmServicio);
		
		JMenu mnConsultas = new JMenu("Consultas");
		mnConsultas.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnConsultas);
		
		JMenuItem mntmListClientes = new JMenuItem("Listado Clientes");
		mntmListClientes.setIcon(new ImageIcon(Principal.class.getResource("/icons/Listas.png")));
		mntmListClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListCliente ll;
				ll = new ListCliente();
				ll.setModal(true);
				ll.setLocationRelativeTo(null);
				ll.setVisible(true);
			}
		});
		mnConsultas.add(mntmListClientes);
		
		JMenuItem mntmListProv = new JMenuItem("Listado Proveedores");
		mntmListProv.setIcon(new ImageIcon(Principal.class.getResource("/icons/Listas.png")));
		mntmListProv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ListProveedor lp;
				lp = new ListProveedor();
				lp.setModal(true);
				lp.setLocationRelativeTo(null);
				lp.setVisible(true);
			}
		});
		mnConsultas.add(mntmListProv);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Listado de Ventas");
		mntmNewMenuItem_1.setIcon(new ImageIcon(Principal.class.getResource("/icons/Listas.png")));
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListFacturas lf;
				lf = new ListFacturas();
				lf.setModal(true);
				lf.setLocationRelativeTo(null);
				lf.setVisible(true);
			}
		});
		mnConsultas.add(mntmNewMenuItem_1);
		
		JMenu mnFacturar = new JMenu("Facturar");
		mnFacturar.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnFacturar);
		
		JMenuItem mntmFactura = new JMenuItem("Registrar Factura");
		mntmFactura.setIcon(new ImageIcon(Principal.class.getResource("/icons/Money.png")));
		mntmFactura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroFactura rf;
				try {
					rf = new RegistroFactura();
					rf.setLocationRelativeTo(null);
					rf.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnFacturar.add(mntmFactura);
		
		JMenu mnNewMenu = new JMenu("Stock");
		mnNewMenu.setFont(new Font("Segoe UI", Font.BOLD, 13));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Stock");
		mntmNewMenuItem.setIcon(new ImageIcon(Principal.class.getResource("/icons/ver.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Stock st;
				st = new Stock();
				st.setModal(true);
				st.setLocationRelativeTo(null);
				st.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaptionBorder);
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 164, 1350, 2);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.inactiveCaption);
		panel_1.setBounds(0, 579, 1350, 59);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblhora = new JLabel("");
		lblhora.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblhora.setBounds(24, 11, 140, 39);
		panel_1.add(lblhora);
		
		lblyear = new JLabel("");
		lblyear.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblyear.setBounds(131, 11, 212, 39);
		panel_1.add(lblyear);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Principal.class.getResource("/icons/Bike-Rental.PNG")));
		lblNewLabel.setBounds(487, -13, 330, 194);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Principal.class.getResource("/icons/Cyclist-image2.PNG")));
		lblNewLabel_2_1.setBounds(642, 133, 555, 422);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Principal.class.getResource("/icons/Cyclist-image3.PNG")));
		lblNewLabel_2_2.setBounds(281, 160, 593, 388);
		panel.add(lblNewLabel_2_2);
		
		reloj();
	}
	
	public void reloj() {

		Thread reloj = new Thread() {
			public void run() {
				try {
					for (;;) {
						Calendar calen = new GregorianCalendar();
						int dia = calen.get(Calendar.DAY_OF_WEEK_IN_MONTH);
						int diaSemana = calen.get(Calendar.DAY_OF_WEEK);
						int mes = calen.get(Calendar.MONTH + 1);
						int minutos = calen.get(Calendar.MINUTE);
						int hora = calen.get(Calendar.HOUR);
						int sec = calen.get(Calendar.SECOND);
						int meri = calen.get(Calendar.AM_PM);
						LocalDate date = LocalDate.now();
						int anno = date.getYear();
						int mess= date.getMonthValue();
						int dias = date.getDayOfMonth();
						String realmes = "";
						String merid = "";
						if (meri == 1) {
							merid = " PM";
						} else {
							merid = " AM";
						}
						if (mess == 1) {
							realmes = "Enero";
						}
						if (mess == 2) {
							realmes = "Febreo";
						}
						if (mess == 3) {
							realmes = "Marzo";
						}
						if (mess == 4) {
							realmes = "Abril";
						}
						if (mess == 5) {
							realmes = "Mayo";
						}
						if (mess == 6) {
							realmes = "Junio";
						}
						if (mess == 7) {
							realmes = "Julio";
						}
						if (mess == 8) {
							realmes = "Agosto";
						}
						if (mess == 9) {
							realmes = "Septiembre";
						}
						if (mess == 10) {
							realmes = "Octubre";
						}
						if (mess == 11) {
							realmes = "Noviembre";
						}
						if (mess == 12) {
							realmes = "Diciembre";
						}
						lblhora.setText(hora + ":" + minutos + ":" + sec + merid);
						lblyear.setText(dias+", "+realmes+", "+anno);
						

						sleep(1000);
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		};
		reloj.start();

	}
}
