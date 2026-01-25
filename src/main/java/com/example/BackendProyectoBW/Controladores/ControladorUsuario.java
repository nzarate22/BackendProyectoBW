package com.example.BackendProyectoBW.Controladores;

import com.example.BackendProyectoBW.Entidades.Usuario;
import com.example.BackendProyectoBW.Servicios.ServicioUsuario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class ControladorUsuario {

    @Autowired
    ServicioUsuario sUsuario;

    @GetMapping("")
    public List<Usuario> obtTodosUsuarios() {
        return sUsuario.obtenerTodosUsuarios();
    }

    @GetMapping("/buscarUno")
    public Usuario obtUnUsuario(@RequestParam int id) {
        return sUsuario.obtenerUnUsuario(id);
    }

    @PostMapping("")
    public List<Usuario> agregarUsuario(@RequestBody Usuario u) {
        if (sUsuario.agregarUsuario(u)) {
            return obtTodosUsuarios();
        }
        return null;
    }

    @PutMapping("")
    public List<Usuario> modificarUsuario(@RequestBody Usuario u) {
        if (sUsuario.modificarUsuario(u)) {
            return obtTodosUsuarios();
        }
        return null;
    }

    @DeleteMapping("")
    public List<Usuario> eliminarUsuario(@RequestParam int id) {
        if (sUsuario.eliminarUsuario(id)) {
            return obtTodosUsuarios();
        }
        return null;
    }

    @GetMapping("/login")
    public Usuario login(@RequestParam String user, @RequestParam String pass) {
        return sUsuario.login(user, pass);
    }
}
