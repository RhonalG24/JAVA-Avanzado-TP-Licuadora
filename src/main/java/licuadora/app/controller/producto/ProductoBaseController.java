package licuadora.app.controller.producto;


import licuadora.app.model.producto.ProductoBase;
import licuadora.app.model.producto.TipoPersonalizacion;
import licuadora.app.repository.producto.RepoProductoBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/producto_base")
public class ProductoBaseController {
    @Autowired
    RepoProductoBase repoProductoBase;

    @GetMapping("")
    public Page<ProductoBase> allProductoBase(Pageable page){

        return repoProductoBase.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<ProductoBase> findProductoBaseById(@PathVariable(value = "id") Long id){ //PathVariable para decirle que tome esa variable
        return repoProductoBase.findById(id);
    }

    @GetMapping("/{nombre}")
    public ProductoBase findProductoBaseByNombre(@PathVariable(value = "nombre") String nombre){ //PathVariable para decirle que tome esa variable
        return repoProductoBase.findByNombre(nombre);
    }

    @PostMapping("")
    public ProductoBase createTipoPersonalizacion(@RequestBody ProductoBase productoBase){
        return repoProductoBase.save(productoBase);
    }

    @PutMapping("/{id}")
    public ProductoBase updateProductoBase(@PathVariable("id") Long id, @RequestBody ProductoBase productoBase){
        return repoProductoBase.save(productoBase);
    }

    @DeleteMapping("/{id}")
    public void deleteProductoBase(@PathVariable("id") Long id){
        repoProductoBase.deleteById(id);
    }

}
