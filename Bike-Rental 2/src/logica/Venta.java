package logica;

import java.sql.Date;

public class Venta {
	private String vid; 
	private int cantVenta; 
	private Date fechaSalida; 
	private float descuento;  
	private String fid;  
	private String idProducto;
	public Venta(String vid, int cantVenta, Date fechaSalida, float descuento, String fid, String idProducto) {
		super();
		this.vid = vid;
		this.cantVenta = cantVenta;
		this.fechaSalida = fechaSalida;
		this.descuento = descuento;
		this.fid = fid;
		this.idProducto = idProducto;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
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
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
		this.fid = fid;
	}
	public String getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}
	
	
	

	
	

}
