package producto1;

//Declaramos la clase cliente premium extendiendola de clase cliente con sus propios atributos
public class ClientePremium extends Cliente{
    private float cuotaAnual;
    private float descuentoCompra;
    
    //Iniciamos la clase cliente premium
    public ClientePremium(String email, String nombre, String domicilio, String NIF, float cuotaAnual, float descuentoCompra) {
        super(email, nombre, domicilio, NIF);
        this.cuotaAnual = cuotaAnual;
        this.descuentoCompra = descuentoCompra;
    }

    //Insertamos los metodos get
    public float getCuotaAnual() {
        return cuotaAnual;
    }

    public float getDescuentoCompra() {
        return descuentoCompra;
    }
    
    //Insertamos los metodos set
    public void setCuotaAnual(float cuotaAnual) {
        this.cuotaAnual = cuotaAnual;
    }

    public void setDescuentoCompra(float descuentoCompra) {
        this.descuentoCompra = descuentoCompra;
    }
    
}
