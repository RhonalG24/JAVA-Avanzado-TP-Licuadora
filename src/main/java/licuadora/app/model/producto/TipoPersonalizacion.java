package licuadora.app.model.producto;

import licuadora.app.model.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Entity
public class TipoPersonalizacion extends Persistente {


    @NotBlank
    @Column(name = "nombre", nullable = false)
    private String nombre;

    public TipoPersonalizacion(){
        super();
    }

    public TipoPersonalizacion(String nombre){
        super();
        this.nombre = nombre;
    }

//'texto, imagen color, imagen blanco y
 //       'negro, emoji, entre otros.
}