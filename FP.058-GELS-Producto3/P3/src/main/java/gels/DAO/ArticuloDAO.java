package gels.DAO;

import gels.modelo.Articulos;
import java.util.List;


public interface ArticuloDAO extends DAO<Articulos, String>{
    
    public void crear(Articulo articulo);
    public List<Articulo> buscarTodos();
    public void eliminar(int idArticulos);  
}
