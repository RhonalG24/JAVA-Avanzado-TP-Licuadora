package licuadora.app.model.usuario;

import licuadora.app.exceptions.NoEsVendedorException;
import licuadora.app.model.producto.ProductoPersonalizado;
import licuadora.app.model.tienda.Publicacion;
import licuadora.app.model.tienda.Tienda;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Vendedor implements Rol{

    @Override
    public Boolean esComprador() {
        return false;
    }

    @Override
    public Boolean esVendedor() {
        return true;
    }

    @Override
    public Boolean esGestor() {
        return false;
    }

    public Publicacion crearPublicacion(Tienda tienda, String nombre, ProductoPersonalizado producto){

            LocalDate fecha = LocalDate.now();
            LocalTime hora = LocalTime.now();
            LocalDateTime fechaCompleta = LocalDateTime.of(fecha, hora);

            Publicacion publicacion = new Publicacion(tienda, nombre, producto, fechaCompleta);

            tienda.getPublicaciones().add(publicacion);

            return publicacion;
    };
}