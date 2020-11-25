package logica;

import java.sql.Date;
import java.util.ArrayList;

public class Factura {
	private int fid; 
	private String comprobante;
	private Date fecha; 
	private int cantVenta; 
	private String rnc;
	private float precioTotal;
	private int cid;
	private String ssn; 
	private ArrayList<Producto> misProd; 
	private ArrayList<Servicio> misServ;
	public Factura(int fid, String comprobante, Date fecha, int cantVenta, String rnc, float precioTotal, int cid,
			String ssn, ArrayList<Producto> misProd, ArrayList<Servicio> misServ) {
		super();
		this.fid = fid;
		this.comprobante = comprobante;
		this.fecha = fecha;
		this.cantVenta = cantVenta;
		this.rnc = rnc;
		this.precioTotal = precioTotal;
		this.cid = cid;
		this.ssn = ssn;
		this.misProd = misProd;
		this.misServ = misServ;
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
	public String getRnc() {
		return rnc;
	}
	public void setRnc(String rnc) {
		this.rnc = rnc;
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
	public ArrayList<Producto> getMisProd() {
		return misProd;
	}
	public void setMisProd(ArrayList<Producto> misProd) {
		this.misProd = misProd;
	}
	public ArrayList<Servicio> getMisServ() {
		return misServ;
	}
	public void setMisServ(ArrayList<Servicio> misServ) {
		this.misServ = misServ;
	}
	
	
	
}
	
	
	

