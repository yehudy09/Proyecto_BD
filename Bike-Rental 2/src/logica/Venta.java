package logica;

import java.sql.Date;

public class Venta {
	private int vid; 
	private int cantVenta; 
	private Date fechaSalida; 
	private float descuento;  
	private Factura factura;  
	private Producto producto;
	
	public Venta(int vid, int cantVenta, Date fechaSalida, int descuento, Factura factura, Producto producto) {
		super();
		this.vid = vid; 
		this.cantVenta = cantVenta;
		this.fechaSalida = fechaSalida;
		this.descuento = descuento;
		this.factura = factura;
		this.producto = producto;
	}

	
	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}


	public int getCantVenta() {
		return cantVenta;
	}

	public void setCantVenta(int cantVenta) {
		this.cantVenta = cantVenta;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	} 
	
	
	
	

}
