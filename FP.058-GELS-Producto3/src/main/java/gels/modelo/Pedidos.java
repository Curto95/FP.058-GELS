//Paquetes
package gels.modelo;
//Imports
import java.sql.Date;

/**
 *
 * @author lucia.hidalgo
 */
public class Pedidos {
    int idPedido;
    Clientes cli;
    Articulos articulo;
    int cantidadArticulo;
    Date FechaHora;
    boolean pedidoEnviado;
    float precio;

    public Pedidos(int idPedido, int cantidadArticulo, Date FechaHora, Articulos articulo, Clientes cli, float precio) {
        this.idPedido = idPedido;
        this.cantidadArticulo = cantidadArticulo;
        this.FechaHora = FechaHora;
        this.articulo = articulo;
        this.cli = cli;
        this.precio = precio;
        this.pedidoEnviado = pedidoEnviado;
        
        
    }
    public Pedidos(){
        
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public Clientes getcli() {
        return cli;
    }

    public void setcli(Clientes cli) {
        this.cli = cli;
    }

    public Articulos getArticulo() {
        return articulo;
    }

    public void setArticulo(Articulos articulo) {
        this.articulo = articulo;
    }

    public int getCantidadArticulo() {
        return cantidadArticulo;
    }

    public void setCantidadArticulo(int cantidadArticulo) {
        this.cantidadArticulo = cantidadArticulo;
    }

    public Date getFechaHora() {
        return FechaHora;
    }

    public void setFechaHora(Date FechaHora) {
        this.FechaHora = FechaHora;
    }

    public boolean pedidoEnviado() {
        return pedidoEnviado;
    }

    public void setPedidoEnviado(boolean pedidoEnviado) {
        this.pedidoEnviado = pedidoEnviado;
    }

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public float getTotal() {
		return (articulo.getprecioProducto() + articulo.getPrecioEnvio()) * cantidadArticulo;
	}
    
	/*
	 * Devolvemos los siguientes datos: número del pedido, fecha y hora del pedido, Nif y nombre del cliente, código y descripción del artículo, cantidad, precio artículo, 
	 * Coste envío, precio total y si ya se ha enviado.
	 */
    public String toString() {
        return "Pedido "  + idPedido + " | Fecha " + FechaHora.toString() 
        + " | NIF " + cli.getNif()
        + " -  " + cli.getNombre()
        + " | Artículo " + articulo.getidArticulos()
        + " -  " + articulo.getDescripcion()
        + " | Cantidad " + cantidadArticulo
        + " | Precio " + precio
        + " | Coste del envío " + articulo.getPrecioEnvio()
        + " | *Total: " + Float.toString(this.getTotal())
        + " | Enviado " + (pedidoEnviado ? "SÍ" : "NO");
    }
}
