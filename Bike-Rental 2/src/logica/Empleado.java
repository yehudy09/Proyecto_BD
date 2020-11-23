package logica;

public class Empleado extends Persona {
	
	private String ssn;
	private String posicion;
	private float salario; 

	public Empleado(int id, String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, int postalCode) {
		super(id, cedula, fname, sname, lname, calle, ciudad, tel, postalCode);
		// TODO Auto-generated constructor stub
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

}
