package gels.modelo;
/**
 *
 * @author gels
 */
public class ClienteEstandar extends Clientes {
    public ClienteEstandar(String nombre, String domicilio, String nif, String email) {
        super(nombre, domicilio, nif, email, TipoCliente.ESTANDAR);
    }

    @Override
    public String tipoCliente() {
        return TipoCliente.ESTANDAR.toString();
    }

    @Override
    public float calcAnual() {
        return 0;
    }

    @Override
    public float descuentoEnv() {
        return 0;
    }
}
