package logica;

import java.sql.Date;

public class Factura {
	private int fid;
	private String comprobante;
	private Date fecha;
	private int cantVenta; 
	private String RNC;
	private int precioTotal;
	private int cid; 
	private String ssn;
	public Factura(int fid, String comprobante, Date fecha, int cantVenta, String rNC, int precioTotal, int cid,
			String ssn) {
		super();
		this.fid = fid;
		this.comprobante = comprobante;
		this.fecha = fecha;
		this.cantVenta = cantVenta;
		RNC = rNC;
		this.precioTotal = precioTotal;
		this.cid = cid;
		this.ssn = ssn;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getComprobante() {
		return comprobante;
	}
	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public int getCantVenta() {
		return cantVenta;
	}
	public void setCantVenta(int cantVenta) {
		this.cantVenta = cantVenta;
	}
	public String getRNC() {
		return RNC;
	}
	public void setRNC(String rNC) {
		RNC = rNC;
	}
	public int getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(int precioTotal) {
		this.precioTotal = precioTotal;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	} 
	
	
	
	
	

}
