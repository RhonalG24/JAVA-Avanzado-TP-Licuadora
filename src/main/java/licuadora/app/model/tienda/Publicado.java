package licuadora.app.model.tienda;

public class Publicado implements EstadoPublicacion {

    @Override
    public Boolean puedeAgregarAlCarrito() {
        return true;
    }

    @Override
    public Boolean puedeSacarDelCarrito() {
        return true;
    }

    @Override
    public String toString() {
        return "publicado";
    }
}
