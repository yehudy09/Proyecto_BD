package logica;

public class DetalleFactura {
	
	private int fid;
	private float precioVenta;
	private int idProducto;
	private int cantidadVenta;
	private float precioServicio;
	private int idServicio;

	
	public DetalleFactura(int fid, float precioVenta, int idProducto, int cantidadVenta, float precioServicio,
			int idServicio) {
		super();
		this.fid = fid;
		this.precioVenta = precioVenta;
		this.idProducto = idProducto;
		this.cantidadVenta = cantidadVenta;
		this.precioServicio = precioServicio;
		this.idServicio = idServicio;
	}


	public int getFid() {
		return fid;
	}


	public void setFid(int fid) {
		this.fid = fid;
	}


	public float getPrecioVenta() {
		return precioVenta;
	}


	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
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


	public float getPrecioServicio() {
		return precioServicio;
	}


	public void setPrecioServicio(float precioServicio) {
		this.precioServicio = precioServicio;
	}


	public int getIdServicio() {
		return idServicio;
	}


	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	
	
	
	
	
}
