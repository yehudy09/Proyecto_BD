package logica;

public abstract class Persona {
	protected String id; 
	protected String cedula;  
	protected String Fname; 
	protected String Sname; 
	protected String Lname;
	protected String Calle; 
	protected String Ciudad; 
	protected String tel; 
	protected int postalCode;
	public Persona(String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, int postalCode) {
		super();
		this.cedula = cedula;
		Fname = fname;
		Sname = sname;
		Lname = lname;
		Calle = calle;
		Ciudad = ciudad;
		this.tel = tel;
		this.postalCode = postalCode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String fname) {
		Fname = fname;
	}
	public String getSname() {
		return Sname;
	}
	public void setSname(String sname) {
		Sname = sname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String lname) {
		Lname = lname;
	}
	public String getCalle() {
		return Calle;
	}
	public void setCalle(String calle) {
		Calle = calle;
	}
	public String getCiudad() {
		return Ciudad;
	}
	public void setCiudad(String ciudad) {
		Ciudad = ciudad;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public int getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	} 
	
	
	

}
