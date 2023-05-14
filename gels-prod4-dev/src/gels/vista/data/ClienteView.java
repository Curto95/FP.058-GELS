package gels.vista.data;

/**
 * Esta clase se encarga de tratar los datos para mostrarlos por pantalla
 * No se utiliza herencia de ClienteEstandar / Premium de momento ya que se van a mostrar los mismos campos
 * 
 * @author jsectarios
 *  *
 */

public class ClienteView {
	// este enumrador es especial, le añadimos la descripción
	public enum TClienteView
	{
	    PREMIUM("Premium"),
	    ESTANDARD("Normal");
		
		private String tipo;
		
		TClienteView(String t) {
			tipo = t;
		}
		
		public String obtenerDescripcion(){
			return tipo;
		}
	}
	
	Long idCliente;
    String nif;
    String nombre;
    String domicilio;
    String email;
    TClienteView tipoCliente;
    
    public ClienteView() {
    	
    }
    
    
    public ClienteView(Long id, String nombre, String domicilio, String nif, String email, TClienteView tipoCliente) {
    	this.idCliente = id;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.nif = nif;
        this.email = email;
        this.tipoCliente = tipoCliente;
    }

      

	public Long getIdCliente() {
		return idCliente;
	}


	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}



	public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public TClienteView getTipoCliente() {
        return tipoCliente;
    }
    
    public void setTipoCliente(TClienteView tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = TClienteView.valueOf(tipoCliente);
    }
    
    public String toString() {
        return nif + " | " + nombre + " | " + domicilio  + " | " + email  + " | " + tipoCliente.toString();
    }
    
     
    public String descripcionTipoCliente() {
    	return tipoCliente.obtenerDescripcion();
    };
    
    
    
    /**
     * todavía no sabemos para qué utilizar estos métodos
     * @return
     */
    public float calcAnual() {
    	return 0;
    }
    
    public  float descuentoEnv() {
    	return 0;
    }
    

}
