package gels.vista.form;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import gels.controlador.Controlador;
import gels.vista.data.PedidoView;
import gels.vista.utils.Entrada;
import gels.zap.throwable.DbConnectionException;
import gels.zap.throwable.FechaException;
import gels.zap.throwable.ValorObligatorioException;

public class GestionPedidos {
	private Entrada in;
	private Controlador controlador;	
	
	public GestionPedidos() throws Exception {
		in = new Entrada();
		controlador = new Controlador();
	}
	
	/**
	 * Pantalla para  gesti√≥n pedidos
	 * @throws Exception 
	 * @throws ParseException 
	 */	
	public void showGestionPedidos() throws Exception{
		boolean salir = false;
		char opcio;
		do {
			System.out.println("------------------------------------");
			System.out.println("  Menu Pedidos             ");
			System.out.println("------------------------------------");
			System.out.println("1. Ver Pedidos");
			System.out.println("2. AÒadir Pedidos");
			System.out.println("3. Eliminar Pedido");
			System.out.println("4. Enviar Pedido");
			System.out.println("0. Salir");
			
			opcio = in.pedirOpcion();
			switch (opcio) {
				case '1':
					try {
						showVerPedidos();
					} catch (Exception e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '2':
					try {
						this.showAddPedido();
					} catch (ValorObligatorioException |  DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;				
				case '3':					
					try {
						showRemovePedido();
					}
					catch (Exception  e) {
						System.out.println(e.getMessage()); //Se muestra el error
					}					
					break;	
				case '4':					
					try {
						showEnviaPedido();
					}
					catch (Exception  e) {
						System.out.println(e.getMessage()); //Se muestra el error
					}					
					break;
				case '0':
					salir = true;
			}
		} while (!salir);
	}
	
	private void showVerPedidos() {
		System.out.println("\n==============================================");
		System.out.println("LISTA PEDIDOS");
		System.out.println("==============================================");
      	
    	List<PedidoView> listaPedidos = controlador.obtenerPedidos();
		for (PedidoView pd : listaPedidos) {
			System.out.println(pd.toString());
			}	

    	
		System.out.println("==============================================");

	}
	
	
	private void showAddPedido() throws Exception  {
	    String nif;
	    int codigo;
	    int cantidad;
	    Date fecPedido;
	    long id_pedido;
	    final String codArtField = "Codigo Articulo : ";
	    final String cantidadField = "Cantidad: ";
	    
		System.out.println("==============================================");
		System.out.println("A—ADIR PEDIDOS");
		System.out.println("==============================================");	
		System.out.print("\nNIF Cliente: ");
		nif = in.entradaString();
    	System.out.print(codArtField);
    	codigo = in.entradaEntero(codArtField);
    	System.out.print(cantidadField);
    	cantidad = in.entradaEntero(cantidadField);
		System.out.print("\nFecha Pedido (dd/MM/yyyy): ");

		// Captura error entrada fecha
		try {
			fecPedido = in.entradaFecha("dd/MM/yyyy");		
		} catch (ParseException e) {
			throw new FechaException("Escribe una fecha valida, por favor te lo pido\n PEDIDO NO CREADO!\n\n");
		}  
		
		id_pedido = controlador.addPedidos(nif, codigo, cantidad, fecPedido);
		System.out.println("==============================================");
		System.out.println("PEDIDO CREADO");
		System.out.println("==============================================");	
		System.out.println("Total Pedido : " + controlador.totalPedido(id_pedido));
		System.out.println("##");
	}
	
	
	private void showRemovePedido() throws ValorObligatorioException, DbConnectionException {
	    int codigo;	    
		System.out.println("==============================================");
		System.out.println("ELIMINAR PEDIDO");
		System.out.println("==============================================");

      	codigo = getCodigo();
    	
		System.out.println("\n==============================================");
		
    	if (controlador.eliminarPedido(codigo)) 
    		System.out.println("PEDIDO ELIMINADO");
    	else
    		System.out.println("ERROR EN ELIMINACION DE PEDIDO");
    	
		System.out.println("==============================================");
	}
	
	private void showEnviaPedido() throws ValorObligatorioException, DbConnectionException {
	    int codigo;	    
		System.out.println("==============================================");
		System.out.println("ENVIAR PEDIDO");
		System.out.println("==============================================");

      	codigo = getCodigo();
    	
		System.out.println("\n==============================================");
		
    	if (controlador.enviarPedido(codigo)) 
    		System.out.println("PEDIDO ENVIADO");
    	else
    		System.out.println("ERROR EN EL ENVIO DE PEDIDO");
    	
		System.out.println("==============================================");
	}
	
	private int getCodigo() throws ValorObligatorioException {
	    final String codigoField = "Codigo"; //el texto del codigo pedido    	
	    System.out.print("Introduzca Codigo: ");
    	return in.entradaEntero(codigoField);
	}
}
