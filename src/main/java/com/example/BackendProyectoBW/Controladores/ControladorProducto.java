package com.example.BackendProyectoBW.Controladores;

import com.example.BackendProyectoBW.Entidades.Producto;
import com.example.BackendProyectoBW.Servicios.ServicioProducto;
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
@RequestMapping("/producto")
public class ControladorProducto {

    @Autowired
    ServicioProducto sProducto;

    @GetMapping("")
    public List<Producto> obtTodosProductos() {
        return sProducto.obtenerTodosProductos();
    }

    @GetMapping("/buscarUno")
    public Producto obtUnProducto(@RequestParam int id) {
        return sProducto.obtenerUnProducto(id);
    }

    @PostMapping("")
    public List<Producto> agregarProducto(@RequestBody Producto p) {
        if (sProducto.agregarProducto(p)) {
            return obtTodosProductos();
        }
        return null;
    }

    @PutMapping("")
    public List<Producto> modificarProducto(@RequestBody Producto p) {
        if (sProducto.modificarProducto(p)) {
            return obtTodosProductos();
        }
        return null;
    }

    @DeleteMapping("")
    public List<Producto> eliminarProducto(@RequestParam int id) {
        if (sProducto.eliminarProducto(id)) {
            return obtTodosProductos();
        }
        return null;
    }

    @GetMapping("/buscarPorNombre")
    public List<Producto> buscarPorNombre(@RequestParam String nombre) {
        return sProducto.buscarPorNombre(nombre);
    }
}
