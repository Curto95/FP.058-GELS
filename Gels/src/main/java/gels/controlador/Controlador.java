//Paquetes
package gels.controlador;

//Importaciones
import excepciones.ArticulosExcepciones;
import excepciones.ClientesExcepciones;
import gels.modelo.Datos;
import java.util.Date;

/**
 *
 * @author Gels
 */
public class Controlador {

    private Datos datos;

    public Controlador() {
        datos = new Datos();
    }

    /**
     * Método para validar si es un entero
     *
     * @param s
     * @return
     */
    public final boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Método para comprobar si es un número real (double)
     *
     * @param string
     * @return boolean
     */
    public final boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    /**
     * Método para comprobar si es un número flotante (float)
     *
     * @param string
     * @return boolean
     */
    public final boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Para añadir un cliente
     */
    public void addClientes(String nombre, String domicilio, String nif, String email, int tipoCliente) {
        datos.addToListaCliente(nombre, domicilio, nif, email, tipoCliente);
    }

    public String mostrarCliente(String nif) {
        return datos.showCliente(nif);
    }

    /**
     * Para añadir un articulo
     *
     * @param id_articulo
     * @param descripcion
     * @param precioProducto
     * @param precioEnvio
     * @param tiempoPrepEnvio
     */
    public void addArticulos(int id_articulo, String descripcion, float precioProducto, float precioEnvio, int tiempoPrepEnvio) {
        datos.addToListaArticulos(id_articulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
    }

    /**
     * Mostrar un articulo
     *
     * @param idArticulo
     * @return
     */
    public String mostrarArticulo(int idArticulo) {
        return datos.showArticulo(idArticulo);
    }

    /**
     * Añadir un pedido
     *
     * @param nifCliente
     * @param idArticulo
     * @param cantidadArticulo
     * @param fechaPedido
     * @return int (id pedido)
     * @throws excepciones.ClientesExcepciones
     * @throws excepciones.ArticulosExcepciones
     */
    public int addPedidos(String nifCliente, int idArticulo, int cantidadArticulo, Date fechaPedido) throws ClientesExcepciones, ArticulosExcepciones {
        return datos.addToListaPedidos(nifCliente, idArticulo, cantidadArticulo, fechaPedido, false);
    }

    public float totalPedido(int id) {
        return datos.getTotalPedido(id);
    }
}
