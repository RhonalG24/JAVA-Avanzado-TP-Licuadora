package licuadora.app.exceptions;

public class NoEsVendedorException extends Exception {
    public NoEsVendedorException(String message){
        super("Debe ser un vendedor para realizar esta accion: " + message);

    }
}
