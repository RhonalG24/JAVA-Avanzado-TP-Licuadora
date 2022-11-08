package licuadora.app.model.tienda;

import licuadora.app.model.Costeable;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CarritoCompras implements Costeable {
    private Long idTienda;

    List<Costeable> items;

    public CarritoCompras(Long idTienda){
        this.idTienda = idTienda;
        items = new ArrayList<Costeable>();
    }

    public void agregarAlCarrito(Publicacion publicacion){
        items.add(publicacion.getProducto());
    }

    public void eliminarDelCarrito(Publicacion publicacion){
        items.remove(publicacion.getProducto());
    }

    @Override
    public Double getPrecio() {
        Double precioTotal = 0.0;

        for(Costeable item : items){
            precioTotal += item.getPrecio();
        }

        return precioTotal;
    }
}
