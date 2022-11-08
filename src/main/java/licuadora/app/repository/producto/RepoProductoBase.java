package licuadora.app.repository.producto;

import licuadora.app.model.producto.ProductoBase;
import licuadora.app.model.producto.TipoPersonalizacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "producto_base")
public interface RepoProductoBase extends JpaRepository<ProductoBase, Long> {
    ProductoBase findByNombre(@Param("nombre") String nombre);

}
