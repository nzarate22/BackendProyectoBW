package com.example.BackendProyectoBW.Repositorios;

import com.example.BackendProyectoBW.Entidades.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPedido extends JpaRepository<Pedido, Integer> {

    //Para gráficas (Suma total de un día específico)
    @Query(value = "SELECT SUM(total) FROM pedido WHERE DATE(fecha_hora) = ?1", nativeQuery = true)
    public Double ventasPorDia(String fecha);

    //Para reportes (Ventas entre dos fechas)
    @Query(value = "SELECT * FROM pedido WHERE fecha_hora BETWEEN ?1 AND ?2", nativeQuery = true)
    public List<Pedido> ventasEntreFechas(String inicio, String fin);

    //Para buscar pedido por el nombre del cliente
    @Query(value = "SELECT p.* FROM pedido p JOIN cliente c ON p.id_cliente = c.id_cliente WHERE c.nombre LIKE %?1%", nativeQuery = true)
    public List<Pedido> buscarPedidoPorNombreCliente(String nombre);
}
