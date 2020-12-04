package logica;

public class Proveedor extends Persona {
	
	
	private String idProveedor;

	public Proveedor(String idProveedor, String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, String postalCode, String provincia) {
		super(cedula, fname, sname, lname, calle, ciudad, tel, postalCode, provincia);
		// TODO Auto-generated constructor stub
		
		
		this.idProveedor = idProveedor;
	}

	

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

}
