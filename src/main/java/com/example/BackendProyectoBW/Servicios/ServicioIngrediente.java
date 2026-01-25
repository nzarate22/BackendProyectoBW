package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Ingrediente;
import com.example.BackendProyectoBW.Repositorios.RepositorioIngrediente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioIngrediente {

    @Autowired
    RepositorioIngrediente rIngrediente;

    public List<Ingrediente> obtenerTodosIngredientes() {
        return rIngrediente.findAll();
    }

    public Ingrediente obtenerUnIngrediente(int id) {
        Optional<Ingrediente> a = rIngrediente.findById(id);
        return a.orElse(null);
    }

    public boolean agregarIngrediente(Ingrediente i) {
        boolean respuesta;
        try {
            rIngrediente.save(i);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificarIngrediente(Ingrediente i) {
        boolean respuesta;
        try {
            rIngrediente.save(i);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean eliminarIngrediente(int id) {
        boolean respuesta;
        try {
            rIngrediente.deleteById(id);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public List<Ingrediente> buscarPorNombre(String nombre) {
        return rIngrediente.buscarIngredientePorNombre(nombre);
    }
}
