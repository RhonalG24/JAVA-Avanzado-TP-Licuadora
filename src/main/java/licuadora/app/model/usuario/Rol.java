package licuadora.app.model.usuario;

import licuadora.app.model.tienda.Publicacion;

public interface Rol {
    public Boolean esComprador();
    public Boolean esVendedor();
    public Boolean esGestor();
}
