package licuadora.app.model.producto;

import licuadora.app.exceptions.PersonalizacionInvalidaException;
import licuadora.app.model.Costeable;
import licuadora.app.model.Persistente;
import licuadora.app.model.tienda.Publicacion;
import licuadora.app.model.tienda.Tienda;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class ProductoPersonalizado extends Persistente implements Costeable {

    @ManyToOne
    @JoinColumn(name = "producto_base_id", referencedColumnName = "id")
    private ProductoBase productoBase;


    @ManyToOne
    @JoinColumn(name = "publicacion_id", referencedColumnName = "id")
    private Publicacion publicacion;

    @OneToMany
    private List<AreaPersonalizacion> areasPersonalizacion;


    public ProductoPersonalizado() {
        super();
        this.areasPersonalizacion = new ArrayList<AreaPersonalizacion>();
    }

    public ProductoPersonalizado(ProductoBase productoBase) {
        this();
        this.productoBase = productoBase;

    }

    public void addPersonalizacion(AreaPersonalizacion area, Personalizacion personalizacion) throws PersonalizacionInvalidaException{
        if(!this.productoBase.puedePersonalizar(area, personalizacion)){
            throw new PersonalizacionInvalidaException("No puede añadir esta personalizacion a este producto", area.getNombre());
        }
        area.setPersonalizacion(personalizacion);
        this.addAreaPersonalizacion(area);
    }

    public void removePersonalizacion(AreaPersonalizacion area){

        this.areasPersonalizacion.remove(area);
    }

    public void addAreaPersonalizacion(AreaPersonalizacion area){
        this.areasPersonalizacion.add(area);
    }

    public void removeAreaPersonalizacion(AreaPersonalizacion area){
        this.areasPersonalizacion.remove(area);
    }



    @Override
    public Double getPrecio() {
        Double precioTotal = 0.0;
        precioTotal += productoBase.getPrecio();
        for(Costeable area : areasPersonalizacion){
            precioTotal += area.getPrecio();
        }
        return precioTotal;
    }
}