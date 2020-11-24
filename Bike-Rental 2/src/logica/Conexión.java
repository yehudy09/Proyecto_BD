package logica;

import java.sql.*;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexión {

	public void Conectar (String account, String password) {
		
		Connection aux = null;
		
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
			String Url = "jdbc:sqlserver://EZEQUIEL-PC\\SQLEXPRESS:1433;databaseName=Airline;"+"user="+account+"password="+password;
			
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
		
		
	}
	
	
	
	
}
