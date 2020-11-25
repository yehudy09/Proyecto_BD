package logica;

public class Producto extends Precio{

	private String idProducto;
	private String tipo;
	private String nameProducto;
	private String marca;
	
	public Producto(String idProducto, float precioProd,  String tipo, String nameProducto, String marca) {
		super(precioServ, precioProd); 
		this.idProducto = idProducto;
		this.tipo = tipo;
		this.nameProducto = nameProducto;
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

	

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}
	
	
}
