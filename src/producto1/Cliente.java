package producto1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class Cliente {
    private final String email;
    private String nombre;
    private String domicilio;
    private String NIF;
    private float cuotaAnual;
    private float descuentoCompra;
    
    public Cliente(String email, String nombre, String domicilio, String NIF) {
        this.email = email;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.NIF = NIF;
        this.cuotaAnual = cuotaAnual;
        this.descuentoCompra = descuentoCompra;
    }
    
    public void mostrarCliente() {
        System.out.println("Email: " + email);
        System.out.println("Nombre: " + nombre);
        System.out.println("Domicilio: " + domicilio);
        System.out.println("NIF: " + NIF);
        System.out.println("Cuota anual: " + cuotaAnual);
        System.out.println("Descuento por compra: " + descuentoCompra);
    }
    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("cliente1@gmail.com", "Cliente 1", "Calle Falsa 123", "12345678A");
        
        // Acceder al atributo email desde una clase anónima o lambda
        ActionListener actionListener = new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Email del cliente: " + cliente1.email);
            }
        };
        
        // Acceder al atributo email desde un stream
        List<Cliente> clientes = Arrays.asList(cliente1);
        clientes.stream().forEach(c -> System.out.println("Email del cliente: " + c.email));
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public String getNIF() {
        return NIF;
    }

    public float getCuotaAnual() {
        return cuotaAnual;
    }

    public float getDescuentoCompra() {
        return descuentoCompra;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public void setCuotaAnual(float cuotaAnual) {
        this.cuotaAnual = cuotaAnual;
    }

    public void setDescuentoCompra(float descuentoCompra) {
        this.descuentoCompra = descuentoCompra;
    }

    @Override
    public String toString() {
        return "Cliente{" + "email=" + email + ", nombre=" + nombre + ", domicilio=" + domicilio + ", NIF=" + NIF + ", cuotaAnual=" + cuotaAnual + ", descuentoCompra=" + descuentoCompra + '}';
    }
    
}
