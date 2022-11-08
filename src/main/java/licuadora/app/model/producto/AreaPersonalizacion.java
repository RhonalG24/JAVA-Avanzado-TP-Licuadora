package licuadora.app.model.producto;

import licuadora.app.model.Costeable;
import licuadora.app.model.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "area_personalizacion")
public class AreaPersonalizacion extends Persistente implements Costeable {

    @Column(name = "nombre")
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "personalizacion_id", referencedColumnName = "id")
    private Personalizacion personalizacion;

    @Override
    public Double getPrecio() {
        if(this.personalizacion == null){
            return 0.0;
        }
        return this.personalizacion.getPrecio();
    }


}