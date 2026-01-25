
package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioReceta extends JpaRepository<Receta, Integer> {
    
}
