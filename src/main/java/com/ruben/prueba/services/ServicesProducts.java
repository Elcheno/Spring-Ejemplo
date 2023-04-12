package com.ruben.prueba.services;

import com.ruben.prueba.model.Producto;
import com.ruben.prueba.repository.RepositoryProduct;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesProducts implements InterfacesProducts{

    private RepositoryProduct productRepository;

    public ServicesProducts(RepositoryProduct repositoryProduct){
        this.productRepository = repositoryProduct;
    }

    @Override
    public List<Producto> getAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public Producto findById(int id) {
        return productRepository.findById(id);
    }

    public void save(Producto product){productRepository.save(product);}
}
