package licuadora.app.repository.producto;

import licuadora.app.model.producto.AreaPersonalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "area")
public interface RepoAreaPersonalizacion extends JpaRepository<AreaPersonalizacion, Long> {
    List<AreaPersonalizacion> findByNombre(@Param("nombre")String nombre);

}
