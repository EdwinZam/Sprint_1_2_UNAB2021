package co.edu.unab.sprint.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unab.sprint.models.ProductoModel;
import co.edu.unab.sprint.services.ProductoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.DELETE, RequestMethod.GET, RequestMethod.POST})
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ArrayList<ProductoModel>obtenerProducto(){
        return productoService.obtenerProductos();
    }

    @PostMapping()
    public ProductoModel guardarProductos(@RequestBody ProductoModel producto) {        
        return productoService.guardarProducto(producto);
    }
    
    @DeleteMapping(path = "/{id}")
    public String eliminarProductos(@PathVariable("id") String id){
        if(productoService.eliminarProducto(id)){
            return "Se elimino el Producto con la ID " +id;
        }else{
            return "No existe el Producto Con la ID";
        }
    }

    @GetMapping(path = "/{id}") //consulta por ID
    public Optional<ProductoModel> obtenerProductoPorId(@PathVariable("id") String id){
        return productoService.obetnerPorId(id);
    }

    @GetMapping(path = "/nombre/{nombre}") //consulta por Nombre
    public ArrayList<ProductoModel> obtenerProductoPorNombre(@PathVariable("nombre") String nombre){
        return productoService.obtenerPorNombre(nombre);
    }
    
    @GetMapping(path = "/categoria/{categoria}") //consulta por categoria
    public ArrayList<ProductoModel> obtenerProductoPorCategoria(@PathVariable("categoria") String categoria){
        return productoService.obtenerPorCategoria(categoria);
    }

    @GetMapping(path = "/contiene/{nombre}") //consulta cuyo nombre contenga cierta cadena
    public ArrayList<ProductoModel> obtenerProductoPorNombreContiene(@PathVariable("nombre") String nombre){
        return productoService.obtenerPorNombreContiene(nombre);
    }

    @GetMapping(path = "/precio/{precioinicial}/{preciofinal}") //consulta cuyo nombre contenga cierta cadena
    public ArrayList<ProductoModel> obtenerProductoPorPrecioEntre(@PathVariable("precioinicial") Long precioinicial, @PathVariable("preciofinal") Long preciofinal){
        return productoService.obteberPorPrecioEntre(precioinicial, preciofinal);
    }

}
