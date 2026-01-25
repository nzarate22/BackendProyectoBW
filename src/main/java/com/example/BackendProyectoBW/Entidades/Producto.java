package com.example.BackendProyectoBW.Entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //LINEA PARA HACER EL ID AUTOINCREMENTABLE
    private Integer idProducto;
    private String nombreCombo;
    private String descripcion;
    private double precio;
    private int maxSalsas;
    @OneToMany(mappedBy = "producto", fetch=FetchType.EAGER) // SE OCUPA mappedBy PARA QUE NO SE CREE OTRA TABLA, PARA QUE SPRING VAYA DIRECTO A LA TABLA RECETA. ONE TO MANY ES DE UNO A MUCHOS
    private List<Receta> ingredientesReceta;

    public Producto() {
    }

    public Producto(Integer idProducto, String nombreCombo, String descripcion, double precio, int maxSalsas, List<Receta> ingredientesReceta) {
        this.idProducto = idProducto;
        this.nombreCombo = nombreCombo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.maxSalsas = maxSalsas;
        this.ingredientesReceta = ingredientesReceta;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreCombo() {
        return nombreCombo;
    }

    public void setNombreCombo(String nombreCombo) {
        this.nombreCombo = nombreCombo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getMaxSalsas() {
        return maxSalsas;
    }

    public void setMaxSalsas(int maxSalsas) {
        this.maxSalsas = maxSalsas;
    }

    public List<Receta> getIngredientesReceta() {
        return ingredientesReceta;
    }

    public void setIngredientesReceta(List<Receta> ingredientesReceta) {
        this.ingredientesReceta = ingredientesReceta;
    }
    
    
}
