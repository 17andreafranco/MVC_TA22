package modelo;

import java.sql.*;

/**
 * @author Andrea
 *
 */
/**
 * @author Andrea
 *
 */
/**
 * @author Andrea
 *
 */
public class modelo extends database {

	public modelo() {

	}

	/**
	 * Creación de la base de datos
	 * 
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean createDBQuery() throws SQLException {
		boolean createDB = false;

		try {

			Statement st = this.getConexion().createStatement();
			st.executeUpdate("CREATE DATABASE IF NOT EXISTS T22");

			// Drop tables

			st.executeUpdate("DROP TABLE IF EXISTS suministra;");
			st.executeUpdate("DROP TABLE IF EXISTS piezas;");
			st.executeUpdate("DROP TABLE IF EXISTS proveedores;");

			// Piezas table

			st.executeUpdate("CREATE TABLE IF NOT EXISTS piezas(" + "codigo int not null," + "nombre nvarchar(100),"
					+ "primary key(codigo))");

			// Proveedores table
			st.executeUpdate("CREATE TABLE IF NOT EXISTS proveedores(" + "id char(4) not null,"
					+ "nombre nvarchar(100)," + "primary key(id))");

			// Suministra table
			st.executeUpdate("CREATE TABLE IF NOT EXISTS suministra(" + "codigopiezas int not null,"
					+ "idproveedor char(4) not null," + "precio int," + "primary key(codigopiezas,idproveedor),"
					+ "key(codigopiezas)," + "foreign key(codigopiezas)" + "references piezas(codigo),"
					+ "key(idproveedor)," + "foreign key(idproveedor)" + "references proveedores(id))");

			createDB = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return createDB;

	}

	/**
	 * Isertar registros en las tablas
	 * 
	 * @return boolean
	 */
	public boolean insertValues() {

		boolean insertValues = false;

		try {

			Statement st = this.getConexion().createStatement();

			// Piezas table

			st.executeUpdate("INSERT INTO piezas VALUE " + "(1,'Pieza1')," + "(2,'Pieza2')," + "(3,'Pieza3'),"
					+ "(4,'Pieza4')," + "(5,'Pieza5')," + "(6,'Pieza6')," + "(7,'Pieza7')," + "(8,'Pieza8'),"
					+ "(9,'Pieza9')," + "(10,'Pieza10')");

			// Proveedores table
			st.executeUpdate("INSERT INTO proveedores VALUE" + "('000A','Proveedor1')," + "('000B','Proveedor2'),"
					+ "('000C','Proveedor3')," + "('000D','Proveedor4')," + "('000E','Proveedor5'),"
					+ "('000F','Proveedor6')," + "('000G','Proveedor7')," + "('000H','Proveedor8'),"
					+ "('000I','Proveedor9')," + "('000J','Proveedor10')");

			// Suministra table
			st.executeUpdate("INSERT INTO suministra VALUE" + "(1,'000A',50)," + "(1,'000B',30)," + "(2,'000C',70),"
					+ "(2,'000D',30)," + "(3,'000E',70)," + "(3,'000F',60)," + "(4,'000F',30)," + "(4,'000H',20),"
					+ "(5,'000I',50)," + "(5,'000J',20)");

			insertValues = true;

		} catch (

		SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return insertValues;
	}

	/**
	 * Elimina una tabla segun el parametro introducido
	 * 
	 * @param i
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean deleteTable(int i) throws SQLException {

		boolean deleteTables = false;

		try {
			Statement st = this.getConexion().createStatement();
			switch (i) {
			case 1:
				st.executeUpdate("DROP TABLE IF EXISTS piezas");
				deleteTables = true;
				break;
			case (2):
				st.executeUpdate("DROP TABLE IF EXISTS proveedores");
				deleteTables = true;
				break;
			case (3):
				st.executeUpdate("DROP TABLE IF EXISTS suministra");
				deleteTables = true;
				break;
			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return deleteTables;

	}

	/**
	 * Isertar registro en Piezas
	 * 
	 * @param id
	 * @param pieza
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean insertPiezas(int id, String pieza) throws SQLException {

		boolean insert = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("INSERT INTO piezas VALUE (" + (int) id + ", '" + pieza + "');");
			insert = true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return insert;
	}

	/**
	 * Insertar registro en Proveedores
	 * 
	 * @param id
	 * @param proveedor
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean insertProveedores(String id, String proveedor) throws SQLException {

		boolean insert = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("INSERT INTO proveedores VALUE ('" + id + "', '" + proveedor + "');");
			insert = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return insert;

	}

	/**
	 * Insertar registro en suministra
	 * 
	 * @param idPieza
	 * @param idProveedor
	 * @param precio
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean insertSuministra(int idPieza, String idProveedor, int precio) throws SQLException {

		boolean insert = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("INSERT INTO suministra VALUE (" + idPieza + ",'" + idProveedor + "'," + precio + ");");
			insert = true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return insert;

	}

	/**
	 * Mostrar tabla Piezas segun id o pieza
	 * 
	 * @param id
	 * @param pieza
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet selectPiezas(int id, String pieza) throws SQLException {

		ResultSet rs = null;

		try {

			if (id == 0) {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM piezas WHERE nombre = '" + pieza + "';");

			} else {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM piezas WHERE codigo = " + id + ";");

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	/**
	 * Mostrar tabla Proveedor segun id o preoveedor
	 * 
	 * @param id
	 * @param proveedor
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet selectProveedors(String id, String proveedor) throws SQLException {

		ResultSet rs = null;

		try {

			if (id.equals("")) {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM proveedores WHERE nombre = '" + proveedor + "';");

			} else {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM proveedores WHERE id = '" + id + "';");

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	/**
	 * Mostrar tabla Suministra segun idPieza, idProveedor o precio
	 * 
	 * @param idPieza
	 * @param idProveedor
	 * @param precio
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet selectSuministra(int idPieza, String idProveedor, int precio) throws SQLException {

		ResultSet rs = null;

		try {

			if (!idProveedor.equalsIgnoreCase("")) {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM suministra WHERE idproveedor = '" + idProveedor + "';");

			} else if (idPieza != 0) {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM suministra WHERE codigopiezas = " + idPieza + ";");

			} else if (precio != 0) {

				Statement st = this.getConexion().createStatement();
				rs = st.executeQuery("SELECT * FROM suministra WHERE precio = " + precio + ";");

			}

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	/**
	 * Mostrar la tabla Piezas
	 * 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet listarPiezas() throws SQLException {

		ResultSet rs = null;

		try {

			Statement st = this.getConexion().createStatement();
			rs = st.executeQuery("SELECT * FROM piezas;");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	/**
	 * Mostrar la tabla Proveedores
	 * 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet listarProveedors() throws SQLException {

		ResultSet rs = null;

		try {

			Statement st = this.getConexion().createStatement();
			rs = st.executeQuery("SELECT * FROM proveedores;");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	/**
	 * Mostrar la tabla Suministra
	 * 
	 * @return ResultSet
	 * @throws SQLException
	 */
	public ResultSet listrarSuministra() throws SQLException {

		ResultSet rs = null;

		try {

			Statement st = this.getConexion().createStatement();
			rs = st.executeQuery("SELECT * FROM suministra;");

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return rs;
	}

	/**
	 * Cambiar un campo de registro de la tabla Piezas
	 * 
	 * @param id
	 * @param pieza
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean updatePiezas(int id, String pieza) throws SQLException {

		boolean update = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("UPDATE piezas SET nombre ='" + pieza + "' WHERE codigo = " + id + ";");
			update = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return update;

	}

	/**
	 * Cambiar un campo de registro de la tabla Proveedor
	 * 
	 * @param id
	 * @param pieza
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean updateProveedor(String id, String proveedor) throws SQLException {

		boolean update = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("UPDATE proveedores SET nombre = '" + proveedor + "' WHERE id = '" + id + "';");
			update = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return update;
	}

	/**
	 * Cambiar un campo de registro de la tabla Suministra
	 * 
	 * @param id
	 * @param pieza
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean updateSuministra(int idPieza, String idProveedor, int precio) throws SQLException {
		boolean update = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("UPDATE suministra SET precio=" + precio + " WHERE idproveedor = '" + idProveedor
					+ "' or codigopiezas= " + idPieza + ";");
			update = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return update;
	}

	/**
	 * Eliminar un registro de la tabla Piezas
	 * 
	 * @param id
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean deletePiezas(int id) throws SQLException {

		boolean delete = false;

		try {

			Statement st = this.getConexion().createStatement();
			st.executeUpdate("DELETE FROM piezas WHERE codigo = " + id + ";");
			delete = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return delete;

	}

	/**
	 * Eliminar un registro de la tabla Proveedor
	 * 
	 * @param id
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean deleteProveedor(String id) throws SQLException {

		boolean delete = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("DELETE FROM proveedores WHERE id = '" + id + "';");
			delete = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return delete;
	}

	/**
	 * Eliminar un registro de la tabla Suministra
	 * 
	 * @param id
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean deleteSuministra(int idPieza, String idProveedor) throws SQLException {
		boolean delete = false;

		try {
			Statement st = this.getConexion().createStatement();
			st.executeUpdate("DELETE FROM suministra WHERE idproveedor = '" + idProveedor + "' or codigopiezas ="
					+ idPieza + ";");

			delete = true;

		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return delete;
	}

}
