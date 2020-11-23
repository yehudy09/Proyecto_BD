package logica;

public class Servicio {

	private int id;
	private String ssn;
	private String tipo;
	private float precio;
	public Servicio(int id, String ssn, String tipo, float precio) {
		super();
		this.id = id;
		this.ssn = ssn;
		this.tipo = tipo;
		this.precio = precio;
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
