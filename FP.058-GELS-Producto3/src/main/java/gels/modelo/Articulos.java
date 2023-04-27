package gels.modelo;
/**
 *
 * @author Gels
 */
//Declaramos la clase Articulos con sus variables y tipos
public class Articulos {
    int idArticulos;
    String descripcion;
    float precioEnvio;
    float precioProducto;
    int tiempoPrepEnvio;

    //Declaramos articulos con this.variables
    public Articulos(int idArticulos, String descripcion, float precioProducto, float precioEnvio, int tiempoPrepEnvio) {
        this.idArticulos = idArticulos;
        this.descripcion = descripcion;
        this.precioProducto = precioProducto;
        this.precioEnvio = precioEnvio;
        this.tiempoPrepEnvio = tiempoPrepEnvio;
    }
    public Articulos(){
        
    }
  
    //Declaramos get de id Articulos - id articulo
    public int getidArticulos() {
        return idArticulos;
    }
    //Declaramos set de Id articulos - id articulo
    public void setidArticulos(int idArticulo) {
        this.idArticulos = idArticulo;
    }
    //Declaramos get de descripción del articulo
    public String getDescripcion() {
        return descripcion;
    }
    //Declaramos set de descripción del articulo
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //Declaramos get del precio del articulo
    public float getprecioProducto() {
        return precioProducto;
    }
    //Declaramos set del precio del articulo
    public void setprecioProducto(float pvp) {
        this.precioProducto = precioProducto;
    }
    //Declaramos get del precio del envio
    public float getPrecioEnvio() {
        return precioEnvio;
    }
    //Declaramos set del precio del envio
    public void setPrecioEnvio(float precioEnvio) {
        this.precioEnvio = precioEnvio;
    }
    //Declaramos get del tiempo de preparación del envio
    public int getTiempoPrepEnvio() {
        return tiempoPrepEnvio;
    }
    //Declaramos set del tiempo de preparación del envio
    public void setTiempoPrepEnvio(int tiempoPrepEnvio) {
        this.tiempoPrepEnvio = tiempoPrepEnvio;
    }

   //Metodo toString para devolver los valores
    @Override
    public String toString() {
    	return idArticulos + ": |" +  descripcion + "| Precio del producto: " + precioProducto + " | Precio del envío: " +  precioEnvio  + " | Tiempo de preparacion: " + tiempoPrepEnvio + " días";
    }
}