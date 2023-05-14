package gels.vista.data;


public class ArticuloView {
    int id_articulo;
    String descripcion;
    float pvp;
    float precioEnvio;
    int tiempoPrepEnvio;

    public ArticuloView(int id_articulo, String descripcion, float pvp, float precioEnvio, int tiempoPrepEnvio) {
        this.id_articulo = id_articulo;
        this.descripcion = descripcion;
        this.pvp = pvp;
        this.precioEnvio = precioEnvio;
        this.tiempoPrepEnvio = tiempoPrepEnvio;
    }
    
    public int getId_articulo() {
        return id_articulo;
    }

    public void setId_articulo(int id_articulo) {
        this.id_articulo = id_articulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPvp() {
        return pvp;
    }

    public void setPvp(float pvp) {
        this.pvp = pvp;
    }

    public float getPrecioEnvio() {
        return precioEnvio;
    }

    public void setPrecioEnvio(float precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public int getTiempoPrepEnvio() {
        return tiempoPrepEnvio;
    }

    public void setTiempoPrepEnvio(int tiempoPrepEnvio) {
        this.tiempoPrepEnvio = tiempoPrepEnvio;
    }

   
    public String toString() {
    	return    id_articulo + " : " +  descripcion + "| PVP: " + pvp + " | PrecioEnvío: " +  precioEnvio  + " | tiempo Preparacion: " + tiempoPrepEnvio + " días ";
    }
}
