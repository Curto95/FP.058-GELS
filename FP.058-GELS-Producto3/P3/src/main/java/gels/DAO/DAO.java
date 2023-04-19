package gels.DAO;

import java.util.List;


public interface DAO<T, K> {
    
    void insertar(T a) throws DAOException;
    
    List<T> obtenerTodos();
    
    T obtener(K id);
    
    
}
