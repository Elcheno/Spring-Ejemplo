package com.ruben.prueba.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name="carrito")
public class CarritoCompra implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.INTEGER)
    private int id;

    @Column(name = "nombre")
    @JdbcTypeCode(SqlTypes.VARCHAR)
    private String nombre;

    @Column(name = "precio", nullable = false)
    @JdbcTypeCode(SqlTypes.FLOAT)
    private int precio;

    @ManyToMany
    @JoinTable(name = "carrito_productoes",
            joinColumns = @JoinColumn(name = "carrito_compra_id"),
            inverseJoinColumns = @JoinColumn(name = "productoes_id"))
    private List<Producto> productoes = new ArrayList<>();

}
