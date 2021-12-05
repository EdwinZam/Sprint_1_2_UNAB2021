package co.edu.unab.sprint.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;

import co.edu.unab.sprint.models.ProductoModel;

public interface ProductoRepository extends MongoRepository <ProductoModel, String > {
    
    ArrayList<ProductoModel> findByNombre (String nombre);
    ArrayList<ProductoModel> findByCategoria (String categoria);
    ArrayList<ProductoModel> findByNombreContaining (String nombre);
    ArrayList<ProductoModel> findByPrecioBetween(Long precioinicial, Long preciofinal);
    
}
