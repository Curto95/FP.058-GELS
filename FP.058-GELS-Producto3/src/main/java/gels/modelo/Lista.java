//Paquetes
package gels.modelo;
//Imports
import java.util.ArrayList;
/**
 *
 * @author gels
 */
public class Lista<T> {
    protected ArrayList<T> lista;
    /**
     * Constructor de la clase Lista<T>
     */
    public Lista() {
        lista = new ArrayList<>();
    }
    /**
     * Devolvemos el tamaño de la lista
     *
     * @return
     */
    public int getSize() {
        return lista.size();
    }
    /*
    *Añadimos un elemento t a lista
     */
    public void add(T t) {
        lista.add(t);
    }

    /**
     * Eliminamos un elemento t de lista.
     *
     * @param t
     */
    public void borrar(T t) {
        lista.remove(t);
    }

    /**
     * Devolvemos el objeto que está en la posición 'position'
     */
    public T getAt(int position) {
        return lista.get(position);
    }

    /**
     * Limpiamos/reiniciamos la lista
     */
    public void clear() {
        lista.clear();
    }

    /**
     * Devolvemos true si la lista esta vacía (empty).
     *
     * @return
     */
    public boolean isEmpty() {
        return lista.isEmpty();
    }

    /**
     * Devolvemos toda la lista
     *
     * @return
     */
    public ArrayList<T> getArrayList() {
        return lista;
    }
}
