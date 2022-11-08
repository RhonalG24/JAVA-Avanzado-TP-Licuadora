package licuadora.app.model.tienda;

import licuadora.app.model.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "tienda")
public class Tienda extends Persistente {

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @OneToMany(mappedBy = "tienda")
    private List<Publicacion> publicaciones;

    @Transient
    private CarritoCompras carrito;

    public Tienda(){
        super();
        this.publicaciones = new ArrayList<Publicacion>();
        carrito = new CarritoCompras(this.getId());
    }

    public void addPublicacion(Publicacion publicacion){
        this.publicaciones.add(publicacion);
        publicacion.setTienda(this);
    }

    public void agregarAlCarrito(Publicacion publicacion){
        this.carrito.agregarAlCarrito(publicacion);
    }
    public void eliminarDelCarrito(Publicacion publicacion){
        this.carrito.eliminarDelCarrito(publicacion);
    }
}
