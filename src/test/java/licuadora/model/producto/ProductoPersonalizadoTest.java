package licuadora.model.producto;

import licuadora.app.exceptions.PersonalizacionInvalidaException;
import licuadora.app.model.producto.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class ProductoPersonalizadoTest {
    ProductoBase productoBase = new ProductoBase();
    TipoPersonalizacion tipo = new TipoPersonalizacion("Foto");
    TipoPersonalizacion tipo2 = new TipoPersonalizacion("Foto");

    Personalizacion personalizacion = new Personalizacion("TeddyBear", tipo, "teddy.jpg", 200.0);
    Personalizacion personalizacion2 = new Personalizacion("EmojiSmile", tipo, "emojiSmile.jpg", 150.0);
    AreaPersonalizacion area = new AreaPersonalizacion();
    AreaPersonalizacion area2 = new AreaPersonalizacion();

    GrupoTipoPersonalizacion tiposAceptados = new GrupoTipoPersonalizacion();


    @BeforeEach
    void setUp() {

        productoBase.setPrecio(500.0);
        tiposAceptados.getListadoTipoPersonalizacion().add(tipo);
        productoBase.getPosiblesAreasPersonalizacion().put(area, tiposAceptados);
        productoBase.getPosiblesAreasPersonalizacion().put(area2, tiposAceptados);

        //area.setPersonalizacion(personalizacion);
        //area2.setPersonalizacion(personalizacion2);


    }

    @Test
    void deberiaRetornar700ComoPrecioDelProductoPersonalizado() {
        ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();
        productoPersonalizado.setProductoBase(productoBase);
        try{
            productoPersonalizado.addPersonalizacion(area, personalizacion);
        }catch (PersonalizacionInvalidaException ex){
            ex.getMessage();
        }

        assertEquals(700.0, productoPersonalizado.getPrecio());
    }

    @Test
    void deberiaRetornar850ComoPrecioDelProductoPersonalizadoPorqueElProductoPoseeDosPersonalizaciones() {
        ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();
        productoPersonalizado.setProductoBase(productoBase);

        try{
            productoPersonalizado.addPersonalizacion(area, personalizacion);
            productoPersonalizado.addPersonalizacion(area2, personalizacion2);

        }catch (PersonalizacionInvalidaException e){
            e.getMessage();
        }
        assertEquals(850.0, productoPersonalizado.getPrecio());
    }

    @Test
    void deberiaRetornar650ComoPrecioDelProductoPersonalizadoPorqueElProductoPoseeDosPersonalizacionesYLuegoLeRemuevoUnaPersonalizacion() {
        ProductoPersonalizado productoPersonalizado = new ProductoPersonalizado();
        productoPersonalizado.setProductoBase(productoBase);
        try{
            productoPersonalizado.addPersonalizacion(area, personalizacion);
            productoPersonalizado.addPersonalizacion(area2, personalizacion2);
        }catch (PersonalizacionInvalidaException e){
            e.getMessage();
        }

        productoPersonalizado.removePersonalizacion(area);
        assertEquals(650.0, productoPersonalizado.getPrecio());
    }
}