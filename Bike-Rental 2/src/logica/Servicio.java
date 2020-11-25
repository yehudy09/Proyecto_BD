package logica;

public class Servicio extends Precio {

	private String id;
	private String ssn;
	private String tipo;
	private float precio;
	public Servicio(float precioServ, float precioProd, String id, String ssn, String tipo, float precio) {
		super(precioServ, precioProd);
		this.id = id;
		this.ssn = ssn;
		this.tipo = tipo;
		this.precio = precio;
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
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
}
