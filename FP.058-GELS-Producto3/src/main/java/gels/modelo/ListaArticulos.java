//Paquetes
package gels.modelo;
/**
 *
 * @author lucia.hidalgo
 */
public class ListaArticulos extends Lista<Articulos> {
    
    Articulos articulo;
    
    public boolean addArticulo(int idArticulo, String descripcion, float precioProducto, float precioEnvio, int tiempoPrepEnvio) {
        articulo = new Articulos(idArticulo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
        this.add(articulo);
        return true;
    }
    /**
     * Devuelve un artículo de la lista por su id
     *
     * @param idPedido
     * @return Articulo
     */
    public Articulos articuloPorId(int id) {
        int len = lista.size();
        Articulos a = null;
        for (int i = 0; i < len; i++) {
            if (lista.get(i).getidArticulos() == id) {
                a = lista.get(i);
                break;
            }
        }
        return a;
    }
}
