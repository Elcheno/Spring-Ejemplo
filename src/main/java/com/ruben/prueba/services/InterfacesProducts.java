package com.ruben.prueba.services;

import com.ruben.prueba.model.Producto;
import java.util.List;

public interface InterfacesProducts {

    List<Producto> getAllProduct();
    public Producto findById(int Id);

}
