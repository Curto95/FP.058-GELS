package gels.vista;
/**
 *
 * @author gels
 */
//Imports
import excepciones.ArticulosExcepciones;
import excepciones.ClientesExcepciones;
import excepciones.DbConexionExcepciones;
import excepciones.FechaExcepcion;
import excepciones.TiposObligatoriosExcepciones;
import gels.controlador.Controlador;
import gels.modelo.Articulos;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestionOs {

    private Controlador controlador;

    Scanner teclado = new Scanner(System.in);

    public GestionOs() throws DbConexionExcepciones {
        controlador = new Controlador();
    }

    public void inicio() {
        boolean salir = false;
        char opcio;
        do {
            System.out.println("1. Menu de gestión de articulos");
            System.out.println("2. Menu de gestión de clientes");
            System.out.println("3. Menu de gestión de pedidos");
            System.out.println("0. Salir");
            opcio = pedirOpcion();
            switch (opcio) {
                case '1':
					try {
                    showGestionArticulos();
                } catch (TiposObligatoriosExcepciones e1) {
                    System.out.println(e1.getMessage()); //Muestra el error
                } catch (DbConexionExcepciones ex) {
                    Logger.getLogger(GestionOs.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

                case '2':
					try {
                    showGestionClientes();
                } catch (TiposObligatoriosExcepciones | ClientesExcepciones e1) {
                    System.out.println(e1.getMessage()); //Muestra el error
                }
                break;
                case '3':					
					try {
                    showGestionPedidos();
                } catch (FechaExcepcion | TiposObligatoriosExcepciones | ClientesExcepciones | ArticulosExcepciones e) {
                    System.out.println(e.getMessage()); //Muestra el error
                }

                break;
                case '0':
                    salir = true;
            }
        } while (!salir);
    }

    char pedirOpcion() {
        String resp;
        System.out.println("Elige una opción (1,2,3 o 0):");
        resp = teclado.nextLine();
        if (resp.isEmpty()) {
            resp = " ";
        }
        return resp.charAt(0);
    }

    /**
     * Menú para la gestión de artículos
     *
     * @throws ValorObligatorioException
     */
    private void showGestionArticulos() throws TiposObligatoriosExcepciones, DbConexionExcepciones {
    int codigo;
    String descripcion;
    float precioProducto;
    float precioEnvio;
    int tiempoPrepEnvio;
    final String codigoField = "Codigo : "; //el texto del codigo articulo

    System.out.println("Menú para añadir articulos");
    System.out.println("==============================================");
    System.out.print(codigoField);
    codigo = entradaEntero(codigoField);
    System.out.print("\nDescripcion: ");
    descripcion = teclado.nextLine();
    System.out.print("\nPrecio del producto: ");
    precioProducto = entradaFloat("Precio del producto");
    System.out.print("\nPrecio Envío: ");
    precioEnvio = entradaFloat("Precio del envío");
    System.out.print("\nTiempo de preparacion del envio (días) : ");
    tiempoPrepEnvio = entradaEntero("Tiempo total de preparación");

    Articulos articulo = new Articulos(codigo, descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);
    boolean resultado = controlador.addArticulos(articulo.getidArticulos(), descripcion, precioProducto, precioEnvio, tiempoPrepEnvio);

    if(resultado){
        System.out.println("==============================================");
        System.out.println("Se ha creado el articulo de forma correcta");
        System.out.println("==============================================");
        System.out.println(controlador.mostrarArticulo(codigo));
        System.out.println("@@");
    } else {
        System.out.println("No se ha podido crear el articulo");
    }
    }

    /**
     * Menú para la gestión de clientes
     *
     * @throws ValorObligatorioException
     * @throws ClienteException
     */
    private void showGestionClientes() throws TiposObligatoriosExcepciones, ClientesExcepciones {
        String nif;
        String nombre;
        String domicilio;
        String email;
        int tc;
        System.out.println("Menú para añadir clientes");
        System.out.println("==============================================");
        System.out.print("\nNIF: ");
        nif = teclado.nextLine();
        System.out.print("\nNombre: ");
        nombre = teclado.nextLine();
        System.out.print("\nDomicilio: ");
        domicilio = teclado.nextLine();
        System.out.print("\nEmail: ");
        email = teclado.nextLine();
        System.out.print("\nTipo de Cliente: ");
        System.out.print("\n1. Selecciona si es Estandar");
        System.out.print("\n2. Selecciona si es Premium");
        System.out.println("\nIntroduce un tipo");
        tc = entradaEntero("Tipo de Cliente");

        if (tc < 1 || tc > 2) {
            throw new ClientesExcepciones("El tipo de cliente es incorrecto, por favor, intentelo de nuevo"); //Error si el tipo cliente no coincide
        }
        controlador.addClientes(nombre, domicilio, nif, email, tc);
        System.out.println("==============================================");
        System.out.println("El cliente ha sido creado de forma correcta");
        System.out.println("==============================================");
        System.out.println(controlador.mostrarCliente(nif));
        System.out.println("@@");
    }

    /**
     * Menú para la gestión de pedidos
     *
     * @throws FechaException
     * @throws ValorObligatorioException
     * @throws ArticuloException
     * @throws ClienteException
     * @throws ParseException
     */
    private void showGestionPedidos() throws FechaExcepcion, TiposObligatoriosExcepciones, ClientesExcepciones, ArticulosExcepciones {
        String nif;
        int codigo;
        int cantidad;
        Date fecPedido;
        int idPedido;
        final String codArtField = "Codigo del articulo : ";
        final String cantidadField = "Cantidad: ";
        System.out.println("Añadir un pedido");
        System.out.println("==============================================");
        System.out.print("\nNIF del Cliente: ");
        nif = teclado.nextLine();
        System.out.print(codArtField);
        codigo = entradaEntero(codArtField);
        System.out.print(cantidadField);
        cantidad = entradaEntero(cantidadField);
        System.out.print("\nFecha Pedido (dd/mm/yyyy): ");

        // Error entrada fecha
        try {
            fecPedido = entradaFecha("dd/MM/yyyy");
        } catch (ParseException e) {
            throw new FechaExcepcion("No ha sido posible crear el pedido, la fecha no es valida\n El pedido no ha sido creado, intentelo de nuevo\n\n");
        }

        idPedido = controlador.addPedidos(nif, codigo, cantidad, fecPedido);
        System.out.println("==============================================");
        System.out.println("El pedido ha sido creado de forma correcta");
        System.out.println("==============================================");
        System.out.println("Total Pedido : " + controlador.totalPedido(idPedido));
        System.out.println("@@");
    }

    private int entradaEntero(String valor) throws TiposObligatoriosExcepciones {
        String resp = teclado.nextLine();
        if (resp.isEmpty() || !controlador.isInteger(resp)) {
            throw new TiposObligatoriosExcepciones(valor); //Si no introduce valor o no es válido salta error
        }
        return Integer.parseInt(resp);
    }

    private float entradaFloat(String valor) throws TiposObligatoriosExcepciones {
        String resp = teclado.nextLine();
        if (resp.isEmpty() || !controlador.isFloat(resp)) {
            throw new TiposObligatoriosExcepciones(valor); //Si no introduce valor o no es válido salta error
        }
        return Float.parseFloat(resp);
    }

    private Date entradaFecha(String f) throws ParseException {
        String resp = teclado.nextLine();
        return new SimpleDateFormat(f).parse(resp);
    }
}
