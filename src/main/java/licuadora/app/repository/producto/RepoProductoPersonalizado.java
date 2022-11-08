package licuadora.app.repository.producto;

import licuadora.app.model.producto.Personalizacion;
import licuadora.app.model.producto.ProductoPersonalizado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "producto_personalizado")
public interface RepoProductoPersonalizado extends JpaRepository<ProductoPersonalizado, Long> {
}