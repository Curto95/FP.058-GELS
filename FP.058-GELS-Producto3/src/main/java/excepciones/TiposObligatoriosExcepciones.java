//Paquetes
package excepciones;
/**
 *
 * @author lucia.hidalgo
 */
public class TiposObligatoriosExcepciones extends Exception {

    private static final long serialVersionUID = 22L;

    public TiposObligatoriosExcepciones(String valor) {
        super("El valor " + valor + " El tipo o valor es obligatorio, por favor, introduzca el valor requerido");
    }
}
