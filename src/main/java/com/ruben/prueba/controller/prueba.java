package com.ruben.prueba.controller;

import com.ruben.prueba.model.Producto;
import com.ruben.prueba.services.ServicesProducts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class prueba {

    private ServicesProducts productServices;

    // CONSTRUCTOR
    public prueba(ServicesProducts productServices){
        this.productServices = productServices;
    }

    @GetMapping("/prueba")
    public String p(Model model){
        model.addAttribute("str", "Mundo");
        return "prueba";
    }

    @GetMapping("/prueba1/{str}/{id}")
    public String p1(@PathVariable String str, @PathVariable int id, Model model){
        model.addAttribute("persona", str);
        model.addAttribute("id", id);
        return "prueba1";
    }

    @GetMapping("/prueba2/{str}/{id}/{cod}")
    public String p2(@PathVariable String str,
                     @PathVariable int id,
                     @PathVariable String cod,
                     Model model){
        model.addAttribute("str", str);
        model.addAttribute("id", id);
        model.addAttribute("cod", cod);
        return "prueba2";
    }

    @GetMapping("/producto/{id}")
    public String home(@PathVariable int id, Model model) {
        Producto p = productServices.findById(id);
        model.addAttribute("productId", p.getId());
        model.addAttribute("productName", p.getNombre());
        model.addAttribute("productPrice", p.getPrecio());
        return "producto";
    }

}