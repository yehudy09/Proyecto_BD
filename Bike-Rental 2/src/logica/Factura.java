package logica;


import java.util.Date; 
import java.util.ArrayList;

public class Factura {
	private int fid; 
	private String comprobante;
	private String fecha; 
	private int cid;

	public Factura(String comprobante, String fecha, int cid) {
		super();
		this.fid = fid;
		this.comprobante = comprobante;
		this.fecha = fecha;
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
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
	
}
	
	
	

