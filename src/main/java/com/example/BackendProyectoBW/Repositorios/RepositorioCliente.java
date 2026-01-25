package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCliente extends JpaRepository<Cliente, Integer> {

    //PARA BUSCAR UN CLIENTE POR SU NUMERO DE TELEFONO
    @Query(value = "SELECT * FROM cliente WHERE telefono = ?1", nativeQuery = true)
    public Cliente buscarTelefono(String tel);
}
