
package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioDetallePedido extends JpaRepository<DetallePedido, Integer> {
    
}
