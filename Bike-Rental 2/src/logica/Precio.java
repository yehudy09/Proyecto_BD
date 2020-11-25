package logica;

public abstract class Precio {
	
	protected float precioServ;
	protected float precioProd;
	public Precio(float precioServ, float precioProd) {
		super();
		this.precioServ = precioServ;
		this.precioProd = precioProd;
	}
	
	public float totalPrice() {
		return precioProd+precioServ;
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
