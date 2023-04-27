package gels.modelo;
/**
 *
 * @author gels
 */
public class ClientePremium extends Clientes {
    int Descuento;
    int TarifaAnual;
    public ClientePremium(String nombre, String domicilio, String nif, String email, TipoCliente tipocliente) {
        super(nombre, domicilio, nif, email, TipoCliente.PREMIUM);
    }

    public ClientePremium(int Descuento, int TarifaAnual) {
        this.Descuento = Descuento;
        this.TarifaAnual = TarifaAnual;
    }
    

    public int getDescuento() {
        return Descuento;
    }

    public void setDescuento(int Descuento) {
        this.Descuento = Descuento;
    }

    public int getTarifaAnual() {
        return TarifaAnual;
    }

    public void setTarifaAnual(int TarifaAnual) {
        this.TarifaAnual = TarifaAnual;
    }
    
    @Override
    public String tipoCliente() {
        return "PREMIUM";
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
