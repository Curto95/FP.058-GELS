package gels.zap.throwable;

public class ValorObligatorioException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 12L;
	
	public ValorObligatorioException(String valor) {
		super("El valor " + valor + " ES OBLIGATORIO!!");
	}
	

}
