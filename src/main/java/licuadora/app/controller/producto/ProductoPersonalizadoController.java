package licuadora.app.controller.producto;

import licuadora.app.repository.producto.RepoProductoPersonalizado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producto_personalizado")
public class ProductoPersonalizadoController {
    @Autowired
    RepoProductoPersonalizado repoProductoPersonalizado;
}
