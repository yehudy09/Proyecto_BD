package logica;

public class Servicio {

	private String id;
	private String ssn;
	private String tipo;
	private float precioServ;
	public Servicio(String ssn, String tipo, float precioServ, String id) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.tipo = tipo;
		this.precioServ = precioServ;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public float getPrecioServ() {
		return precioServ;
	}
	public void setPrecioServ(float precioServ) {
		this.precioServ = precioServ;
	} 

	
	
}
