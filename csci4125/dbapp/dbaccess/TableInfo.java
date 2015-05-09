package dbaccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class TableInfo {

	private Connection conn;
	final String host = "localhost"; 
	final String port = "1521";
	final String sID = "nbdb";

	public TableInfo(	String host, 
						String port, 
						String sID, 
						String username, 
						String passwd) throws SQLException { 
		conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
	}

	public TableInfo(String username, String passwd) throws SQLException { 
		this.conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
 
	}

	public TableInfo(Connection conn) throws SQLException { 
		this.conn = conn; 
	}
	
	public ResultSet runSQLQuery(String str) throws SQLException {
		Statement stmt = conn.createStatement();
		return stmt.executeQuery(str);
	}
}