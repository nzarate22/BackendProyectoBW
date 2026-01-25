package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Pedido;
import com.example.BackendProyectoBW.Repositorios.RepositorioPedido;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioPedido {

    @Autowired
    RepositorioPedido rPedido;

    public List<Pedido> obtenerTodosPedidos() {
        return rPedido.findAll();
    }

    public Pedido obtenerUnPedido(int id) {
        Optional<Pedido> a = rPedido.findById(id);
        return a.orElse(null);
    }

    public boolean agregarPedido(Pedido p) {
        boolean respuesta;
        try {
            rPedido.save(p);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean modificarPedido(Pedido p) {
        boolean respuesta;
        try {
            rPedido.save(p);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public boolean eliminarPedido(int id) {
        boolean respuesta;
        try {
            rPedido.deleteById(id);
            respuesta = true;
        } catch (Exception ex) {
            respuesta = false;
        }
        return respuesta;
    }

    public Double obtenerTotalVentasDia(String fecha) {
        Double total = rPedido.ventasPorDia(fecha);
        return (total != null) ? total : 0.0;
    }

    public List<Pedido> obtenerVentasRango(String inicio, String fin) {
        return rPedido.ventasEntreFechas(inicio, fin);
    }

    public List<Pedido> buscarPedidosPorCliente(String nombre) {
        return rPedido.buscarPedidoPorNombreCliente(nombre);
    }
}
