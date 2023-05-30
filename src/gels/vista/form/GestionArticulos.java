package gels.vista.form;

import gels.vista.utils.Entrada;
import java.util.List;
import gels.controlador.Controlador;
import gels.vista.data.ArticuloView;
import gels.zap.throwable.ArticuloException;
import gels.zap.throwable.DbConnectionException;
import gels.zap.throwable.ValorObligatorioException;

/**
 * Clase para mostrar la gestion de Articulos
 * @author antonio-cesar.flores
 *
 */

public class GestionArticulos {
	
	private Entrada in;
	private Controlador controlador;	
	
	public GestionArticulos() throws Exception {
		in = new Entrada();
		controlador = new Controlador();
	}
	
	/**
	 * Pantalla para gesti√≥n art√≠culos
	 * @throws ValorObligatorioException 
	 * @throws DbConnectionException 
	 */

	
	public void showGestionArticulos() throws ValorObligatorioException, DbConnectionException{
		boolean salir = false;
		char opcio;
		do {
			System.out.println("------------------------------------");
			System.out.println("  Menu arti≠culos                   ");
			System.out.println("------------------------------------");
			System.out.println("1. Ver Articulos");
			System.out.println("2. AÒadir Arti≠culos");
			System.out.println("3. Modificar Articulos");
			System.out.println("4. Eliminar Articulos");
			System.out.println("0. Salir");
			opcio = in.pedirOpcion();
			switch (opcio) {
				case '1':
					try {
						showVerArticulos();
					} catch (DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '2':
					try {
						this.showAddItem();
					} catch (ValorObligatorioException |  DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '3':					
					try {
						showUpdateItem();
					}
					catch (Exception  e) {
						System.out.println(e.getMessage()); //Se muestra el error
					}
					
					break;						
				case '4':					
					try {
						showRemoveItem();
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
	
	private void showAddItem() throws ValorObligatorioException, DbConnectionException{
	    int codigo;
	    String descripcion;
	    float pvp;
	    float precioEnvio;
	    int tiempoPrepEnvio;
	    final String codigoField = "Codigo : "; //el texto del codigo articulo
	    
		System.out.println("AÒadir Articulos");
		System.out.println("==============================================");
    	System.out.print(codigoField);
    	codigo = in.entradaEntero(codigoField);
		System.out.print("\nDescripcion: ");
		descripcion = in.entradaString();
		System.out.print("\nPVP: ");
		pvp = in.entradaFloat("PVP");
		System.out.print("\nPrecio Envi≠o: ");
		precioEnvio = in.entradaFloat("Precio Envi≠o");	
    	System.out.print("\nTiempo Preparacion Envi≠o (di≠as) : ");
    	tiempoPrepEnvio = in.entradaEntero("Tiempo Preparacion");
    	
		controlador.addArticulos(codigo, descripcion, pvp, precioEnvio, tiempoPrepEnvio);
		
		System.out.println("==============================================");		
		System.out.println("ARTICULO CREADO");
		System.out.println("==============================================");
		
		System.out.println(controlador.mostrarArticulo(codigo));
		System.out.println("##");
	}
	
	/**
	 * Actualiza un Item
	 * @throws ValorObligatorioException
	 * @throws DbConnectionException
	 * @throws ArticuloException
	 */
	
	private void showUpdateItem() throws ValorObligatorioException, DbConnectionException{
	    int codigo;
	    String descripcion=null;
	    float pvp;
	    float precioEnvio;
	    int tiempoPrepEnvio;
	    final String codigoField = "Codigo a modificar: "; //el texto del codigo articulo
	    ArticuloView av;
	    
		System.out.println("ACTUALIZAR ARTICULOS");
		System.out.println("==============================================");
    	System.out.print(codigoField);
    	codigo = in.entradaEntero(codigoField);
    	
		av = controlador.mostrarArticulo(codigo);
		System.out.print("\nDescripcion: " + av.getDescripcion());
		System.out.println("\nNuevo valor: ");
		descripcion = in.entradaString();
		if (descripcion != null) av.setDescripcion(descripcion);
		System.out.print("\nPVP: " + av.getPvp());
		System.out.print("\nNuevo Precio:");
		pvp = in.entradaFloat();
		av.setPvp(pvp);
		System.out.print("\nPrecio Envi≠o: " + av.getPrecioEnvio());
		System.out.print("\nNuevo Precio Envi≠o: ");	
		precioEnvio = in.entradaFloat();	
		av.setPrecioEnvio(precioEnvio);
    	System.out.print("\nTiempo Preparacion envi≠o (di≠as) : " + av.getTiempoPrepEnvio());
		System.out.print("\nNuevo Tiempo preparacion");
    	tiempoPrepEnvio = in.entradaEntero();
    	av.setTiempoPrepEnvio(tiempoPrepEnvio);
    	
    	
		System.out.println("==============================================");
		
    	if (controlador.actualizarArticulo(av)) 
    		System.out.println("ARTICULO MODIFICADO");
    	else
    		System.out.println("ERROR EN ACTUALIZACION DE ARTICULO");
    	
		System.out.println("==============================================");
		
		System.out.println(controlador.mostrarArticulo(codigo));
		System.out.println("##");
	}
	
	private void showRemoveItem() throws ValorObligatorioException, DbConnectionException {
	    int codigo;

	    final String codigoField = "Codigo a eliminar: "; //el texto del codigo articulo

		System.out.println("ELIMINAR ARTICULOS");
		System.out.println("==============================================");
    	System.out.print(codigoField);
    	codigo = in.entradaEntero(codigoField);
      	
    	
		System.out.println("\n==============================================");
		
    	if (controlador.eliminarArticulo(codigo)) 
    		System.out.println("ARTICULO ELIMINADO");
    	else
    		System.out.println("ERROR EN ELIMINACION DE ARTICULO");
    	
		System.out.println("==============================================");

	}
	
	private void showVerArticulos() throws DbConnectionException {


		System.out.println("LISTA ARTICULOS");
		System.out.println("==============================================");
      	
    	List<ArticuloView> listaArticulos = controlador.obtenerArticulos();
		for (ArticuloView av : listaArticulos) {
			System.out.println(av.toString());
			}
		

    	
		System.out.println("==============================================");

	}
	

}
