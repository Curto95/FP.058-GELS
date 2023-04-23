package dao;

import excepciones.DbConexionExcepciones;
import java.util.List;
import gels.modelo.Articulos;
import gels.modelo.idao.IArticulosDao;

public class ArticuloDao implements IArticulosDao{

    private final String SELECT_DFT = "SELECT id_articulo, descripcion, precioProducto, precio_envio, tiempo_prep_envio FROM ARTICULOS";

    public ArticuloDao() {
    }

    public boolean registrar(Articulos articulo) throws DbConexionExcepciones {
        return false;
    }

    public List<Articulos> obtener() throws DbConexionExcepciones {
        return null;
    }

    public List<Articulos> obtenerPorDescripcion(String des) throws DbConexionExcepciones {
        return null;
    }

    public Articulos obtenerPorId(int id) throws DbConexionExcepciones {
        return null;
    }

    public boolean actualizar(Articulos articulo) throws DbConexionExcepciones {
        return false;
    }

    public boolean eliminar(int id_articulo) throws DbConexionExcepciones {
        return false;
    }
}

