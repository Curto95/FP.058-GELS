//Paquetes
package gels.modelo;
//Imports
import gels.modelo.Clientes.TipoCliente;
/**
 *
 * @author lucia.hidalgo
 */
public class ListaClientes extends Lista<Clientes> {
    Clientes cliente1;

    public boolean addCliente(String nombre, String domicilio, String nif, String email, TipoCliente tipoCliente) {
        if (tipoCliente.equals(TipoCliente.PREMIUM)) {
            cliente1 = new ClientePremium(nombre, domicilio, nif, email, tipoCliente);
        } else {
            cliente1 = new ClienteEstandar(nombre, domicilio, nif, email, tipoCliente);
        }
        this.add(cliente1);
        return true;
    }
    /**
     * Devuelve un cliente de la lista por su nif
     *
     * @param nif
     * @return
     */
    public Clientes clientePorNif(String nif) {
        int len = lista.size();
        Clientes c = null;
        for (int i = 0; i < len; i++) {
            if (lista.get(i).getNif().equals(nif)) {
                c = lista.get(i);
                break;
            }
        }
        return c;
    }
}