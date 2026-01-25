package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Receta;
import com.example.BackendProyectoBW.Repositorios.RepositorioReceta;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioReceta {

    @Autowired
    RepositorioReceta rReceta;

    public List<Receta> obtenerTodasRecetas() {
        return rReceta.findAll();
    }

    public Receta obtenerUnaReceta(int id) {
        Optional<Receta> a = rReceta.findById(id);
        if (!a.isEmpty()) {
            return a.get();
        }
        return null;
    }

    public boolean agregarReceta(Receta r) {
        boolean respuesta;
        try {
            rReceta.save(r);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificarReceta(Receta r) {
        boolean respuesta;
        try {
            rReceta.save(r);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean eliminarReceta(int id) {
        boolean respuesta;
        try {
            rReceta.deleteById(id);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }
}
