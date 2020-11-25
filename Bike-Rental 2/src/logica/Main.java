package logica;



public class Main {

	public static void main(String[] args) throws Exception {		
		/*
		 * Bike_Rental aux = new Bike_Rental();
		 * aux.getInstance().insertCliente(aux.crearCliente("2", "yehudy", "pere",
		 * "pere", "pere", "pere", "pere", 5));
		 */
		
		Cliente c1 = new Cliente("402-1404671-2", "Juan", "M", "Pere", "Independe", "Moca", "8095786864", 0);
		Bike_Rental bike = new Bike_Rental();
		bike.insertCliente(c1);
		
		Empleado e1 = new Empleado("2", "3", "gomez mmg", "hola", "alicia loca", "macori",
				"809singapiso", 9, "3", "queti", 7);
		bike.insertEmpleado(e1);
	}

}
