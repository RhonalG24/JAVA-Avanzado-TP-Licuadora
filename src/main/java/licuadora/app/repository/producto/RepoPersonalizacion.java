package licuadora.app.repository.producto;

import licuadora.app.model.producto.GrupoTipoPersonalizacion;
import licuadora.app.model.producto.Personalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "personalizacion")
public interface RepoPersonalizacion extends JpaRepository<Personalizacion, Long> {
}