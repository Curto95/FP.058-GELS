package gels.vista;


import gels.zap.throwable.ClienteException;
import gels.zap.throwable.ValorObligatorioException;
import gels.zap.throwable.DbConnectionException;
import gels.vista.utils.Entrada;
import gels.controlador.Controlador;
import gels.vista.form.GestionArticulos;
import gels.vista.form.GestionClientes;
import gels.vista.form.GestionPedidos;

/**
 * 
 * @author jSectarios
 * Producto 4: Realizar un programa en Java en modo de consola que gestione la permanencia de datos mediante ORM
 * 			   En este producto se gestiona mediante hibernate-jpa
 */
public class GestionOS {
	private Controlador controlador;	
	private GestionArticulos gestArt;
	private GestionPedidos gestPedidos;
	private GestionClientes gestClientes;
	private Entrada in;

	
	public GestionOS() throws Exception {
		in = new Entrada();
		controlador = new Controlador();
		gestArt = new GestionArticulos();
		gestPedidos = new GestionPedidos();
		gestClientes = new 	GestionClientes();
	
	}
	
	public void inicio() {
		boolean salir = false;
		char opcio;
		do {
			System.out.println("1. Gestion Articulos");
			System.out.println("2. Gestion Clientes");
			System.out.println("3. Gestion Pedidos");
			System.out.println("0. Salir");
			opcio = in.pedirOpcion();
			switch (opcio) {
				case '1':
					try {
						gestArt.showGestionArticulos();
					} catch (ValorObligatorioException | DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '2':
					try {
						gestClientes.showGestionClientes();
					} catch (ValorObligatorioException | ClienteException | DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '3':					
					try {
						gestPedidos.showGestionPedidos();
					}
					catch (Exception  e) {
						System.out.println(e.getMessage()); //Se muestra el error
					}
					
					break;			
				case '0':
					salir = true;
			}
		} while (!salir);
		controlador.close(); //Cierra conexion
	}

}
