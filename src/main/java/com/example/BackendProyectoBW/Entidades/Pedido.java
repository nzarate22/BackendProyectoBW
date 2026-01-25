package com.example.BackendProyectoBW.Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //LINEA PARA HACER EL ID AUTOINCREMENTABLE
    private Integer idPedido;
    private LocalDateTime fechaHora;
    private double total;
    private String estado;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idCliente")
    private Cliente cliente;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL,fetch=FetchType.EAGER) // SE OCUPA mappedBy PARA QUE NO SE CREE OTRA TABLA, PARA QUE SPRING VAYA DIRECTO A LA TABLA DetallePedido. ONE TO MANY ES DE UNO A MUCHOS. EL cascade = CascadeType.ALL ES PARA QUE LAS OPERACIONES QUE SE REALICEN SOBRE EL OBJETO PADRE SE REPLIQUEN AUTOMATICAMENTE SOBRE TODOS LOS OBJETOS HIJOS (COMO EFECTO DOMINÓ)
    private List<DetallePedido> detalles;

    public Pedido() {
    }

    public Pedido(Integer idPedido, LocalDateTime fechaHora, double total, String estado, Cliente cliente, Usuario usuario, List<DetallePedido> detalles) {
        this.idPedido = idPedido;
        this.fechaHora = fechaHora;
        this.total = total;
        this.estado = estado;
        this.cliente = cliente;
        this.usuario = usuario;
        this.detalles = detalles;
    }

    public Integer getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Integer idPedido) {
        this.idPedido = idPedido;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
    
    

}
