package logica;

public class Servicio extends Precio {

	private int id;
	private String ssn;
	private String tipo;

	public Servicio(float precioServ, String ssn, String tipo) {
		super(precioServ, precioProd);
		this.ssn = ssn;
		this.tipo = tipo;
	
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
