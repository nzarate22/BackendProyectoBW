package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Producto;
import com.example.BackendProyectoBW.Repositorios.RepositorioProducto;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioProducto {

    @Autowired
    RepositorioProducto rProducto;

    public List<Producto> obtenerTodosProductos() {
        return rProducto.findAll();
    }

    public Producto obtenerUnProducto(int id) {
        Optional<Producto> a = rProducto.findById(id);
        return a.orElse(null);
    }

    public boolean agregarProducto(Producto p) {
        boolean respuesta;
        try {
            rProducto.save(p);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificarProducto(Producto p) {
        boolean respuesta;
        try {
            rProducto.save(p);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean eliminarProducto(int id) {
        boolean respuesta;
        try {
            rProducto.deleteById(id);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public List<Producto> buscarPorNombre(String nombre) {
        return rProducto.buscarProductoPorNombre(nombre);
    }
}
