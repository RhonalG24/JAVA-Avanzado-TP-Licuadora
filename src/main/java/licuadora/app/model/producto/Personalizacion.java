package licuadora.app.model.producto;

import licuadora.app.model.Costeable;
import licuadora.app.model.Persistente;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "personalizacion")
public class Personalizacion extends Persistente implements Costeable {

    @Column(name = "nombre")
    private String nombre;


    @ManyToOne
    @JoinColumn(name = "tipo_id", referencedColumnName = "id")
    private TipoPersonalizacion tipo;

    @Column(name = "contenido")
    private String contenido;

    @Column(name = "precio")
    private Double precio;

    public Personalizacion() {
        super();
    }

    public Personalizacion(String nombre, TipoPersonalizacion tipo, String contenido, Double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.contenido = contenido;
        this.precio = precio;
    }

    @Override
    public Double getPrecio() {
        return this.precio;
    }
}
