package com.ruben.prueba.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.io.Serializable;

@Data //lombok
@Entity //marca que es una entidad
@Table(name="products") //indica que es una tabla y su nombre
public class Producto implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @JdbcTypeCode(SqlTypes.INTEGER)
    public int id;

    @Column(name="name", nullable=false)
    @JdbcTypeCode(SqlTypes.CHAR)
    public String nombre;

    @Column(name="price")
    @JdbcTypeCode(SqlTypes.FLOAT)
    public double precio;

}
