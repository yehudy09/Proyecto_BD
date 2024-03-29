package logica;

public abstract class Persona {
	protected int id; 
	protected String cedula;  
	protected String Fname; 
	protected String Sname; 
	protected String Lname;
	protected String Calle; 
	protected String Ciudad; 
	protected String tel; 
	protected String postalCode;
	protected String provincia; 
	public Persona(String cedula, String fname, String sname, String lname, String calle, String ciudad,
			String tel, String postalCode, String provincia) {
		super();
		this.cedula = cedula;
		Fname = fname;
		Sname = sname;
		Lname = lname;
		Calle = calle;
		Ciudad = ciudad;
		this.tel = tel;
		this.postalCode = postalCode;
		this.provincia = provincia;
	}
	public int getId() {
		return id;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public void setId(int id) {
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
	public String getPostalCode() {
		return postalCode;
	}
	
	
	
	

}
