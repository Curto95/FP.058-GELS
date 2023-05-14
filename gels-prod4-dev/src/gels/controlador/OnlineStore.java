package gels.controlador;

import gels.vista.GestionOS;


public class OnlineStore {
	
	public static void main(String[] args) {
		GestionOS gestion;
		try {
			gestion = new GestionOS();
			gestion.inicio();			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
