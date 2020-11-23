package logica;

import java.util.Date;

public class Stock {
	
	private int idStock;
	private Date fecha;
	private String marca;
	private float precioCompra;
	private int cantStock;
	private int idProveedor;
	private int idProducto;
	public Stock(int idStock, Date fecha, String marca, float precioCompra, int cantStock, int idProveedor,
			int idProducto) {
		super();
		this.idStock = idStock;
		this.fecha = fecha;
		this.marca = marca;
		this.precioCompra = precioCompra;
		this.cantStock = cantStock;
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
	}
	public int getIdStock() {
		return idStock;
	}
	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
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
	public int getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}
	public int getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	
}
