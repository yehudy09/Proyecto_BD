package logica;

public class DetalleFactura {
	
	private int fid;
	private Producto prod;
	private int idProducto;
	private int cantidadVenta;
	private Servicio serv;
	private int idServicio;
	float precio = 0; 
	
	public DetalleFactura(int fid, int idProducto, int cantidadVenta, int idServicio) {
		super();
		this.fid = fid;
		this.idProducto = idProducto;
		this.cantidadVenta = cantidadVenta;
		this.idServicio = idServicio;
	}
	
	public float getPrecioServ() {
		
		precio = serv.getPrecioServ(); 
		
		return precio;
		
	}
	
	public float getPrecioProd() {
		
		precio = prod.getPrecioProd(); 
		
		return precio;
		
	}

	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public int getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}


	public int getCantidadVenta() {
		return cantidadVenta;
	}


	public void setCantidadVenta(int cantidadVenta) {
		this.cantidadVenta = cantidadVenta;
	}


	public int getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	
	
	
	
	
}
