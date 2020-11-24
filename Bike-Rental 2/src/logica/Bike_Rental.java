package logica;

import java.util.ArrayList;
//.

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
	
	public static Bike_Rental getInstance() {
		if (bike == null) {
			bike = new Bike_Rental();
		}
		return bike;
	}
	
	
	
}
