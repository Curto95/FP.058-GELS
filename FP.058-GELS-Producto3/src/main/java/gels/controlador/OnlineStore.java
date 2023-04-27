package gels.controlador;
import conexion.Conexion;
import excepciones.DAOException;
import excepciones.DbConexionExcepciones;
import gels.vista.GestionOs;
/**
 *
 * @author Gels
 */
public class OnlineStore {
	
	public static void main(String[] args) throws DAOException, DbConexionExcepciones {
		GestionOs gestion = new GestionOs();
		gestion.inicio();
                
	}
}
