package licuadora.app.model.tienda;
import licuadora.app.model.Costeable;
import licuadora.app.model.Persistente;
import licuadora.app.model.producto.ProductoPersonalizado;
import licuadora.app.exceptions.NoPuedeAgregarAlCarritoException;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "publicacion")
public class Publicacion extends Persistente implements Costeable{

    @ManyToOne
    @JoinColumn(name = "tienda_id", referencedColumnName = "id")
    private Tienda tienda;

    @Column(name = "nombre")
    private String nombre;

    @OneToOne
    @JoinColumn(name = "producto_id", referencedColumnName = "id")
    private ProductoPersonalizado producto;

    @Transient
    private EstadoPublicacion estado; //'(publicado, pausado, cancelado, finalizado),

    @Column(name ="estado_actual")
    private String estadoActual;

    @Column(name = "fecha_publicacion")
    private LocalDateTime fechaPublicacion;

    public Publicacion(){
        super();
        setEstado(new Publicado());
    }

    public Publicacion(Tienda tienda, String nombre, ProductoPersonalizado producto, LocalDateTime fechaPublicacion) {
        this();
        this.tienda = tienda;
        this.nombre = nombre;
        this.producto = producto;
        this.estadoActual = estadoActual;
        this.fechaPublicacion = fechaPublicacion;
        setEstadoByEstadoActual();
    }

    public Publicacion(Tienda tienda, String nombre, ProductoPersonalizado producto, String estadoActual, LocalDateTime fechaPublicacion) {
        this.tienda = tienda;
        this.nombre = nombre;
        this.producto = producto;
        this.estadoActual = estadoActual;
        this.fechaPublicacion = fechaPublicacion;
        setEstadoByEstadoActual();
    }

    public void setEstadoByEstadoActual(){
        switch (this.estadoActual){
            case "pausado":
                setEstado(new Pausado());
                break;
            case "cancelado":
                setEstado(new Cancelado());
                break;
            case "finalizado":
                setEstado(new Finalizado());
                break;
            default:
                setEstado(new Publicado());
                break;

        }
    }

    public void setEstado(EstadoPublicacion estado){
        this.estado = estado;
        this.estadoActual = estado.toString();
    }

    public void setProducto(ProductoPersonalizado producto) {
        this.producto = producto;
        producto.setPublicacion(this);
    }

    @Override
    public Double getPrecio() {

        return this.producto.getPrecio();
    }

    public void agregarAlCarrito(Publicacion publicacion) throws NoPuedeAgregarAlCarritoException{
        if(!this.estado.puedeAgregarAlCarrito()){
            throw new NoPuedeAgregarAlCarritoException(this.estado.toString());
        }
        this.getTienda().agregarAlCarrito(this);

    }

    public void eliminarDelCarrito(Publicacion publicacion){
        this.getTienda().eliminarDelCarrito(this);
    }
}
