package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Cliente;
import com.example.BackendProyectoBW.Repositorios.RepositorioCliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioCliente {

    @Autowired
    RepositorioCliente rCliente;

    public List<Cliente> obtenerTodosClientes() {
        return rCliente.findAll();
    }

    public Cliente obtenerUnCliente(int id) {
        Optional<Cliente> a = rCliente.findById(id);
        return a.orElse(null);
    }

    public boolean agregarCliente(Cliente c) {
        boolean respuesta;
        try {
            rCliente.save(c);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificarCliente(Cliente c) {
        boolean respuesta;
        try {
            rCliente.save(c);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean eliminarCliente(int id) {
        boolean respuesta;
        try {
            rCliente.deleteById(id);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public Cliente buscarClientePorTelefono(String tel) {
        return rCliente.buscarTelefono(tel);
    }
}
