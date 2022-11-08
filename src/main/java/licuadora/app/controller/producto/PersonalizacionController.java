package licuadora.app.controller.producto;


import licuadora.app.repository.producto.RepoPersonalizacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/personalizacion")
public class PersonalizacionController {
    @Autowired
    RepoPersonalizacion repoPersonalizacion;
}
