package licuadora.app.model.producto;

import licuadora.app.model.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "grupo_tipo_personalizacion")
public class GrupoTipoPersonalizacion extends Persistente {

    @OneToMany
    private List<TipoPersonalizacion> listadoTipoPersonalizacion;

    public GrupoTipoPersonalizacion(){
        listadoTipoPersonalizacion = new ArrayList<TipoPersonalizacion>();
    }


}
