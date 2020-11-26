package logica;

import java.sql.Date;
import java.util.ArrayList;

public class Factura {
	private int fid; 
	private String comprobante;
	private Date fecha; 
	private String rnc;
	private int cid;

	public Factura(int fid, String comprobante, Date fecha, int cantVenta, String rnc, float precioTotal, int cid,
			String ssn, ArrayList<Producto> misProd, ArrayList<Servicio> misServ) {
		super();
		this.fid = fid;
		this.comprobante = comprobante;
		this.fecha = fecha;
		this.rnc = rnc;
		this.cid = cid;
	
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
	
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
	
}
	
	
	

