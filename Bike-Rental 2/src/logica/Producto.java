package logica;



public class Producto {

	private String idProducto;
	private String tipo;
	private String nameProducto;
	private float precioUnd; 
	private String marca;
	private int cant;
	private String idProveedor;
	
	public Producto(String idProducto, String tipo, String nameProducto, float precioUnd, String marca, int cant, String idProveedor) {
		super();
		this.idProducto = idProducto;
		this.tipo = tipo;
		this.nameProducto = nameProducto;
		this.precioUnd = precioUnd;
		this.marca = marca;
		this.cant = cant;
		this.idProveedor = idProveedor;
		
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNameProducto() {
		return nameProducto;
	}
	public void setNameProducto(String nameProducto) {
		this.nameProducto = nameProducto;
	}
	public float getPrecioUnd() {
		return precioUnd;
	}
	public void setPrecioUnd(float precioUnd) {
		this.precioUnd = precioUnd;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getCant() {
		return cant;
	}
	public void setCant(int cant) {
		this.cant = cant;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}
	
	
	
	
}