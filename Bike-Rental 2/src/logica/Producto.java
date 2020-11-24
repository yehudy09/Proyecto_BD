package logica;

public class Producto {

	private String idProducto;
	private String tipo;
	private String nameProducto;
	private int precioVenta;
	private String marca;
	
	public Producto(String idProducto, String tipo, String nameProducto, int precioVenta, String marca) {
		super();
		this.idProducto = idProducto;
		this.tipo = tipo;
		this.nameProducto = nameProducto;
		this.precioVenta = precioVenta;
		this.marca = marca;
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

	public int getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(int precioVenta) {
		this.precioVenta = precioVenta;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
