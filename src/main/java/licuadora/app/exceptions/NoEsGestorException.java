package licuadora.app.exceptions;

public class NoEsGestorException extends Exception {
    public NoEsGestorException(String error) {
        super("Debe ser un gestor del sitio para realizar esta accion." + error);
    }
}
