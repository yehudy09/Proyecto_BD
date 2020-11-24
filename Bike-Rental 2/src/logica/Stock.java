package logica;

import java.util.Date;

public class Stock {
	
	private String idStock;
	private Date fecha;
	private String marca;
	private float precioCompra;
	private int cantStock;
	private String idProveedor;
	private String idProducto;
	public Stock(String idStock, Date fecha, String marca, float precioCompra, int cantStock, String idProveedor,
			String idProducto) {
		super();
		this.idStock = idStock;
		this.fecha = fecha;
		this.marca = marca;
		this.precioCompra = precioCompra;
		this.cantStock = cantStock;
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
	}
	public String getIdStock() {
		return idStock;
	}
	public void setIdStock(String idStock) {
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
	
}
