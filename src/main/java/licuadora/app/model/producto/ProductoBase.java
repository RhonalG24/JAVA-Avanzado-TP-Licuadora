package licuadora.app.model.producto;

import licuadora.app.model.Costeable;
import licuadora.app.model.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "producto_base")
public class ProductoBase extends Persistente implements Costeable {

    @Column(name = "nombre")
    private String nombre;

    @Column(name="precio")
    private Double precio;
    @Column(name = "descripcion")
    private String descripcion;

    @Column(name="tiempo_fabricacion")
    private Integer tiempoFabricacion;

    @OneToMany
    private Map<AreaPersonalizacion, GrupoTipoPersonalizacion> posiblesAreasPersonalizacion;
    /*@OneToMany
    private Map<Long, HashSet<Long>> posiblesAreasPersonalizacion;*/


    public ProductoBase(){
        super();
        posiblesAreasPersonalizacion = new HashMap<AreaPersonalizacion, GrupoTipoPersonalizacion>();
        /*posiblesAreasPersonalizacion = new HashMap<Long, HashSet<Long>>();*/
    }

    public ProductoBase(String nombre, Double precio, String descripcion, Integer tiempoFabricacion) {
        this();
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.tiempoFabricacion = tiempoFabricacion;
    }

    @Override
    public Double getPrecio() {
        return precio;
    }
/*
    public Boolean puedePersonalizar(AreaPersonalizacion area, Personalizacion personalizacion){
        if(!this.getPosiblesAreasPersonalizacion().containsKey(area)){
            return false;
        }else if(!this.getPosiblesAreasPersonalizacion().get(area).contains(personalizacion.getTipo())){
            return false;
        }
        return true;
    }*/

    public Boolean puedePersonalizar(AreaPersonalizacion area, Personalizacion personalizacion){
        if(!this.getPosiblesAreasPersonalizacion().containsKey(area)){
            return false;
        }else if(!this.getPosiblesAreasPersonalizacion().get(area).getListadoTipoPersonalizacion().contains(personalizacion.getTipo())){
            return false;
        }
        return true;
    }
}
