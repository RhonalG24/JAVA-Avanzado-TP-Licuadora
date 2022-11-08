package licuadora.app.controller.producto;

import licuadora.app.model.producto.GrupoTipoPersonalizacion;
import licuadora.app.model.producto.TipoPersonalizacion;
import licuadora.app.repository.producto.RepoGrupoTipoPersonalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/grupo_tipo_personalizacion")
public class GrupoTipoPersonalizacionController {
    @Autowired
    RepoGrupoTipoPersonalizacion repoGrupoTipoPersonalizacion;

    @GetMapping("")
    public Page<GrupoTipoPersonalizacion> allGrupoTipoPersonalizacion(Pageable page){

        return repoGrupoTipoPersonalizacion.findAll(page);
    }


    @PostMapping("")
    public GrupoTipoPersonalizacion createGrupoTipoPersonalizacion(@RequestBody GrupoTipoPersonalizacion grupoTipoPersonalizacion){
        return repoGrupoTipoPersonalizacion.save(grupoTipoPersonalizacion);
    }

    @PutMapping("/{id}")
    public GrupoTipoPersonalizacion updateGrupoTipoPersonalizacion(@PathVariable("id") Long id, @RequestBody GrupoTipoPersonalizacion grupoTipoPersonalizacion){
        return repoGrupoTipoPersonalizacion.save(grupoTipoPersonalizacion);
    }

    @DeleteMapping("/{id}")
    public void deleteGrupoTipoPersonalizacion(@PathVariable("id") Long id){
        repoGrupoTipoPersonalizacion.deleteById(id);
    }
}


