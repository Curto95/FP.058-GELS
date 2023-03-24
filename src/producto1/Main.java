package producto1;
import java.util.ArrayList;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Creamos algunos clientes estándar
        Cliente cliente1 = new Cliente("cliente1@example.com", "Silvia", "Calle Mayor 1", "12345678A");
        Cliente cliente2 = new Cliente("cliente2@example.com", "Curto", "Calle Menor 2", "87654321B");
        
        // Creamos algunos clientes premium
        ClientePremium cliente3 = new ClientePremium("cliente3@example.com", "Lucia", "Calle del Medio 3", "11111111C", 100.0f, 0.05f);
        ClientePremium cliente4 = new ClientePremium("cliente4@example.com", "Guillermo", "Calle del Final 4", "22222222D", 150.0f, 0.1f);
        
        // Creamos algunos artículos
        Articulo articulo1 = new Articulo("0001", "Artículo 1", 10.0f, 2.5f, 1);
        Articulo articulo2 = new Articulo("0002", "Artículo 2", 20.0f, 3.0f, 2);
        Articulo articulo3 = new Articulo("0003", "Artículo 3", 30.0f, 4.0f, 3);
        
        // Creamos algunos pedidos
        Date fecha1 = new Date();
        Date hora1 = new Date();
        Pedido pedido1 = new Pedido(1, "cliente1@example.com", "0001", 3, fecha1, hora1, 35.0f);
        
        Date fecha2 = new Date();
        Date hora2 = new Date();
        Pedido pedido2 = new Pedido(2, "cliente2@example.com", "0002", 2, fecha2, hora2, 46.0f);
        
        // Añadimos los clientes y los artículos a las listas correspondientes
        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        
        ArrayList<Articulo> articulos = new ArrayList<>();
        articulos.add(articulo1);
        articulos.add(articulo2);
        articulos.add(articulo3);
        
        // Añadimos los pedidos a la lista de pedidos pendientes
        ArrayList<Pedido> pedidosPendientes = new ArrayList<>();
        pedidosPendientes.add(pedido1);
        pedidosPendientes.add(pedido2);
        
        // Mostramos los clientes
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            cliente.mostrarCliente();
        }
        
        // Mostramos los artículos
        System.out.println("Artículos:");
        for (Articulo articulo : articulos) {
            articulo.mostrarArticulo();
        }
        
        // Mostramos los pedidos pendientes
        System.out.println("Pedidos pendientes:");
        for (Pedido pedido : pedidosPendientes) {
            pedido.mostrarPedido();
        }
    }
}
