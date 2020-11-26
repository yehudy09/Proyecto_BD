package logica;

public abstract class Precio {
	
	protected static float precioServ;
	protected static float precioProd;
	protected Factura cant; 
	public Precio(float precioServ, float precioProd) {
		super();
		this.precioServ = precioServ;
		this.precioProd = precioProd;
	}
	
	public float totalPrice() {
		return ((cant.getCantVenta()*precioProd)+precioServ);
	}
	
	public float getPrecioServ() {
		return precioServ;
	}
	public void setPrecioServ(float precioServ) {
		this.precioServ = precioServ;
	}
	public float getPrecioProd() {
		return precioProd;
	}
	public void setPrecioProd(float precioProd) {
		this.precioProd = precioProd;
	}
	
	

}
