package logica;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;


import java.sql.*;


public class Bike_Rental {
	private ArrayList<Factura> misFacturas;
	private ArrayList<DetalleFactura> misDetallesF;
	private ArrayList<Servicio> misServicios; 
	private ArrayList<Stock> miStock; 
	private ArrayList<Empleado> misEmpleados; 
	private ArrayList<Cliente> misClientes; 
	private ArrayList<Proveedor> misProveedores;
	private ArrayList<Producto> misProductos;
	private ArrayList<User> misUsers; 
	public static Bike_Rental bike;
	private static Connection connect = null;
	
	public Bike_Rental() {
		super();
		this.misFacturas = new ArrayList<>();
		this.misServicios = new ArrayList<>();
		this.miStock = new ArrayList<>();
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

	public static Bike_Rental getInstance() {
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
			
			//String Url = "jdbc:sqlserver://EZEQUIEL-PC\\SQLEXPRESS:1433;databaseName=Bike_Center;user=luna;password=123luna;";
			//String Url = "jdbc:sqlserver://DESKTOP-Q5G1B41\\SQLEXPRESS:1433;databaseName=Bike_Center;user=yehudy;password=123;";
			String Url = "jdbc:sqlserver://DESKTOP-H6TG0VV\\SQLEXPRESS:1433;databaseName=Bike_Center;user=dariannye;password=bikerental4;";
			
			
			connect = DriverManager.getConnection(Url);
			
		//	JOptionPane.showMessageDialog(null, "Conectado");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e,  "Error de conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
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
					/*JOptionPane.showMessageDialog(null,
							"Usuario o contraseña incorrectos, inténtelo nuevamente.", "Error",
							JOptionPane.ERROR_MESSAGE, null);*/
				return login=false;
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}
		/*JOptionPane.showMessageDialog(null,
				"Bienvenido a Bike-Rental", "Información",
				JOptionPane.INFORMATION_MESSAGE, null);*/
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
		    
		String sql = "insert into Producto (idProducto, tipo, nameProducto, precioVenta, marca, cantidad,idProveedor) values (?,?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, pro.getIdProducto());
			stmt.setString(2, pro.getTipo());
			stmt.setString(3, pro.getNameProducto());
			stmt.setFloat(4, pro.getPrecioUnd());
			stmt.setString(5, pro.getMarca());
			stmt.setInt(6, pro.getCant());
			stmt.setString(7,pro.getIdProveedor());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void insertServicio(Servicio s) throws Exception {
		misServicios.add(s);
		    
		String sql = "insert into Servicio (ssn, tipo, precio) values (?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, s.getSsn());
			stmt.setString(2, s.getTipo());
			stmt.setFloat(3, s.getPrecioServ());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	public void insertProveedor(Proveedor p) throws Exception {
		misProveedores.add(p);
		    
		String sql = "insert into Proveedor (idProveedor, cedula, Fname, Sname, Lname, Calle, Ciudad, CodPostal, Tel, marca, provincia) "
				+ "values (?,?,?,?,?,?,?,?,?,?,?)";
			
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
			stmt.setString(10, p.getMarca());
			stmt.setString(11, p.getProvincia());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void insertStock(Stock st) throws Exception {
		miStock.add(st);
		Date fecha = new Date(st.getFecha().getTime());
		String sql = "insert into Stock (fecha, marca, precioCompra, cantStock, idProveedor, idProducto) values (?,?,?,?,?,?)";
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setDate(1, fecha);
			stmt.setString(2, st.getMarca());
			stmt.setFloat(3, st.getPrecioCompra());
			stmt.setInt(4, st.getCantStock());
			stmt.setString(5, st.getIdProveedor());
			stmt.setString(6, st.getIdProducto());
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void insertFactura(Factura fact) throws Exception {
		misFacturas.add(fact);
		Date fecha = new Date(fact.getFecha().getTime());
		String sql = "insert into Factura (comprobante, fecha, RNC, cid) values (?,?,?,?)";
			
		
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, fact.getComprobante());
			stmt.setDate(2, fecha);
			stmt.setString(3, fact.getRnc());
			stmt.setInt(4, fact.getCid());
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
	
	public void updateProducto(Producto prod) throws Exception {
		String sql = "update Producto set tipo = ?, precioVenta = ?, marca =? "
				+ " where nameProducto = ?";
		
			
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.setString(1, prod.getTipo());
			stmt.setFloat(2, prod.getPrecioUnd());
			stmt.setString(3, prod.getMarca());
			stmt.setString(4, prod.getNameProducto());
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	public void updateProveedor(Proveedor prov) throws Exception {
		String sql = "update Proveedor set idProveedor = ?, Fname = ?, Sname = ?, Lname =?, Calle = ?, Ciudad =?, codPostal =?, tel =?, marca = ?, provincia =?"
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
			stmt.setString(9, prov.getMarca());
			stmt.setString(10, prov.getProvincia());
			stmt.setString(11, prov.getCedula());
			stmt.execute();
			
		
		}catch(SQLException e) {
			
			e.printStackTrace();
			
		} 		
	}
	
	
	
	
	
	//*************************************** SELECTS ******************************************//
	
	public void select(int id) throws SQLException, Exception {
		String sql = "select precioVenta from Producto where idProducto = ?";
		
		PreparedStatement stmt = conectarSQL().prepareStatement(sql);
		try {
			stmt.setInt(1, id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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
                System.out.println("IDCliente->"+rs.getString("cid"));
                System.out.println("Cliente Encontrado = " + rs.getString("Fname")  + " "+"and"+" "+"Cedula = " + " "+ rs.getString("cedula"));
               
            }

            if (miCliente != null) {
                System.out.println("Cliente Encontrado");

            }else{
            	 System.out.println("Cliente no Encontrado");
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
                					  rs.getString("marca"),
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
                					  rs.getString("marca"),
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
               miPro = new Producto(rs.getString("idProducto"),
            		                  rs.getString("tipo"),
                					  rs.getString("nameProducto"), 
                					  rs.getFloat("precioVenta"),
                					  rs.getString("marca"), 
                					  rs.getInt("cantidad"), 
                					  rs.getString("idProveedor"));
            }
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        return  miPro;
    }
	
	public void searchCantStock(String id) throws SQLException, Exception {
        Stock miStock = null;

        try {
            String sql = "Select cantStock From Stock where idProducto = ?";
        	PreparedStatement stmt = conectarSQL().prepareStatement(sql);

            stmt.setString(1, id);


            ResultSet rs = stmt.executeQuery();

          /*  while(rs.next()){
               miStock = new Stock(rs.getDate("fecha"),
            		                  rs.getString("marca"),
                					  rs.getFloat("precioCompra"), 
                					  rs.getInt("cantStock"),
                					  rs.getString("idProveedor"), 
                					  rs.getString("idProveedor"));
            }*/
            
        } catch (SQLException e) {
        	e.printStackTrace();
        } 
        //return  miStock;
       
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
	
	/*public void deleteLogUser() throws Exception {
		String sql = "delete from logUser"; 
		try {
			PreparedStatement stmt = conectarSQL().prepareStatement(sql);
			stmt.execute();
		
		}catch(SQLException e) {
			
			e.printStackTrace();	
		}
	}*/
	
	//*****************************CONTROL STOCK****************************//
	
	public void incrementProducto(String id, int cantStock, int cant) throws Exception {
		
		int cantReal = 0 ; 
		cantReal = (cantStock + cant);
		
			String sql = "update Producto set cantStock = ? where idProducto = ?"; 
			
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
				stmt.setString(1, id);
				stmt.setInt(2, cantReal);
				
				stmt.execute();
				
			
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			} 	
		
	}
	
	public void decrementProducto(int id, int cantStock, int cant) throws Exception {
		
		int cantReal = 0 ; 
		cantReal = (cantStock - cant);
		
		if(cantReal == 0 ){
			String sql = "delete Producto where idProducto = ?"; 
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.execute();
				
			
			}catch(SQLException e) {
				
				e.printStackTrace();	
			}
		}else {
			String sql = "update Producto set cantStock = ? where idProducto = ?"; 
			
			try {
				PreparedStatement stmt = conectarSQL().prepareStatement(sql);
				stmt.setInt(1, id);
				stmt.setInt(2, cantReal);
				
				stmt.execute();
				
			
			}catch(SQLException e) {
				
				e.printStackTrace();
				
			} 	
		}
		
	}
	
	
	
	
	
	
	
	
	
}
