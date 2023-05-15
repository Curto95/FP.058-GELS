package gels.vista.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import gels.controlador.Controlador;
import gels.zap.throwable.ValorObligatorioException;

/**
 * Clase Entrada para control de interaccion teclado usuario
 * @author antonio-cesar.flores
 *
 */

public class Entrada {
	Scanner teclado;
	private Controlador controlador;
	
	public Entrada() throws Exception {
		controlador = new Controlador();
		teclado = new Scanner(System.in);		
	}
	
	public char pedirOpcion() {
		String resp;
		System.out.println("Elige una opcion: ");
		resp = teclado.nextLine();
		if (resp.isEmpty()) {
		resp = " ";
		}
		return resp.charAt(0);
	}
	
	public Scanner getTeclado() {
		return teclado;
	}
	
	public String entradaString() {
		return teclado.nextLine();
	}
	
    public int entradaEntero()  {
    	String resp = teclado.nextLine();
        return Integer.parseInt(resp);
    }
	
	
    public int entradaEntero(String valor) throws ValorObligatorioException {
    	String resp = teclado.nextLine();
        if (resp.isEmpty() || !controlador.isInteger(resp)) {
            throw new ValorObligatorioException(valor); //Si no introduce valor o no es válido salta error
        }
        return Integer.parseInt(resp);
    }
    
    public float entradaFloat()  {
    	String resp = teclado.nextLine();
        return Float.parseFloat(resp);
    }
    public float entradaFloat(String valor) throws ValorObligatorioException {
    	String resp = teclado.nextLine();
        if (resp.isEmpty() || !controlador.isFloat(resp)) {
            throw new ValorObligatorioException(valor); //Si no introduce valor o no es válido salta error
        }
        return Float.parseFloat(resp);
    }
    
    public Date entradaFecha(String f) throws ParseException {
    	String resp = teclado.nextLine();
		return new SimpleDateFormat(f).parse(resp);
    }
}
