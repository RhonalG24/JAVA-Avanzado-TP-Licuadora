package licuadora.app.model.usuario;

import licuadora.app.model.tienda.Publicacion;

public class Comprador implements Rol{


    @Override
    public Boolean esComprador() {
        return true;
    }

    @Override
    public Boolean esVendedor() {
        return false;
    }

    @Override
    public Boolean esGestor() {
        return false;
    }
}
