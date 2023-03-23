import java.sql.Date;
import java.sql.Time;

public class Pedido {
    //Atributos
    private int numpedido;
    private String cliente;
    private String articulo;
    private int cantidadunidades;
    private Date fecha;
    private Time hora;
    private float precio;
    

    //Constructores
    public Pedido() {
    }

    public Pedido(int numpedido, String cliente, String articulo, int cantidadunidades, Date fecha, Time hora,
            float precio) {
        this.numpedido = numpedido;
        this.cliente = cliente;
        this.articulo = articulo;
        this.cantidadunidades = cantidadunidades;
        this.fecha = fecha;
        this.hora = hora;
        this.precio = precio;
    }

    
    
    //Gettes y setters
    public int getNumpedido() {
        return numpedido;
    }
    public void setNumpedido(int numpedido) {
        this.numpedido = numpedido;
    }

    public String getCliente() {
        return cliente;
    }
    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getArticulo() {
        return articulo;
    }
    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public int getCantidadunidades() {
        return cantidadunidades;
    }
    public void setCantidadunidades(int cantidadunidades) {
        this.cantidadunidades = cantidadunidades;
    }

    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

}
