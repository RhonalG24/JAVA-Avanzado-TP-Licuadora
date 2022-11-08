package licuadora.app;

import licuadora.app.repository.producto.RepoProductoBase;
import licuadora.app.repository.producto.RepoTipoPersonalizacion;
import licuadora.app.model.producto.TipoPersonalizacion;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AppLicuadora {

    public static void main(String[] args) {

        SpringApplication.run(AppLicuadora.class, args);


    }

    @Bean //algo que el main va a ejecutar en orden de aparicion
    public CommandLineRunner init(RepoProductoBase repoProdBase, RepoTipoPersonalizacion repoTipoPers){//otra forma de tomar el repo
        return (pepe) -> {
            /*
            ProductoBase prBase = new ProductoBase();
            prBase.setNombre("Remesa");
            prBase.setDescripcion("Remera lisa.");
            prBase.setPrecioBase(200.0);
            prBase.setPosiblesAreasPersonalizacion(dorso, new HashSet<TipoPersonalizacion>()[new TipoPersonalizacion()]);
            repoProdBase.save(new ProductoBase())*/
            repoTipoPers.save(new TipoPersonalizacion("imagen"));
        };
    }
}