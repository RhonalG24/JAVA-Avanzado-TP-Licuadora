package licuadora.app.repository.producto;

import licuadora.app.model.producto.AreaPersonalizacion;
import licuadora.app.model.producto.GrupoTipoPersonalizacion;
import licuadora.app.model.producto.TipoPersonalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "grupo_tipo_personalizacion")
public interface RepoGrupoTipoPersonalizacion extends JpaRepository<GrupoTipoPersonalizacion, Long> {


}