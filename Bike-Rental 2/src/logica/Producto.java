package logica;

import java.util.Date;

public class Producto {
	
	private String tipo;
	private String nameProducto;
	private float precioVenta;
	private String fecha;
	private String marca;
	private float precioCompra;
	private int cantStock;
	private String idProveedor;
	private String idProducto;
	
	public Producto(String tipo, String nameProducto, float precioVenta, String fecha, String marca,
			float precioCompra, int cantStock, String idProveedor, String idProducto) {
		super();
		this.tipo = tipo;
		this.nameProducto = nameProducto;
		this.precioVenta = precioVenta;
		this.fecha = fecha;
		this.marca = marca;
		this.precioCompra = precioCompra;
		this.cantStock = cantStock;
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
	}
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public float getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}
	public int getCantStock() {
		return cantStock;
	}
	public void setCantStock(int cantStock) {
		this.cantStock = cantStock;
	}
	public String getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(String idProveedor) {
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
	public float getPrecioVenta() {
		return precioVenta;
	}
	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}
	

}
