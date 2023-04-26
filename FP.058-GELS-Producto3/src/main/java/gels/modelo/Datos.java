//Paquete donde tenemos esta clase
package gels.modelo;

//Imports necesarios
import dao.ArticuloDao;
import dao.ClienteDao;
import dao.PedidoDao;
import gels.modelo.ClientePremium;
import gels.modelo.Articulos;
import excepciones.ArticulosExcepciones;
import excepciones.ClientesExcepciones;
import excepciones.DbConexionExcepciones;
import java.util.Date;
import gels.modelo.Clientes.TipoCliente;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gels
 */
public class Datos {
    private ListaArticulos listaArticulos;
    private ListaClientes listaClientes;
    private ListaPedidos listaPedidos;

    public Datos() {
        listaArticulos = new ListaArticulos();
        listaClientes = new ListaClientes();
        listaPedidos = new ListaPedidos();
    }
    // métodos para listas de Artículos
    /**
     * Añade un elemento a la lista con los datos recibidos
     *
     * @param idArticulo
     * @param descripcion
     * @param precioProducto
     * @param precioEnvio
     * @param tiempoPrepEnvio
     * @return
     * @throws DbConexionExcepciones
     */
public boolean addToListaArticulos(int idArticulo, String descripcion, float precioProducto, float precioEnvio, int tiempoPrepEnvio) throws DbConexionExcepciones {
    Articulos articulo = new Articulos(idArticulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
    ArticuloDao articuloDao = new ArticuloDao();
    boolean result = articuloDao.registrar(articulo);
    /*if (result) {
        listaArticulos.addArticulo(articulo);
    }*/
    return result;
}
    /*public boolean addToListaArticulos(int idArticulo, String descripcion, float precioProducto, float precioEnvio, int tiempoPrepEnvio) {
        return registrar(new Articulos(idArticulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio));
}*/
    
    /**
     * Para mostrar un articulo
     *
     * @param id
     * @return
     */
    public String showArticulo(int id) {
        return listaArticulos.articuloPorId(id).toString();
    }
    //Metodos para listar Clientes
    /**
     * Añadimos un cliente a la lista con los datos recibidos
     *
     * @param nombre
     * @param domicilio
     * @param nif
     * @param email
     * @param tipoC
     * @return
     */
public boolean addToListaCliente(String nombre, String domicilio, String nif, String email, int tipoC) throws DbConexionExcepciones {
    if (tipoC < 0 || tipoC >= Clientes.TipoCliente.values().length) {
        System.out.println("El índice esta fuera de rango ");
}
    Clientes.TipoCliente tipoCliente = Clientes.TipoCliente.values()[tipoC];
    Clientes cliente = tipoCliente == Clientes.TipoCliente.PREMIUM ? new ClientePremium(nombre, domicilio, nif, email, TipoCliente.PREMIUM) : new ClienteEstandar(nombre, domicilio, nif, email, TipoCliente.ESTANDAR) {
      /*  @Override
        public String tipoCliente() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public float calcAnual() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }

        @Override
        public float descuentoEnv() {
            throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        }*/
    };
    ClienteDao clienteDao = new ClienteDao("");
    boolean result = clienteDao.registrar(cliente);
    return result;
}
        
       
    

    /**
     * Mostramos un cliente
     *
     * @param nif
     * @return
     */
    public String showCliente(String nif) {
        return listaClientes.clientePorNif(nif).toString();
    }

    //Metodos para listar pedidos
    /**
     * Añadimos un pedido a lista de pedidos
     *
     * @param nif
     * @param idArticulo
     * @param cantidadArticulo
     * @param fechaPedido
     * @param pedidoEnviado
     * @return
     * @throws excepciones.ClientesExcepciones
     * @throws excepciones.ArticulosExcepciones
     */
    public int addToListaPedidos(int idPedido, int Cantidad, Date FechaHora, int articulo, String cli, float precio) throws ClientesExcepciones, ArticulosExcepciones, DbConexionExcepciones {
    Pedidos pedido = new Pedidos();
    PedidoDao pedidoDao = new PedidoDao();
        int result = pedidoDao.registrar(pedido);
    /*if (result) {
        listaArticulos.addArticulo(articulo);
    }*/
    return result;

    }
    /**
     * Devuelve el id del Pedido
     *
     * @return
     */
    public int getIdPedido() {
        return listaPedidos.getSize() + 1;
    }

    public float getTotalPedido(int i) {
        return listaPedidos.getAt(i - 1).getTotal();
    }
}