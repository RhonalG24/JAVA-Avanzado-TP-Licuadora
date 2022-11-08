package licuadora.app.repository.producto;

import licuadora.app.model.producto.TipoPersonalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tipo_personalizacion")
public interface RepoTipoPersonalizacion extends JpaRepository<TipoPersonalizacion, Long> {
    TipoPersonalizacion findByNombre(@Param("nombre") String nombre);
}
