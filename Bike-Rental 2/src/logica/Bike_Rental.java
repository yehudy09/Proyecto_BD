package logica;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import java.sql.*;


public class Bike_Rental {
	private ArrayList<Factura> misFacturas;
	private ArrayList<DetalleFactura> misDetallesF;
	private ArrayList<Servicio> misServicios; 
	private ArrayList<Empleado> misEmpleados; 
	private ArrayList<Cliente> misClientes; 
	private ArrayList<Proveedor> misProveedores;
	private ArrayList<Producto> misProductos;
	private ArrayList<User> misUsers; 
	public static Bike_Rental bike;
	private static Connection connect = null;
	private static User loginUser;
	
	public Bike_Rental() {
		super();
		this.misFacturas = new ArrayList<>();
		this.misServicios = new ArrayList<>();
		this.misEmpleados =new ArrayList<>();
		this.misClientes = new ArrayList<>();
		this.misProveedores = new ArrayList<>();
		this.misProductos = new ArrayList<>();
		this.misUsers = new ArrayList<>();
		this.misDetallesF = new ArrayList<>();
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
	
	public static User getLoginUser() {
		return loginUser;
	}

	public static void setLoginUser(User loginUser) {
		Bike_Rental.loginUser = loginUser;
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

	public static Bike_Rental getInstance() {
		if (bike == null) {
			bike = new Bike_Rental();
		}
		return bike;
	}
	
	
	public Connection conectarSQL() throws Exception{
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String Url = "jdbc:sqlserver://EZEQUIEL-PC\\SQLEXPRESS:1433;databaseName=Bike_Center;user=luna;password=123luna;";
			//String Url = "jdbc:sqlserver://DESKTOP-Q5G1B41\\SQLEXPRESS:1433;databaseName=Bike_Center_;user=yehudy;password=123;";
			//String Url = "jdbc:sqlserver://DESKTOP-H6TG0VV\\SQLEXPRESS:1433;databaseName=Bike_Center_;user=dariannye;password=bikerental4;";
			
			connect = DriverManager.getConnection(Url);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e,  "Error de conexi�n" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		return connect;
		
	}
	
	public boolean confirmLogin (String user, String pass) throws Exception {
		boolean login = true;
		String sql = "select * from Usuario where username = '"+user+"' and pass='"+pass+"'";
		
		try {
			Statement stmt = conectarSQL().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
				if (!rs.next()) {
				return login=false;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return login;
	}
	
	 //*************************************** INSERTS ******************************************//
	
	public void insertUser(User u) throws Exception {
		misUsers.add(u);
		String sql = "insert into Usuario (Tipo, username, pass) values (?,?,?)";
		
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, u.getTipo());
			stmt.setString(2, u.getUserName());
			stmt.setString(3, u.getPass());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 
	}
	
	
	public void insertlogUser(String name) throws Exception {
	String sql = "insert into logUser (username) values (?)";
		
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, name);
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
	}
	
	public String tipologUser() throws Exception {

		String sql = "select tipo from Usuario where username in (select username from logUser)"; 
		String tipo = null; 
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
	            ResultSet rs = stmt.executeQuery(); 
	            
	            while(rs.next()) {
	            	tipo = rs.getString(1);
	            	
	            }
	            
	          
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			}
			System.out.println(tipo);
			return tipo;
		
			
		}

	public void insertCliente(Cliente c) throws Exception {
		misClientes.add(c);
		    
		String sql = "insert into Cliente (cedula, Fname, Sname, Lname, Calle, Ciudad, CodPostal, Tel, provincia) "
				+ "values (?,?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, c.getCedula());
			stmt.setString(2, c.getFname());
			stmt.setString(3, c.getSname());
			stmt.setString(4, c.getLname());
			stmt.setString(5, c.getCalle());
			stmt.setString(6, c.getCiudad());
			stmt.setString(7, c.getPostalCode());
			stmt.setString(8, c.getTel());
			stmt.setString(9, c.getProvincia());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}


	public void insertEmpleado(Empleado em) throws Exception {
		misEmpleados.add(em);
		    
		String sql = "insert into Empleado (ssn, cedula, Fname, Sname, Lname, Calle, Ciudad, codPostal, tel, posicion, salario, provincia) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, em.getSsn());
			stmt.setString(2, em.getCedula());
			stmt.setString(3, em.getFname());
			stmt.setString(4, em.getSname());
			stmt.setString(5, em.getLname());
			stmt.setString(6, em.getCalle());
			stmt.setString(7, em.getCiudad());
			stmt.setString(8, em.getPostalCode());
			stmt.setString(9, em.getTel());
			stmt.setString(10, em.getPosicion());
			stmt.setFloat(11, em.getSalario());
			stmt.setString(12, em.getProvincia());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void insertProducto(Producto pro) throws Exception {
		misProductos.add(pro);
		    
		String sql = "insert into Producto (tipo, nameProducto, precioVenta, marca, cantStock, idProveedor, fecha, precioCompra, idProducto)"
				+ " values (?,?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, pro.getTipo());
			stmt.setString(2, pro.getNameProducto());
			stmt.setFloat(3, pro.getPrecioVenta());
			stmt.setString(4, pro.getMarca());
			stmt.setInt(5, pro.getCantStock());
			stmt.setString(6,pro.getIdProveedor());
			stmt.setString(7, pro.getFecha());
			stmt.setFloat(8, pro.getPrecioCompra());
			stmt.setString(9, pro.getIdProducto());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		} 		
		
		String sql2 = "insert into PrecioComp (idProveedor, idProducto, precioCompra)"
				+ " values (?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql2);
			stmt.setString(1,pro.getIdProveedor());
			stmt.setString(2, pro.getIdProducto());
			stmt.setFloat(3, pro.getPrecioCompra());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
		} 	
	}
	
	public void insertServicio(Servicio s) throws Exception {
		misServicios.add(s);
		    
		String sql = "insert into Servicio (ssn, tipo, precio, idServicio) values (?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, s.getSsn());
			stmt.setString(2, s.getTipo());
			stmt.setFloat(3, s.getPrecioServ());
			stmt.setString(4, s.getId());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		}
		
		String sql2 = "insert into Emp_Serv (idServicio, ssn, precio) values (?,?,?)";
		
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql2);
			stmt.setString(1, s.getId());
			stmt.setString(2, s.getSsn());
			stmt.setFloat(3, s.getPrecioServ());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	public void insertProveedor(Proveedor p) throws Exception {
		misProveedores.add(p);
		    
		String sql = "insert into Proveedor (idProveedor, cedula, Fname, Sname, Lname, Calle, Ciudad, CodPostal, Tel, provincia) "
				+ "values (?,?,?,?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, p.getIdProveedor());
			stmt.setString(2, p.getCedula());
			stmt.setString(3, p.getFname());
			stmt.setString(4, p.getSname());
			stmt.setString(5, p.getLname());
			stmt.setString(6, p.getCalle());
			stmt.setString(7, p.getCiudad());
			stmt.setString(8, p.getPostalCode());
			stmt.setString(9, p.getTel());
			stmt.setString(10, p.getProvincia());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}


	public void insertFactura(Factura fact) throws Exception {
		misFacturas.add(fact);
		String sql = "insert into Factura (comprobante, fecha, cid) values (?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, fact.getComprobante());
			stmt.setString(2, fact.getFecha());
			stmt.setInt(3, fact.getCid());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	public void insertDetalleFactura(DetalleFactura df) throws Exception {
		misDetallesF.add(df);
		String sql = "insert into detalleFactura (fid, idProducto, cantidadVenta, idServicio) values (?,?,?,?)";
		
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setInt(1, df.getFid());
			stmt.setInt(2, df.getIdProducto());
			stmt.setInt(3, df.getCantidadVenta());
			stmt.setInt(4, df.getIdServicio());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	
	 //*************************************** UPDATES ******************************************//
	
	public void updateCliente(Cliente c) throws Exception {
		String sql = "update Cliente set Fname = ?, Sname = ?, Lname = ?, Calle = ?, Ciudad = ?, codPostal = ?, tel = ?, provincia =?" 
					 + " where cedula = ?";
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, c.getFname());
			stmt.setString(2, c.getSname());
			stmt.setString(3, c.getLname());
			stmt.setString(4, c.getCalle());
			stmt.setString(5, c.getCiudad());
			stmt.setString(6, c.getPostalCode());
			stmt.setString(7, c.getTel());
			stmt.setString(8, c.getProvincia());
			stmt.setString(9, c.getCedula());
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void updateEmpleado(Empleado emp) throws Exception {
		String sql = "update Empleado set ssn = ?, Fname = ?, Sname = ?, Lname = ?, Calle = ?, Ciudad = ?, codPostal = ?, tel = ?, posicion = ?, salario = ?, provincia =?"
				+ " where cedula = ?";
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, emp.getSsn());
			stmt.setString(2, emp.getFname());
			stmt.setString(3, emp.getSname());
			stmt.setString(4, emp.getLname());
			stmt.setString(5, emp.getCalle());
			stmt.setString(6, emp.getCiudad());
			stmt.setString(7, emp.getPostalCode());
			stmt.setString(8, emp.getTel());
			stmt.setString(9, emp.getPosicion());
			stmt.setFloat(10, emp.getSalario());
			stmt.setString(11, emp.getProvincia());
			stmt.setString(12, emp.getCedula());
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void updateStock(Producto prod) throws Exception {
		String sql = "update Producto set tipo = ?, nameProducto = ?, precioVenta = ?, marca =?, cantStock= ?, idProveedor = ?, fecha = ?, precioCompra = ?"
				+ " where idProducto = ?";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, prod.getTipo());
			stmt.setString(2, prod.getNameProducto());
			stmt.setFloat(3, prod.getPrecioVenta());
			stmt.setString(4, prod.getMarca());
			stmt.setInt(5, prod.getCantStock());
			stmt.setString(6, prod.getIdProveedor());
			stmt.setString(7, prod.getFecha());
			stmt.setFloat(8, prod.getPrecioCompra());
			stmt.setString(9, prod.getIdProducto());
					
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void updateProveedor(Proveedor prov) throws Exception {
		String sql = "update Proveedor set idProveedor = ?, Fname = ?, Sname = ?, Lname =?, Calle = ?, Ciudad =?, codPostal =?, tel =?, provincia =?"
				+ " where cedula = ? ";
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, prov.getIdProveedor());
			stmt.setString(2, prov.getFname());
			stmt.setString(3, prov.getSname());
			stmt.setString(4, prov.getLname());
			stmt.setString(5, prov.getCalle());
			stmt.setString(6, prov.getCiudad());
			stmt.setString(7, prov.getPostalCode());
			stmt.setString(8, prov.getTel());
			stmt.setString(9, prov.getProvincia());
			stmt.setString(10, prov.getCedula());
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	//*************************************** SELECTS ******************************************//
	
	
	public Cliente searchClienteByCed(String ced) throws SQLException, Exception {
        Cliente miCliente = null;

        try {
            String sql = "Select * From Cliente where cedula = ?";
        	PreparedStatement stmt = conectarSQL().prepareStatement(sql);

            stmt.setString(1, ced);


            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
               miCliente = new Cliente(rs.getString("cedula"),
                					  rs.getString("Fname"), 
                					  rs.getString("Sname"),
                					  rs.getString("Lname"), 
                					  rs.getString("Calle"), 
                					  rs.getString("Ciudad"),
                					  rs.getString("codPostal"),
                					  rs.getString("tel"),
                					  rs.getString("Provincia"));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return  miCliente;
    }
	
	
	public Proveedor searchProveedorByCed(String ced) throws SQLException, Exception {
        Proveedor miProv = null;

        try {
            String sql = "Select * From Proveedor where cedula = ?";
        	PreparedStatement stmt = conectarSQL().prepareStatement(sql);

            stmt.setString(1, ced);


            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
               miProv = new Proveedor(rs.getString("idProveedor"),
            		                  rs.getString("cedula"),
                					  rs.getString("Fname"), 
                					  rs.getString("Sname"),
                					  rs.getString("Lname"), 
                					  rs.getString("Calle"), 
                					  rs.getString("Ciudad"),
                					  rs.getString("codPostal"),
                					  rs.getString("tel"),
                				      rs.getString("Provincia"));
            }
            
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return  miProv;
    }
	
	public Proveedor searchProveedorByID(String id) throws SQLException, Exception {
        Proveedor miProv = null;

        try {
            String sql = "Select * From Proveedor where idProveedor = ?";
        	PreparedStatement stmt = conectarSQL().prepareStatement(sql);

            stmt.setString(1, id);


            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
               miProv = new Proveedor(rs.getString("idProveedor"),
            		                  rs.getString("cedula"),
                					  rs.getString("Fname"), 
                					  rs.getString("Sname"),
                					  rs.getString("Lname"), 
                					  rs.getString("Calle"), 
                					  rs.getString("Ciudad"),
                					  rs.getString("codPostal"),
                					  rs.getString("tel"),
                					  rs.getString("Provincia"));
            }
            
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return  miProv;
    }
	
	
	public Producto searchProductoByID(String id) throws SQLException, Exception {
        Producto miPro = null;

        try {
            String sql = "Select * From Producto where idProducto = ?";
        	PreparedStatement stmt = conectarSQL().prepareStatement(sql);

            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
               miPro = new Producto(rs.getString("Tipo"),
            		                  rs.getString("nameProducto"),
                					  rs.getFloat("precioVenta"),
                					  rs.getString("fecha"),
                					  rs.getString("marca"), 
                					  rs.getFloat("precioCompra"),
                					  rs.getInt("cantStock"), 
                					  rs.getString("idProveedor"),	  
                					  rs.getString("idProducto")
                					  );
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return  miPro;
    }
	
	public Producto searchCantStock(String id) throws SQLException, Exception {
        Producto miStock = null;

        try {
            String sql = "Select * From Producto where idProducto = ?";
        	PreparedStatement stmt = conectarSQL().prepareStatement(sql);

            stmt.setString(1, id);


            ResultSet rs = stmt.executeQuery();
            
         

          while(rs.next()){
               miStock = new Producto(rs.getString("Tipo"),
		                  rs.getString("nameProducto"),
 					  rs.getFloat("precioVenta"),
 					  rs.getString("fecha"),
 					  rs.getString("marca"), 
 					  rs.getFloat("precioCompra"),
 					  rs.getInt("cantStock"), 
 					  rs.getString("idProveedor"),	  
 					  rs.getString("idProducto")
 					  );
            }
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return  miStock;
       
    }
	
	
	//*************************************** DELETE ******************************************//
	
	public void deleteCliente(String ced) throws Exception {
		String sql = "delete Cliente where cedula = ?";
		
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, ced);
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void deleteProveedor(String ced) throws Exception {
		String sql = "delete Proveedor where cedula = ?";
		
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, ced);
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void deleteProducto(String id) throws Exception {
		String sql = "delete PrecioComp where idProducto = ? "
				+ "delete from Producto where idProducto = ? ";
		
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, id);
			stmt.setString(2, id);
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
		
		
		
	}
	
	public void deleteLogUser() throws Exception {
		String sql = "delete from logUser"; 
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();	
		}
	}
	
	//*****************************CONTROL STOCK****************************//
	
	public void incrementProducto(String id, int cantStock, int cant) throws Exception {
		
		int cantReal = 0 ; 
		cantReal = (cantStock + cant);
		
			String sql = "update Producto set cantStock = ? where idProducto = ?"; 
			
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
				stmt.setInt(1, cantReal);
				stmt.setString(2, id);
				
				stmt.execute();
				
			
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			} 	
		
	}
	
	public void decrementProducto(String id, int cantStock, int cantVenta) throws Exception {
		
		int cantReal = 0 ; 
		cantReal = (cantStock - cantVenta);
		
		if(cantReal == 0 ){
			String sql = "delete Producto where idProducto = ?"; 
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
				stmt.setString(1, id);
				stmt.execute();
				
			
			}catch(SQLException e) {
				
				e.printStackTrace();	
			}
		}else {
			String sql = "update Producto set cantStock = ? where idProducto = ?"; 
			
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
				stmt.setInt(1, cantReal);
				stmt.setString(2, id);
				
				stmt.execute();
				
			
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			} 	
		}
		
	}
	
	
	
	
	
	
	
	
	
}