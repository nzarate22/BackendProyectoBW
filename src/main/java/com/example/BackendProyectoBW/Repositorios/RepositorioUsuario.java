package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer> {

    //PARA EL INICIO DE SESIÓN 
    @Query(value = "SELECT * FROM usuario WHERE usuario = ?1 AND contrasena = ?2", nativeQuery = true)
    public Usuario login(String user, String pass);

}
