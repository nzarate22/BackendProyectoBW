package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Usuario;
import com.example.BackendProyectoBW.Repositorios.RepositorioUsuario;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioUsuario {

    @Autowired
    RepositorioUsuario rUsuario;

    public List<Usuario> obtenerTodosUsuarios() {
        return rUsuario.findAll();
    }

    public Usuario obtenerUnUsuario(int id) {
        Optional<Usuario> a = rUsuario.findById(id);
        return a.orElse(null);
    }

    public boolean agregarUsuario(Usuario u) {
        boolean respuesta;
        try {
            rUsuario.save(u);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificarUsuario(Usuario u) {
        boolean respuesta;
        try {
            rUsuario.save(u);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean eliminarUsuario(int id) {
        boolean respuesta;
        try {
            rUsuario.deleteById(id);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public Usuario login(String user, String pass) {
        return rUsuario.login(user, pass);
    }
}
