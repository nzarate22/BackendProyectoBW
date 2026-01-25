package com.example.BackendProyectoBW.Controladores;

import com.example.BackendProyectoBW.Entidades.Pedido;
import com.example.BackendProyectoBW.Servicios.ServicioPedido;
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
@RequestMapping("/pedido")
public class ControladorPedido {

    @Autowired
    ServicioPedido sPedido;

    @GetMapping("")
    public List<Pedido> obtTodosPedidos() {
        return sPedido.obtenerTodosPedidos();
    }

    @GetMapping("/buscarUno")
    public Pedido obtUnPedido(@RequestParam int id) {
        return sPedido.obtenerUnPedido(id);
    }

    @PostMapping("")
    public List<Pedido> agregarPedido(@RequestBody Pedido p) {
        if (sPedido.agregarPedido(p)) {
            return obtTodosPedidos();
        }
        return null;
    }

    @PutMapping("")
    public List<Pedido> modificarPedido(@RequestBody Pedido p) {
        if (sPedido.modificarPedido(p)) {
            return obtTodosPedidos();
        }
        return null;
    }

    @DeleteMapping("")
    public List<Pedido> eliminarPedido(@RequestParam int id) {
        if (sPedido.eliminarPedido(id)) {
            return obtTodosPedidos();
        }
        return null;
    }

    @GetMapping("/graficaDia")
    public Double totalVentasDia(@RequestParam String fecha) { //En formato 2024-05-20
        return sPedido.obtenerTotalVentasDia(fecha);
    }

    @GetMapping("/reporteFechas")
    public List<Pedido> reporteEntreFechas(@RequestParam String inicio, @RequestParam String fin) {
        //En formato 2024-05-01 00:00:00 y 2024-05-31 23:59:59
        return sPedido.obtenerVentasRango(inicio, fin);
    }

    @GetMapping("/buscarPorCliente")
    public List<Pedido> buscarPorCliente(@RequestParam String nombre) {
        return sPedido.buscarPedidosPorCliente(nombre);
    }
}
