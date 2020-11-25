package logica;

public class Proveedor extends Persona {
	
	private String marca;

	public Proveedor(String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, int postalCode, String marca) {
		super(cedula, fname, sname, lname, calle, ciudad, tel, postalCode);
		// TODO Auto-generated constructor stub
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

}
