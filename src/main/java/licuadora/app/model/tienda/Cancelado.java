package licuadora.app.model.tienda;

public class Cancelado implements EstadoPublicacion {

    @Override
    public Boolean puedeAgregarAlCarrito() {
        return false;
    }

    @Override
    public Boolean puedeSacarDelCarrito() {
        return true;
    }

    @Override
    public String toString() {
        return "cancelado";
    }
}