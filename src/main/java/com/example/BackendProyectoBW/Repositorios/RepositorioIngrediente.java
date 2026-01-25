package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.Ingrediente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioIngrediente extends JpaRepository<Ingrediente, Integer> {

    //Para buscar el ingrediente por su nombre
    @Query(value = "SELECT * FROM ingrediente WHERE nombre LIKE %?1%", nativeQuery = true)
    public List<Ingrediente> buscarIngredientePorNombre(String nombre);
}
