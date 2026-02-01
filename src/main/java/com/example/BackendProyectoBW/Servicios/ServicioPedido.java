package com.example.BackendProyectoBW.Servicios;

import com.example.BackendProyectoBW.Entidades.Pedido;
import com.example.BackendProyectoBW.Repositorios.RepositorioPedido;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.BackendProyectoBW.Entidades.DetallePedido;
import com.example.BackendProyectoBW.Entidades.Ingrediente;
import com.example.BackendProyectoBW.Entidades.Producto;
import com.example.BackendProyectoBW.Entidades.Receta;
import com.example.BackendProyectoBW.Repositorios.RepositorioIngrediente;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioPedido {

    @Autowired
    RepositorioPedido rPedido;

    @Autowired
    RepositorioIngrediente rIngrediente;

    public List<Pedido> obtenerTodosPedidos() {
        return rPedido.findAll();
    }

    public Pedido obtenerUnPedido(int id) {
        Optional<Pedido> a = rPedido.findById(id);
        return a.orElse(null);
    }

    @Transactional 
    public boolean agregarPedido(Pedido p) {
        try {
            rPedido.save(p);
            // 2. Lógica de Descuento de Inventario
            if (p.getDetalles() != null) {
                for (DetallePedido detalle : p.getDetalles()) {
                    Producto producto = detalle.getProducto();
                    int cantidadVendida = detalle.getCantidad();
                    List<Receta> recetas = producto.getIngredientesReceta();
                    if (recetas != null) {
                        for (Receta receta : recetas) {
                            Ingrediente ing = receta.getIngrediente();
                            double cantidadADescontar = receta.getCantidadUtilizada() * cantidadVendida;
                            double nuevoStock = ing.getStockActual() - cantidadADescontar;
                            ing.setStockActual(nuevoStock);
                            rIngrediente.save(ing);
                        }
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            System.err.println("Error al procesar pedido e inventario: " + ex.getMessage());
            return false;
        }
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
