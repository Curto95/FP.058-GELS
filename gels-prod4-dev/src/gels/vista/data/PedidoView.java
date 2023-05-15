package gels.vista.data;

// Imports
import java.util.Date;

public class PedidoView {
    long id_pedido;
    ClienteView cli;
    ArticuloView articulo;
    int cantidadArticulo;
    Date fechaPedido;
    boolean pedidoEnviado;
    float total;
    
    
    public PedidoView(long id_pedido, ClienteView cli, ArticuloView articulo, int cantidadArticulo, Date fechaPedido, boolean pedidoEnviado, float total) {
        this.id_pedido = id_pedido;
        this.cli = cli;
        this.articulo = articulo;
        this.cantidadArticulo = cantidadArticulo;
        this.fechaPedido = fechaPedido;
        this.pedidoEnviado = pedidoEnviado;
        this.total = total;
    }

    public long getId_pedido() {
        return id_pedido;
    }

    public void setId_pedido(int id_pedido) {
        this.id_pedido = id_pedido;
    }

    public ClienteView getcli() {
        return cli;
    }

    public void setcli(ClienteView cli) {
        this.cli = cli;
    }

    public ArticuloView getArticulo() {
        return articulo;
    }

    public void setArticulo(ArticuloView articulo) {
        this.articulo = articulo;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public boolean pedidoEnviado() {
        return pedidoEnviado;
    }

    public void setPedidoEnviado(boolean pedidoEnviado) {
        this.pedidoEnviado = pedidoEnviado;
    }

    
    
	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}


	/*
	 * Devuelve los datos siguientes: número de pedido, fecha y hora del pedido, Nif y nombre del ClienteView, código y descripción del artículo, cantidad, precio artículo, 
	 * coste envío, precio total y si ya se ha enviado.
	 */
    public String toString() {
        return "Pedido : "  + id_pedido + " | Fecha " + fechaPedido.toString() 
        + " | NIF : " + cli.getNif()
        + " -  " + cli.getNombre()
        + " | Artículo : " + articulo.getId_articulo()
        + " -  " + articulo.getDescripcion()
        + " | Cantidad : " + cantidadArticulo
        + " | Precio articulo : " + articulo.getPvp()
        + " | Coste envío : " + articulo.getPrecioEnvio()
        + " | @Total! : " + Float.toString(this.total)
        + " | Enviado : " + (pedidoEnviado ? "S�?" : "NO");
    }
    

}
