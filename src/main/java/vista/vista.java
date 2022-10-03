package vista;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Andrea
 *
 */
public class vista {

	public vista() {

	}

	public void star() {

		System.out.println("1. Inicializar DB");
		System.out.println("2. Insertar datos");
		System.out.println("3. Borrar tabla");
		System.out.println("4. CRUDE por tabla");
		System.out.println("5. Cerrar Programa");

	}

	public void tables() {

		System.out.println("1. Piezas");
		System.out.println("2. Proveedores");
		System.out.println("3. Suministran");

	}

	public void askRegister() {
		System.out.println("Que registro quieres borrar?");
	}

	public void crudTable() {

		System.out.println("1. Añadir register");
		System.out.println("2. Consultar por ID o nombre");
		System.out.println("3. Listar registros");
		System.out.println("4. Modificar registro");
		System.out.println("5. Borrar registro");

	}

	public void correctQuery(String Query) {
		System.out.println(Query + "- ok!");
	}

	public void numeroIncorrecto() {
		System.out.println("Valor de entrada incorrecto");
	}

	public void cerrar() {
		System.out.println("Programa cerrrado");
	}

	// Select
	public void nombreOId() {
		System.out.println("Consultar: ");
		System.out.println("1. Nombre");
		System.out.println("2. ID");
	}
	
	public void nombreIdPrecio() {
		System.out.println("Consultar: ");
		System.out.println("1. Codigo");
		System.out.println("2. ID");
		System.out.println("3. Precio");
	}

	public void insertID() {
		System.out.print("ID:");
	}

	public void insertNombre() {
		System.out.print("Nombre:");
	}
	
	public void insertPrecio() {
		System.out.print("Precio:");
	}
	
	public void insertCodigo() {
		System.out.print("Codigo:");
	}

	public void resultSelectPieza(ResultSet rs) throws SQLException {

		while (rs.next()) {
			System.out.println("La pieza con id " + rs.getInt(1) + " tiene el nombre " + rs.getString(2));
		}

	}
	
	public void resultSelectProveedor(ResultSet rs) throws SQLException {

		while (rs.next()) {
			System.out.println("El proveedor con id " + rs.getString(1) + " tiene el nombre " + rs.getString(2));
		}

	}
	
	public void resultSelectSuministra(ResultSet rs) throws SQLException {

		while (rs.next()) {
			System.out.println("Suministra con codigo " + rs.getInt(1) +" y el proveedor "+ rs.getString(2)+ " tiene el precio " + rs.getInt(3));
		}

	}

}
