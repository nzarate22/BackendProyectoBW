package com.example.BackendProyectoBW.Controladores;

import com.example.BackendProyectoBW.Entidades.Ingrediente;
import com.example.BackendProyectoBW.Servicios.ServicioIngrediente;
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
@RequestMapping("/ingrediente")
public class ControladorIngrediente {

    @Autowired
    ServicioIngrediente sIngrediente;

    @GetMapping("")
    public List<Ingrediente> obtTodosIngredientes() {
        return sIngrediente.obtenerTodosIngredientes();
    }

    @GetMapping("/buscarUno")
    public Ingrediente obtUnIngrediente(@RequestParam int id) {
        return sIngrediente.obtenerUnIngrediente(id);
    }

    @PostMapping("")
    public List<Ingrediente> agregarIngrediente(@RequestBody Ingrediente i) {
        if (sIngrediente.agregarIngrediente(i)) {
            return obtTodosIngredientes();
        }
        return null;
    }

    @PutMapping("")
    public List<Ingrediente> modificarIngrediente(@RequestBody Ingrediente i) {
        if (sIngrediente.modificarIngrediente(i)) {
            return obtTodosIngredientes();
        }
        return null;
    }

    @DeleteMapping("")
    public List<Ingrediente> eliminarIngrediente(@RequestParam int id) {
        if (sIngrediente.eliminarIngrediente(id)) {
            return obtTodosIngredientes();
        }
        return null;
    }

    @GetMapping("/buscarPorNombre")
    public List<Ingrediente> buscarPorNombre(@RequestParam String nombre) {
        return sIngrediente.buscarPorNombre(nombre);
    }
}
