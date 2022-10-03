package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import modelo.modelo;
import vista.vista;

/**
 * @author Andrea
 *
 */

public class controlador {

	vista vista = new vista();
	modelo model = new modelo();

	/**
	 * @throws SQLException
	 */
	public void start() throws SQLException {

		vista.star();
		menu();

	}
	
	

	/**
	 * Menu inicial 
	 * @throws SQLException
	 */
	public void menu() throws SQLException {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();

		while (i != 5) {

			switch (i) {

			case 1:

				if (model.createDBQuery()) {
					vista.correctQuery("Crear DB");
				}
				break;

			case 2:

				if (model.insertValues()) {
					vista.correctQuery("Insertar datos");
				}

				break;
			case 3:
				vista.tables();

				if (model.deleteTable(sc.nextInt())) {
					vista.correctQuery("Tabla borrada");
				}

				break;
			case 4:
				vista.tables();
				crud(sc.nextInt());
				break;

			case 5:
				vista.cerrar();
				break;

			default:
				vista.numeroIncorrecto();
				break;
			}
			vista.star();
			i = sc.nextInt();

		}

	}

	/**
	 * Menu para elegir que tabla que quieres hacer modificaciones
	 * @param i
	 * @throws SQLException
	 */
	public void crud(int i) throws SQLException {

		Scanner sc = new Scanner(System.in);
		int t = 0;

		switch (i) {
		case 1:
			vista.crudTable();
			t = sc.nextInt();
			crudPiezas(t);
			break;
		case 2:
			vista.crudTable();
			t = sc.nextInt();
			crudProveedor(t);
			break;

		case 3:
			vista.crudTable();
			t = sc.nextInt();
			crudSuministra(t);
			break;

		}

	}

	/**
	 * CRUD tabla piezas
	 * @param i
	 * @throws SQLException
	 */
	public void crudPiezas(int i) throws SQLException {

		Scanner sc = new Scanner(System.in);

		switch (i) {
		case 1:
			vista.insertCodigo();
			int idInsert = sc.nextInt();

			vista.insertNombre();
			String nombreInsert = sc.next();

			if (model.insertPiezas(idInsert, nombreInsert)) {
				vista.correctQuery("Pieza insertada");
			}
			break;
		case 2:
			vista.nombreOId();
			i = sc.nextInt();

			switch (i) {
			case 1:
				vista.insertNombre();
				String nombreSelect = sc.next();
				vista.resultSelectPieza(model.selectPiezas(0, nombreSelect));
				break;
			case 2:
				vista.insertCodigo();
				int idSelect = sc.nextInt();
				vista.resultSelectPieza(model.selectPiezas(idSelect, ""));
				break;

			}

			break;

		case 3:
			vista.resultSelectPieza(model.listarPiezas());
			break;

		case 4:
			vista.insertCodigo();
			int idUpdate = sc.nextInt();

			vista.insertNombre();
			String nombreUpdate = sc.next();

			if (model.updatePiezas(idUpdate, nombreUpdate)) {
				vista.correctQuery("Pieza actualizada");
			}
			break;

		case 5:
			vista.insertCodigo();
			int idDelete = sc.nextInt();

			if (model.deletePiezas(idDelete)) {
				vista.correctQuery("Pieza eliminada");
			}
			break;

		}
	}

	/**
	 * CRUD Proveedor
	 * @param i
	 * @throws SQLException
	 */
	public void crudProveedor(int i) throws SQLException {

		Scanner sc = new Scanner(System.in);

		switch (i) {
		case 1:
			vista.insertID();
			String idInsert = sc.next();

			vista.insertNombre();
			String nombreInsert = sc.next();

			if (model.insertProveedores(idInsert, nombreInsert)) {
				vista.correctQuery("Proveedor insertado");
			}
			break;
		case 2:
			vista.nombreOId();
			i = sc.nextInt();

			switch (i) {
			case 1:
				vista.insertNombre();
				String nombreSelect = sc.next();
				vista.resultSelectProveedor(model.selectProveedors("", nombreSelect));
				break;
			case 2:
				vista.insertID();
				String idSelect = sc.next();
				vista.resultSelectProveedor(model.selectProveedors(idSelect, ""));
				break;

			}

			break;

		case 3:
			vista.resultSelectProveedor(model.listarProveedors());
			break;

		case 4:
			vista.insertID();
			String idUpdate = sc.next();

			vista.insertNombre();
			String nombreUpdate = sc.next();

			if (model.updateProveedor(idUpdate, nombreUpdate)) {
				vista.correctQuery("Proveedor actualizado");
			}
			break;

		case 5:
			vista.insertID();
			String idDelete = sc.next();

			if (model.deleteProveedor(idDelete)) {
				vista.correctQuery("Proveedor eliminado");
			}
			break;

		}

	}

	/**
	 * CRUD Suministra
	 * @param i
	 * @throws SQLException
	 */
	public void crudSuministra(int i) throws SQLException {

		Scanner sc = new Scanner(System.in);

		switch (i) {
		case 1:
			vista.insertCodigo();
			int codigoPieza = sc.nextInt();

			vista.insertID();
			String idProveedor = sc.next();

			vista.insertPrecio();
			int precio = sc.nextInt();

			if (model.insertSuministra(codigoPieza, idProveedor, precio)) {
				vista.correctQuery("Suministra insertado");
			}
			break;
		case 2:
			vista.nombreIdPrecio();
			i = sc.nextInt();

			switch (i) {
			case 1:
				vista.insertCodigo();
				int codigoSelect = sc.nextInt();
				vista.resultSelectSuministra(model.selectSuministra(codigoSelect, "", 0));
				break;
			case 2:
				vista.insertID();
				String idSelect = sc.next();
				vista.resultSelectSuministra(model.selectSuministra(0, idSelect, 0));
				break;

			case 3:
				vista.insertPrecio();
				int precioSelect = sc.nextInt();
				vista.resultSelectSuministra(model.selectSuministra(0, "", precioSelect));
				break;

			}

			break;

		case 3:
			vista.resultSelectSuministra(model.listrarSuministra());
			break;

		case 4:

			vista.insertCodigo();
			int codigoUpdate = sc.nextInt();

			vista.insertID();
			String idUpdate = sc.next();

			vista.insertPrecio();
			int precioUpdate = sc.nextInt();

			if (model.updateSuministra(codigoUpdate, idUpdate, precioUpdate)) {
				vista.correctQuery("Suministra actualizado");
			}
			break;

		case 5:
			vista.insertCodigo();
			int codigoDelete = sc.nextInt();

			vista.insertID();
			String idDelete = sc.next();

			if (model.deleteSuministra(codigoDelete, idDelete)) {
				vista.correctQuery("Suminstra eliminado");
			}
			break;

		}

	}

}
