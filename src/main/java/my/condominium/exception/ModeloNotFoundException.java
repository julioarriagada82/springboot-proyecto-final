package my.condominium.exception;

public class ModeloNotFoundException extends RuntimeException {

	public ModeloNotFoundException(String mensaje) {
		super(mensaje);
	}
}
