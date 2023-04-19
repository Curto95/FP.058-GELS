package gels.controlador;
import gels.DAO.Conexion;
import gels.DAO.DAOException;
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
