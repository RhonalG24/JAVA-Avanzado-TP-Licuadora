package licuadora.app.model.usuario;

import licuadora.app.exceptions.NoEsGestorException;
import licuadora.app.exceptions.NoEsVendedorException;
import licuadora.app.exceptions.NoPuedeAgregarAlCarritoException;
import licuadora.app.model.producto.AreaPersonalizacion;
import licuadora.app.model.producto.GrupoTipoPersonalizacion;
import licuadora.app.model.producto.ProductoBase;
import licuadora.app.model.producto.ProductoPersonalizado;
import licuadora.app.model.tienda.Publicacion;
import licuadora.app.model.tienda.Tienda;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.type.LocalDateTimeType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
public class UsuarioBase {
    private String usuario;
    private String contraseñ;
    private Rol rol;

    public UsuarioBase(){
        super();
    }

    public void agregarAlCarrito(Publicacion publicacion) throws NoPuedeAgregarAlCarritoException {
        if(this.rol.esComprador()){
            try{
                publicacion.agregarAlCarrito(publicacion);
            }catch(NoPuedeAgregarAlCarritoException e){
                e.getMessage();
            }
        }

    }

    public Publicacion crearPublicacion(Tienda tienda, String nombre, ProductoPersonalizado producto) throws NoEsVendedorException {
        if(this.rol.esVendedor()){
            Vendedor aux = new Vendedor();
            Publicacion publicacion = aux.crearPublicacion(tienda, nombre, producto);
            return publicacion;
        }else {
            throw new NoEsVendedorException("Error");
        }

    };

    public ProductoBase crearProductoBase(String nombre, Double precio, String descripcion, Integer tiempoFabricacion) throws NoEsGestorException {
        if(this.rol.esGestor()){
            ProductoBase producto = new ProductoBase(nombre, precio,descripcion, tiempoFabricacion);
            return producto;
        }else {
            throw new NoEsGestorException("Error");
        }
    }

    public void addPosibleAreaPersonalizacion(ProductoBase producto, AreaPersonalizacion area, GrupoTipoPersonalizacion grupo) throws NoEsGestorException {
        if(this.rol.esGestor()){
            producto.getPosiblesAreasPersonalizacion().put(area, grupo);
        }else {
            throw new NoEsGestorException("Error");
        }
    }

    public void realizarCompra(Tienda tienda){
        Double precioTotal = tienda.getCarrito().getPrecio();
        try{
            pagar(precioTotal);
        }catch(Exception e){
            e.getMessage();
        }



    }

    private void pagar(Double precioTotal) {
    }


}
