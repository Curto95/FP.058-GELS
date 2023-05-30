package gels.vista.form;

import java.util.List;

import gels.controlador.Controlador;
import gels.vista.data.ClienteView;
import gels.vista.data.ClienteView.TClienteView;
import gels.vista.utils.Entrada;
import gels.zap.throwable.ClienteException;
import gels.zap.throwable.DbConnectionException;
import gels.zap.throwable.ValorObligatorioException;

public class GestionClientes {
	private Entrada in;
	private Controlador controlador;	
	
	public GestionClientes() throws Exception {
		in = new Entrada();
		controlador = new Controlador();
	}
	
	public void showGestionClientes() throws ValorObligatorioException, DbConnectionException, ClienteException{
		boolean salir = false;
		char opcio;
		do {
			System.out.println("------------------------------------");
			System.out.println("  Menu Clientes             ");
			System.out.println("------------------------------------");
			System.out.println("1. Ver Clientes");
			System.out.println("2. Añadir Clientes");
			System.out.println("3. Modificar Clientes");
			System.out.println("4. Eliminar Clientes");
			System.out.println("0. Salir");
			opcio = in.pedirOpcion();
			switch (opcio) {
				case '1':
					try {
						showVerClientes();
					} catch (DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '2':
					try {
						this.showAddCliente();
					} catch (ValorObligatorioException |  DbConnectionException e1) {
						System.out.println(e1.getMessage()); //Se muestra el error
					}
					break;
				case '3':					
					try {
						showUpdateCliente();
					}
					catch (Exception  e) {
						System.out.println(e.getMessage()); //Se muestra el error
					}
					
					break;						
				case '4':					
					try {
						showRemoveCliente();
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
	/**
	 * Pantalla para  gestiÃ³n clientes
	 * @throws ValorObligatorioException 
	 * @throws ClienteException 
	 * @throws DbConnectionException 
	 */
	public void showAddCliente() throws ValorObligatorioException, ClienteException, DbConnectionException {
		
	    String nif;
	    String nombre;
	    String domicilio;
	    String email;
	    int t;
	    
		System.out.println("==============================================");
		System.out.println("AÑ ADIR CLIENTES");
		System.out.println("==============================================");
		System.out.print("\nNIF: ");
		nif = in.entradaString();
		System.out.print("\nNombre: ");
		nombre = in.entradaString();
		System.out.print("\nDomicilio: ");
		domicilio = in.entradaString();
		System.out.print("\nEmail: ");
		email = in.entradaString();
		System.out.print("\nTipos Cliente: ");
		System.out.print("\n1. ESTANDARD");
		System.out.print("\n2. PREMIUM");
		System.out.println("\nIntroduce un tipo");
		t = in.entradaEntero("Tipo Cliente");
		
		if (t<1 || t > 2) throw new ClienteException("Tipo de Cliente incorrecto, NO SE CREA NADA"); //Error si no son los tipos
		
		controlador.addClientes(nombre, domicilio, nif, email, t);
		
		System.out.println("==============================================");		
		System.out.println("CLIENTE CREADO");
		System.out.println("==============================================");
		System.out.println(controlador.mostrarCliente(nif));
		System.out.println("##");
		
	}
	
	/**
	 * Actualiza un Item
	 * @throws ValorObligatorioException
	 * @throws DbConnectionException
	 * @throws ClienteException
	 */
	
	private void showUpdateCliente() throws ValorObligatorioException, DbConnectionException, ClienteException{
	    String nif;
	    String nombre;
	    String domicilio;
	    String email;
	    int t;
	    ClienteView cv;

		System.out.println("==============================================");    
		System.out.println("ACTUALIZAR CLIENTES");
		System.out.println("==============================================");
		System.out.print("\nNIF: ");
		nif = in.entradaString();
    	
		cv = controlador.showCliente(nif);
		System.out.print("\nNombre: " + cv.getNombre());
		System.out.println("\nNuevo valor: ");
		nombre = in.entradaString();		
		if (nombre != null) cv.setNombre(nombre);
		
		System.out.print("\nDomicilio: " + cv.getDomicilio());

		System.out.println("\nNuevo valor: ");
		domicilio = in.entradaString();		
		if (domicilio!= null) cv.setDomicilio(domicilio);
		
		System.out.print("\nEmail: " + cv.getEmail());
		System.out.println("\nNuevo valor: ");
		email = in.entradaString();
		if (email!= null) cv.setEmail(email);

		System.out.print("\nTipos Cliente: ");
		System.out.print("\n1. ESTANDARD");
		System.out.print("\n2. PREMIUM");
		
		System.out.print("\nTipos Cliente Actual: " + cv.getTipoCliente().name());

		System.out.println("\nIntroduce nuevo tipo");
		t = in.entradaEntero("Tipo Cliente");
		

    	if (t==1) cv.setTipoCliente(TClienteView.ESTANDARD);
    	else if (t==2) cv.setTipoCliente(TClienteView.PREMIUM);
    	else throw new ClienteException("Tipo de Cliente incorrecto, NO SE ACTUALIZA NADA"); //Error si no son los tipos
     	
		System.out.println("==============================================");
		
    	if (controlador.actualizarCliente(cv)) 
    		System.out.println("CLIENTE MODIFICADO");
    	else
    		System.out.println("ERROR EN ACTUALIZACION DE CLIENTE");
    	
		System.out.println("==============================================");
		
		System.out.println(controlador.mostrarCliente(nif));
		System.out.println("##");
	}
	
	/**
	 * Elimina un cliente
	 * @throws ValorObligatorioException
	 * @throws DbConnectionException
	 */
	
	private void showRemoveCliente() throws ValorObligatorioException, DbConnectionException {
	    String codigo;
		System.out.println("==============================================");
		System.out.println("ELIMINAR CLIENTES");
		System.out.println("==============================================");
    	System.out.print("\nNIF a eliminar: ");
    	codigo = in.entradaString();      	
    	
		System.out.println("\n==============================================");
		
    	if (controlador.eliminarCliente(codigo)) 
    		System.out.println("CLIENTE ELIMINADO");
    	else
    		System.out.println("ERROR EN ELIMINACIÃ“N DEL CLIENTE");
    	
		System.out.println("==============================================");
	}
	
	
	/**
	 * Muestra lista de clientes
	 * @throws DbConnectionException
	 */
	
	private void showVerClientes() throws DbConnectionException {
		System.out.println("\n==============================================");
		System.out.println("LISTA CLIENTES");
		System.out.println("==============================================");
      	
    	List<ClienteView> listaClientes = controlador.obtenerClientes();
		for (ClienteView av : listaClientes) {
			System.out.println(av.toString());
			}
		

    	
		System.out.println("==============================================");

	}
	
}
