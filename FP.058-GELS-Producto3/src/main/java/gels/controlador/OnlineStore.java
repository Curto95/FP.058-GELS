package gels.controlador;
import conexion.Conexion;
import excepciones.DAOException;
import gels.vista.GestionOs;
/**
 *
 * @author Gels
 */
public class OnlineStore {
	
	public static void main(String[] args) throws DAOException {
		GestionOs gestion = new GestionOs();
		gestion.inicio();
                
	}
}
