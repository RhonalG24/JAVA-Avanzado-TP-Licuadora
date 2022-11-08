package licuadora.app.repository.tienda;

import licuadora.app.model.tienda.Tienda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "tienda")
public interface RepoTienda extends JpaRepository<Tienda, Long> {
}
