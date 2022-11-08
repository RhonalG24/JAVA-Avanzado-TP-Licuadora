package licuadora.app.exceptions;

public class NoPuedeAgregarAlCarritoException extends Exception {



    public NoPuedeAgregarAlCarritoException(String message){
        super("No puede agregar al carrito. Estado de la publiacion: " + message);

    }
}
