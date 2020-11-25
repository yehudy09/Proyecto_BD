package logica;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;


import java.sql.*;


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
	private ArrayList<Precio> misPrecios;
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
		this.misPrecios = new ArrayList<>(); 
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
	
	public float totalPrice(ArrayList<Precio> aux) {
		float total = 0; 
				for (Precio p : aux) {
					total += p.totalPrice();
				}
			return total; 
	}
	
	
	public Connection conectarSQL() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String Url = "jdbc:sqlserver://EZEQUIEL-PC\\SQLEXPRESS:1433;databaseName=Bike_Center;user=luna;password=123luna;";
			//String Url = "jdbc:sqlserver://DESKTOP-Q5G1B41\\SQLEXPRESS:1433;databaseName=Bike_Center;user=yehudy;password=123;";
			//String Url = "jdbc:sqlserver:DESKTOP-H6TG0VV\\SQLEXPRESS:1433;databaseName=Bike_Center;user=dariannye;password=;";
			
			
			connect = DriverManager.getConnection(Url);
			
			JOptionPane.showMessageDialog(null, "Conectado");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e,  "Error de conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		return connect;
		
	}
	
	
	//////////////////////////// INSERTAR CLIENTE //////////////////////////
	
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
	

	//////////////////////////// INSERTAR EMPLEADO //////////////////////////

	public void insertEmpleado(Empleado em) throws Exception {
		String id = getIdEmpleado();
		em.setId(id);
		misEmpleados.add(em);
		    
		String sql = "insert into Empleado (eid, ssn, cedula, Fname, Sname, Lname, Calle, Ciudad, codPostal, tel, posicion, salario) values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, em.getId());
			stmt.setString(2, em.getSsn());
			stmt.setString(3, em.getCedula());
			stmt.setString(4, em.getFname());
			stmt.setString(5, em.getSname());
			stmt.setString(6, em.getLname());
			stmt.setString(7, em.getCalle());
			stmt.setString(8, em.getCiudad());
			stmt.setInt(9, em.getPostalCode());
			stmt.setString(10, em.getTel());
			stmt.setString(11, em.getPosicion());
			stmt.setFloat(12, em.getSalario());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	

	public String getIdEmpleado() { // Generacion de Codigos para Empleado
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
		codigo = "EM" + code;
		return codigo;
	}
	
	
	//////////////////INSERTAR PRODUCTO /////////////////////
	
	public void insertProducto(Producto pro) throws Exception {
		String id = getIdProducto();
		pro.setIdProducto(id);
		misProductos.add(pro);
		    
		String sql = "insert into Producto (idProducto, tipo, nameProducto, precioVenta, marca) values (?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, pro.getIdProducto());
			stmt.setString(2, pro.getTipo());
			stmt.setString(3, pro.getNameProducto());
			stmt.setFloat(4, pro.getPrecioProd());
			stmt.setString(5, pro.getMarca());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public String getIdProducto() { // Generacion de Codigos para Producto
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
		codigo = "PD" + code;
		return codigo;
	}
	
	
	public void insertServicio(Servicio s) throws Exception {
		String id = getIdServicio();
		s.setId(id);
		misServicios.add(s);
		    
		String sql = "insert into Servicio (idServicio, ssn, tipo, precio) values (?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, s.getId());
			stmt.setString(2, s.getSsn());
			stmt.setString(3, s.getTipo());
			stmt.setFloat(4, s.getPrecioServ());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public String getIdServicio() { // Generacion de Codigos para servicio
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
		codigo = "SE" + code;
		return codigo;
	}
	
	
	
}
