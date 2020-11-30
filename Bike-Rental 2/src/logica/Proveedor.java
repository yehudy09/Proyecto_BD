package logica;

public class Proveedor extends Persona {
	
	private String marca;
	private String idProveedor;

	public Proveedor(String idProveedor, String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, String postalCode, String marca, String provincia) {
		super(cedula, fname, sname, lname, calle, ciudad, tel, postalCode, provincia);
		// TODO Auto-generated constructor stub
		
		this.marca = marca;
		this.idProveedor = idProveedor;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

}
