package co.edu.unab.sprint.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unab.sprint.models.ProductoModel;
import co.edu.unab.sprint.repositories.ProductoRepository;

@Service
public class ProductoService {
   @Autowired
   ProductoRepository productoRepository;
   public ArrayList<ProductoModel> obtenerProductos(){
       return (ArrayList<ProductoModel>)productoRepository.findAll(); 
   }

   public ProductoModel guardarProducto(ProductoModel producto){
       return productoRepository.save(producto);
   }

   public boolean eliminarProducto(String id){
    if(productoRepository.existsById(id)){
        productoRepository.deleteById(id);
        return true;
    }else{
        return false;
    }
   }

   public Optional<ProductoModel> obetnerPorId(String id){
       return productoRepository.findById(id);
   }

   public ArrayList<ProductoModel> obtenerPorNombre(String nombre){
        return productoRepository.findByNombre(nombre);
    }

    public ArrayList<ProductoModel> obtenerPorCategoria(String categoria){
        return productoRepository.findByCategoria(categoria);
    }

    public ArrayList<ProductoModel> obtenerPorNombreContiene(String nombre){
        return productoRepository.findByNombreContaining(nombre);
    }

    public ArrayList<ProductoModel> obteberPorPrecioEntre(Long precioinicial, Long preciofinal){
        return productoRepository.findByPrecioBetween(precioinicial, preciofinal);
    }
}
