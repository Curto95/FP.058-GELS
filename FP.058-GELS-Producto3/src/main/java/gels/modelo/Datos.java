//Paquete donde tenemos esta clase
package gels.modelo;

//Imports necesarios
import dao.ArticuloDao;
import dao.ClienteDao;
import dao.PedidoDao;
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
    Clientes.TipoCliente tipoCliente = Clientes.TipoCliente.values()[tipoC];
    Clientes cliente = new Clientes(nombre, domicilio, nif, email, tipoCliente) {
        @Override
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
        }
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
    public int addToListaPedidos(String nif, int idArticulo, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado, float precio) throws ClientesExcepciones, ArticulosExcepciones {
        int id_pedido = getIdPedido();
        Clientes cli = listaClientes.clientePorNif(nif);
        if (cli == null) {
            throw new ClientesExcepciones("El cliente no existe, no es posible crear la petición, intentelo de nuevo con otros datos");
        }
        Articulos articulo = listaArticulos.articuloPorId(idArticulo);
        if (articulo == null) {
            throw new ArticulosExcepciones("El articulo no existe, no es posible crear la petición, intentelo de nuevo con otros datos");
        }
        listaPedidos.addPedido(idArticulo, cli, articulo, cantidadArticulo, fechaPedido, pedidoEnviado, precio);
        Pedidos pedido = new Pedidos(id_pedido, cli, articulo, cantidadArticulo, fechaPedido, pedidoEnviado, precio);
        PedidoDao pedidoDao = new PedidoDao();
        int id_generado = -1;
        try {
            id_generado = pedidoDao.registrar(pedido);
        } catch (DbConexionExcepciones ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id_generado;
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