package logica;

import java.sql.Date;

public class Factura {
	private String fid;
	private String comprobante;
	private Date fecha;
	private int cantVenta; 
	private String RNC;
	private float precioTotal;
	private int cid; 
	private String ssn;
	public Factura(String fid, String comprobante, Date fecha, int cantVenta, String rNC, float precioTotal, int cid,
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
	public String getFid() {
		return fid;
	}
	public void setFid(String fid) {
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
	public float getPrecioTotal() {
		return precioTotal;
	}
	public void setPrecioTotal(float precioTotal) {
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
