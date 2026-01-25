package com.example.BackendProyectoBW.Controladores;

import com.example.BackendProyectoBW.Entidades.Cliente;
import com.example.BackendProyectoBW.Servicios.ServicioCliente;
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
@RequestMapping("/cliente")
public class ControladorCliente {

    @Autowired
    ServicioCliente sCliente;

    @GetMapping("")
    public List<Cliente> obtTodosClientes() {
        return sCliente.obtenerTodosClientes();
    }

    @GetMapping("/buscarUno")
    public Cliente obtUnCliente(@RequestParam int id) {
        return sCliente.obtenerUnCliente(id);
    }

    @PostMapping("")
    public List<Cliente> agregarCliente(@RequestBody Cliente c) {
        if (sCliente.agregarCliente(c)) {
            return obtTodosClientes();
        }
        return null;
    }

    @PutMapping("")
    public List<Cliente> modificarCliente(@RequestBody Cliente c) {
        if (sCliente.modificarCliente(c)) {
            return obtTodosClientes();
        }
        return null;
    }

    @DeleteMapping("")
    public List<Cliente> eliminarCliente(@RequestParam int id) {
        if (sCliente.eliminarCliente(id)) {
            return obtTodosClientes();
        }
        return null;
    }

    @GetMapping("/buscarPorTelefono")
    public Cliente buscarPorTelefono(@RequestParam String tel) {
        return sCliente.buscarClientePorTelefono(tel);
    }
}
