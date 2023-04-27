//Paquetes
package gels.modelo;

//Imports
import java.sql.Date;

/**
 *
 * @author gels
 */
public class ListaPedidos extends Lista<Pedidos> {
    Pedidos pedido1;
    public boolean addPedido(int idPedido, Clientes cli, Articulos articulo, int cantidadArticulo, Date FechaHora, boolean pedidoEnviado, float precio) {
        pedido1 = new Pedidos(idPedido, cantidadArticulo, FechaHora, articulo, cli, precio);
        this.add(pedido1);
        return true;
    }
}
