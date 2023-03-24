package producto1;
import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private int numPedido;
    private String cliente;
    private String articulo;
    private int cantidadUnidades;
    private Date fecha;
    private Date hora;
    private float precio;
    private boolean enviado;

    public Pedido(int numPedido, String cliente, String articulo, int cantidadUnidades, Date fecha, Date hora, float precio) {
        this.numPedido = numPedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidadUnidades = cantidadUnidades;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
        this.enviado = false;
    }

    public int getNumPedido() {
        return numPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getCantidadUnidades() {
        return cantidadUnidades;
    }

    public Date getFecha() {
        return fecha;
    }

    public Date getHora() {
        return hora;
    }

    public float getPrecio() {
        return precio;
    }

    public boolean isEnviado() {
        return enviado;
    }

    public void setEnviado(boolean enviado) {
        this.enviado = enviado;
    }

    public void añadirPedido() {
        // Código para añadir un pedido a la lista de pedidos pendientes
    }

    public void eliminarPedido() {
        // Código para eliminar un pedido de la lista de pedidos pendientes
    }

    public void mostrarPendientes() {
        // Código para mostrar la lista de todos los pedidos pendientes
    }

    public void mostrarEnviados() {
        // Código para mostrar la lista de todos los pedidos enviados
    }

    void mostrarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
