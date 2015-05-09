package dbaccess;

import java.sql.Connection;
import java.sql.SQLException;


public class TableUpdate {

	private Connection conn;
	private TableInfo ti;
	private QueryAnswerer qa;
	
	public TableUpdate(	String host, 
						String port, 
						String sID, 
						String username, 
						String passwd) throws SQLException { 
		conn = new DBConnection(host, port, sID).getDBConnection(username, passwd); 
		qa = new QueryAnswerer(conn);
		
	}

	public TableUpdate(Connection conn) throws SQLException { 
		this.conn = conn; 
		ti = new TableInfo(conn);
		qa = new QueryAnswerer(conn);
	}
	
	public TableInfo getTableInfo() {
		return ti; 
	}
	
	public QueryAnswerer getQA() {
		return qa;
	}
}
