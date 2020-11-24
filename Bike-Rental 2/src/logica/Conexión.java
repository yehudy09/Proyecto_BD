package logica;


import java.sql.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexión {
	/*
	public static void main(String[] args) {
		Conectar();
	}
		*/
	public static Connection  Conectar() { 
	Connection aux = null;
	
	try {
		
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
		String Url = "jdbc:sqlserver://DESKTOP-Q5G1B41\\SQLEXPRESS:1433;databaseName=Bike_Center;user=yehudy;password=123;";
		
		aux = DriverManager.getConnection(Url);
		JOptionPane.showMessageDialog(null, "Conectado");
		/*
		 * // Select Statement ejecutor = aux.createStatement(); ResultSet respuesta =
		 * ejecutor.executeQuery("select * from Aircraft");
		 * 
		 * String txt = "";
		 * 
		 * while (respuesta.next()) { txt = txt + respuesta.getString("aname") + "" +
		 * respuesta.getString("cruisingrange") + "\n"; }
		 * JOptionPane.showMessageDialog(null, txt);
		 */
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, e,  "Error de conexión" + e.getMessage(), JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	} 
	return aux;
  }
}
