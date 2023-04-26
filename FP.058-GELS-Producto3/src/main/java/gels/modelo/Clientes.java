package gels.modelo;

/**
 *
 * @author Gels
 */
//Declaramos la clase clientes - tipo abstracta
public abstract class Clientes {
    //Declaramos tipo cliente - premium o estandar
    public enum TipoCliente
	{
	    PREMIUM, ESTANDAR
	}
    //Declaramos las variables de clientes
    String nif;
    String nombre;
    String domicilio;
    String email;
    TipoCliente tipoCliente;
    
    //Declaramos Clientes con this.variables
    public Clientes(String nombre, String domicilio, String nif, String email, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }
    
    //Declaramos el get de Nombre
    public String getNombre() {
        return nombre;
    }
    //Declaramos el set de Nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    //Declaramos el get de Domicilio
    public String getDomicilio() {
        return domicilio;
    }
    //Declaramos el set de domicilio
    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
    //Declaramos el get de Nif
    public String getNif() {
        return nif;
    }
    //Declaramos el set de Nif
    public void setNif(String nif) {
        this.nif = nif;
    }
    //Declaramos el get de Email
    public String getEmail() {
        return email;
    }
    //Declaramos el set de Email
    public void setEmail(String email) {
        this.email = email;
    }
    //Declaramos el get de Tipo cliente
    public String getTipoCliente() {
        return tipoCliente.name();
    }
    //Declaramos el set de Tipo cliente
    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = TipoCliente.valueOf(tipoCliente);
    }
    
    //Añadimos toString de Clientes
    public String toString() {
        return nif + " | " + nombre + " | " + domicilio  + " | " + email  + " | " + tipoCliente.toString();
    }
    
    //Declaramos tipoCliente, calcAnual, 
    public abstract String tipoCliente();
    public abstract float calcAnual();
    public abstract float descuentoEnv();
}

