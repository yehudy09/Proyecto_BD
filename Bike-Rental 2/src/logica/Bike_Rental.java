package logica;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Date;


public class Bike_Rental {
	private ArrayList<Venta> misVentas; 
	private ArrayList<Factura> misFacturas;
	private ArrayList<Servicio> misServicios; 
	private ArrayList<Stock> miStock; 
	private ArrayList<Empleado> misEmpleados; 
	private ArrayList<Cliente> misClientes; 
	private ArrayList<Proveedor> misProveedores;
	private ArrayList<Producto> misProductos;
	private ArrayList<User> misUsers; 
	public static Bike_Rental bike;
	private Connection connect = null;
	
	public Bike_Rental() {
		super();
		this.misVentas = new ArrayList<>();
		this.misFacturas = new ArrayList<>();
		this.misServicios = new ArrayList<>();
		this.miStock = new ArrayList<>();
		this.misEmpleados =new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misProveedores = new ArrayList<>();
		this.misProductos = new ArrayList<>();
		this.misUsers = new ArrayList<>();
	}

	
	public ArrayList<Venta> getMisVentas() {
		return misVentas;
	}

	public void setMisVentas(ArrayList<Venta> misVentas) {
		this.misVentas = misVentas;
	}

	public ArrayList<Factura> getMisFacturas() {
		return misFacturas;
	}

	public void setMisFacturas(ArrayList<Factura> misFacturas) {
		this.misFacturas = misFacturas;
	}

	public ArrayList<Servicio> getMisServicios() {
		return misServicios;
	}

	public void setMisServicios(ArrayList<Servicio> misServicios) {
		this.misServicios = misServicios;
	}

	public ArrayList<Stock> getMiStock() {
		return miStock;
	}

	public void setMiStock(ArrayList<Stock> miStock) {
		this.miStock = miStock;
	}

	public ArrayList<Empleado> getMisEmpleados() {
		return misEmpleados;
	}

	public void setMisEmpleados(ArrayList<Empleado> misEmpleados) {
		this.misEmpleados = misEmpleados;
	}

	public ArrayList<Cliente> getMisClientes() {
		return misClientes;
	}

	public void setMisClientes(ArrayList<Cliente> misClientes) {
		this.misClientes = misClientes;
	}

	public ArrayList<Proveedor> getMisProveedores() {
		return misProveedores;
	}

	public void setMisProveedores(ArrayList<Proveedor> misProveedores) {
		this.misProveedores = misProveedores;
	}

	public ArrayList<Producto> getMisProductos() {
		return misProductos;
	}

	public void setMisProductos(ArrayList<Producto> misProductos) {
		this.misProductos = misProductos;
	}

	public ArrayList<User> getMisUsers() {
		return misUsers;
	}

	public void setMisUsers(ArrayList<User> misUsers) {
		this.misUsers = misUsers;
	}

	public static Bike_Rental getBike() {
		return bike;
	}

	public static void setBike(Bike_Rental bike) {
		Bike_Rental.bike = bike;
	} 
	
	public Bike_Rental getInstance() {
		if (bike == null) {
			bike = new Bike_Rental();
		}
		return bike;
	}
	
	public Connection conectarSQL() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String Url = "jdbc:sqlserver://EZEQUIEL-PC\\SQLEXPRESS:1433;databaseName=Bike_Center;user=luna;password=123luna;";
			//String Url = "jdbc:sqlserver://DESKTOP-Q5G1B41\\SQLEXPRESS:1433;databaseName=Bike_Center;user=yehudy;password=123;";
			
			connect = DriverManager.getConnection(Url);
			
			JOptionPane.showMessageDialog(null, "Conectado");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e,  "Error de conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		return connect;
		
	}
	
	/*public void insertFactura (String comprobante, Date fecha, int cantVenta, String rnc, float precioTotal,
			int clientID, String ssn) {
		
		try {
			Conexión Connect = new Conexión();
			Connect.Conectar();
			Connection aux = null;
			String sqlInsert = "insert into Factura (comprobante, fecha, cantVenta, RNC, precioTotal, cid, ssn) values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = aux.prepareStatement(sqlInsert);
			String stringFecha = fecha.toString();
			stmt.setString(1, comprobante);
			stmt.setString(2, stringFecha);
			stmt.setInt(3, cantVenta);
			stmt.setString(4, rnc);
			stmt.setFloat(5, precioTotal);
			stmt.setInt(6, clientID);
			stmt.setString(7, ssn);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

	}*/
	
	
	public void insertCliente(Cliente c) throws Exception {
		String id = getIdCliente();
		c.setId(id);
		misClientes.add(c);
		    
		String sql = "insert into Cliente (cid, cedula, Fname, Sname, Lname, Calle, Ciudad, CodPostal, Tel) values (?,?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, c.getId());
			stmt.setString(2, c.getCedula());
			stmt.setString(3, c.getFname());
			stmt.setString(4, c.getSname());
			stmt.setString(5, c.getLname());
			stmt.setString(6, c.getCalle());
			stmt.setString(7, c.getCiudad());
			stmt.setInt(8, c.getPostalCode());
			stmt.setString(9, c.getTel());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	public String getIdCliente() { // Generacion de Codigos para cliente
		String code = "";
		String codigo = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		for (int i = 0; i < 3;) {
			char c = (char) r.nextInt(225);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				code += c;
				i++;
			}

		}
		codigo = "CL" + code;
		return codigo;
	}
}
