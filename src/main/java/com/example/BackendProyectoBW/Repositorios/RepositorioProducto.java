package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Integer> {

    //Para buscar el producto por su nombre 
    @Query(value = "SELECT * FROM producto WHERE nombre_combo LIKE %?1%", nativeQuery = true)
    public List<Producto> buscarProductoPorNombre(String nombre);
}
