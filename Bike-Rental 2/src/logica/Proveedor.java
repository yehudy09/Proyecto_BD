package logica;

public class Proveedor extends Persona {
	
	private String marca;

	public Proveedor(String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, String postalCode, String marca, String provincia) {
		super(cedula, fname, sname, lname, calle, ciudad, tel, postalCode, provincia);
		// TODO Auto-generated constructor stub
		
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
