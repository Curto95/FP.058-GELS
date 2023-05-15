package gels.connection;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import gels.zap.throwable.DbConnectionException;

public class Session {
	private static EntityManagerFactory sessionFactory;
	
	/**Hacemos setup **/
	public static void  open() throws Exception {
		try {
			sessionFactory = Persistence.createEntityManagerFactory( "gelsPU" );
		}
		catch(Exception e) {
			e.printStackTrace();
			throw new  DbConnectionException("Error de conexion: " + e.getMessage());
		}
		return;
	}
	
	public static EntityManagerFactory get() {
		return sessionFactory;
	}
	
	public static void close() {
		sessionFactory.close();
		return;
	}
	
	
}
