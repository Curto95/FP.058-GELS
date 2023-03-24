package producto1;

//Creamos la clase articulo con sus atributos
public class Articulo {
    private String codigo;
    private String descripcion;
    private float precio;
    private float gastosEnvio;
    private int tiempoPreparacion;

    //Declaramos la clase articulo
    public Articulo(String codigo, String descripcion, float precio, float gastosEnvio, int tiempoPreparacion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.gastosEnvio = gastosEnvio;
        this.tiempoPreparacion = tiempoPreparacion;
    }
    
    //Realizamos los metodos get
    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public float getGastosEnvio() {
        return gastosEnvio;
    }

    public int getTiempoPreparacion() {
        return tiempoPreparacion;
    }
    
    //Realizamos los metodos set
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public void setGastosEnvio(float gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public void setTiempoPreparacion(int tiempoPreparacion) {
        this.tiempoPreparacion = tiempoPreparacion;
    }
    
    //Declaramos las funciones
    public void añadirArticulo() {
        // Código para añadir un artículo a la lista de artículos
    }

    public void mostrarArticulos() {
        // Código para mostrar la lista de todos los artículos
    }

    void mostrarArticulo() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

