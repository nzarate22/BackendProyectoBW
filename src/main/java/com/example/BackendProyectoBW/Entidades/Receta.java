package com.example.BackendProyectoBW.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //LINEA PARA HACER EL ID AUTOINCREMENTABLE
    private Integer idReceta;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idProducto")
    @JsonBackReference
    private Producto producto;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "idIngrediente")
    private Ingrediente ingrediente;
    private double cantidadUtilizada;

    public Receta() {
    }

    public Receta(Integer idReceta, Producto producto, Ingrediente ingrediente, double cantidadUtilizada) {
        this.idReceta = idReceta;
        this.producto = producto;
        this.ingrediente = ingrediente;
        this.cantidadUtilizada = cantidadUtilizada;
    }

    public Integer getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Integer idReceta) {
        this.idReceta = idReceta;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getCantidadUtilizada() {
        return cantidadUtilizada;
    }

    public void setCantidadUtilizada(double cantidadUtilizada) {
        this.cantidadUtilizada = cantidadUtilizada;
    }
    
    
}
