package licuadora.app.exceptions;

public class PersonalizacionInvalidaException extends Exception {
    private final String tipoError;
    private final String nombre;

    public String getTipoError() {
        return tipoError;
    }

    public String getNombre() {
        return nombre;
    }

    public PersonalizacionInvalidaException(String string, String nombre) {
        super();
        this.tipoError = string;
        this.nombre = nombre;
    }
}
