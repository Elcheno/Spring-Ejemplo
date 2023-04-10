package com.ruben.prueba.repository;

import com.ruben.prueba.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RepositoryProduct extends JpaRepository<Producto, Long> {

    @Query(value = "SELECT * FROM products", nativeQuery = true)
    public List<Producto> findAll();

    @Query(value = "SELECT * FROM products WHERE ID = ?1", nativeQuery = true)
    public Producto findById(int id);

}
