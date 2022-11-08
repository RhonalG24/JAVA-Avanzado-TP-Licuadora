package licuadora.app.model.usuario;

public class Gestor implements Rol{


    @Override
    public Boolean esComprador() {
        return false;
    }

    @Override
    public Boolean esVendedor() {
        return false;
    }

    @Override
    public Boolean esGestor() {
        return true;
    }
}