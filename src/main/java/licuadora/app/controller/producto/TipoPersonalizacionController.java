package licuadora.app.controller.producto;

import licuadora.app.model.producto.TipoPersonalizacion;
import licuadora.app.repository.producto.RepoTipoPersonalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/tipo_personalizacion")
public class TipoPersonalizacionController {
    @Autowired
    RepoTipoPersonalizacion repoTipoPers;

    @GetMapping("")
    public Page<TipoPersonalizacion> allTipoPersonalizacion(Pageable page){

        return repoTipoPers.findAll(page);
    }

    @GetMapping("/{id}")
    public Optional<TipoPersonalizacion> findTipoPersonalizacionById(@PathVariable(value = "id") Long id){ //PathVariable para decirle que tome esa variable
        return repoTipoPers.findById(id);
    }

    @GetMapping("/{nombre}")
    public TipoPersonalizacion findTipoPersonalizacionByNombre(@PathVariable(value = "nombre") String nombre){ //PathVariable para decirle que tome esa variable
        return repoTipoPers.findByNombre(nombre);
    }

    @PostMapping("")
    public TipoPersonalizacion createTipoPersonalizacion(@RequestBody TipoPersonalizacion tipoPersonalizacion){
        return repoTipoPers.save(tipoPersonalizacion);
    }

    @PutMapping("/{id}")
    public TipoPersonalizacion updateTipoPersonalizacion(@PathVariable("id") Long id, @RequestBody TipoPersonalizacion tipoPersonalizacion){
        return repoTipoPers.save(tipoPersonalizacion);
    }

    @DeleteMapping("/{id}")
    public void deleteTipoPersonalizacion(@PathVariable("id") Long id){
        repoTipoPers.deleteById(id);
    }
}
