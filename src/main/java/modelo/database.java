package modelo;

import java.sql.*;

/**
 * @author Andrea
 *
 */
public class database {
	

	private String db = "TA22";
	private String user = "root";
	private String password = "7INs3!h09L%d";
	private String url = "jdbc:mysql://localhost:3306/" + this.db;
	private Connection conn = null;

	public database() {

		this.conn = Connection();

	}

	/**
	 * Connexion con la base de datos
	 * @return Connection
	 */
	public Connection Connection() {
		try {
			this.conn = DriverManager.getConnection(this.url, this.user, this.password);
			System.out.println("-Open db: " + this.db + " - Ok");
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return conn;
	}

	public Connection getConexion() {
		return this.conn;
	}

}
