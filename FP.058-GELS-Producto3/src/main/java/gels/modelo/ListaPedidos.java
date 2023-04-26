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
    public boolean addPedido(int idPedido, Clientes cli, Articulos articulo, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado, float precio) {
        pedido1 = new Pedidos(idPedido, cantidadArticulo, fechaPedido, articulo, cli, precio);
        this.add(pedido1);
        return true;
    }
}
