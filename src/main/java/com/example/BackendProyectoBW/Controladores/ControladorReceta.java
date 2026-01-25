package com.example.BackendProyectoBW.Controladores;

import com.example.BackendProyectoBW.Entidades.Receta;
import com.example.BackendProyectoBW.Servicios.ServicioReceta;
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
@RequestMapping("/receta")
public class ControladorReceta {

    @Autowired
    ServicioReceta sReceta;

    @GetMapping("")
    public List<Receta> obtTodasRecetas() {
        return sReceta.obtenerTodasRecetas();
    }

    @GetMapping("/buscarUno")
    public Receta obtUnaReceta(@RequestParam int id) {
        return sReceta.obtenerUnaReceta(id);
    }

    @PostMapping("")
    public List<Receta> agregarReceta(@RequestBody Receta r) {
        if (sReceta.agregarReceta(r)) {
            return obtTodasRecetas();
        }
        return null;
    }

    @PutMapping("")
    public List<Receta> modificarReceta(@RequestBody Receta r) {
        if (sReceta.modificarReceta(r)) {
            return obtTodasRecetas();
        }
        return null;
    }

    @DeleteMapping("")
    public List<Receta> eliminarReceta(@RequestParam int id) {
        if (sReceta.eliminarReceta(id)) {
            return obtTodasRecetas();
        }
        return null;
    }
}
