package connection;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {

	private static ConnectionFactory instance;
	
	public static ConnectionFactory getInstance() {
		if(instance == null) {
			instance = new ConnectionFactory();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException, NamingException {
		
		Connection connection = null;
		
		Context initialcontext = new javax.naming.InitialContext();
		Context context = (javax.naming.Context) initialcontext.lookup("java:");
		DataSource datasource = (javax.sql.DataSource) context.lookup("jboss/datasources/contratos");
		connection = datasource.getConnection();
		return connection;
		
	}
	
	public void releaseConnection(Connection connection) throws SQLException {
		connection.close();
	}
	
}
