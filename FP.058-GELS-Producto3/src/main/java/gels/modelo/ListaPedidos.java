//Paquetes
package gels.modelo;

//Imports
import java.util.Date;

/**
 *
 * @author gels
 */
public class ListaPedidos extends Lista<Pedidos> {
    Pedidos pedido1;
    public boolean addPedido(int idPedido, Clientes cli, Articulos articulo, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado) {
        pedido1 = new Pedidos(idPedido, cli, articulo, cantidadArticulo, fechaPedido, pedidoEnviado);
        this.add(pedido1);
        return true;
    }
}
