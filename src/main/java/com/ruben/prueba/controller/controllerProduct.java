package com.ruben.prueba.controller;

import com.ruben.prueba.model.Producto;
import com.ruben.prueba.services.ServicesProducts;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class controllerProduct {

    private ServicesProducts productServices;

    // CONSTRUCTOR
    public controllerProduct(ServicesProducts productServices){
        this.productServices = productServices;
    }

    @GetMapping("/prueba") // HOLA MUNDO
    public String p(Model model){
        model.addAttribute("str", "Mundo");
        return "prueba";
    }

    @GetMapping("/prueba1/{str}/{id}") // PathVariable
    public String p1(@PathVariable String str, @PathVariable int id, Model model){
        model.addAttribute("persona", str);
        model.addAttribute("id", id);
        return "prueba1";
    }

    @GetMapping("/prueba2/{str}/{id}/{cod}") // PathVariable avanzado
    public String p2(@PathVariable String str,
                     @PathVariable int id,
                     @PathVariable String cod,
                     Model model){
        model.addAttribute("str", str);
        model.addAttribute("id", id);
        model.addAttribute("cod", cod);
        return "prueba2";
    }

    @GetMapping("/producto/{id}") // Acceso a datos mediante query
    public String product(@PathVariable int id, Model model) {
        Producto p = productServices.findById(id);
        if(p!=null){
            model.addAttribute("productId", p.getId());
            model.addAttribute("productName", p.getNombre());
            model.addAttribute("productPrice", p.getPrecio());
            return "producto";
        }else{
            return "noProducto";
        }
    }

    @GetMapping("/productos") // Acceso a datos mediante query (List)
    public String productList(Model model){
        List<Producto> productos = productServices.getAllProduct();
        model.addAttribute("productos", productos);
        return "productosList"; // implementacion de stylo mediante css y bootstrap
    }

    @GetMapping("/productos/registro")
    public String formProduct(Model model){
        model.addAttribute("product", new Producto());
        return "registroProducto";
    }

    @PostMapping("/productos/registro")
    public Object  saveProduct(@ModelAttribute("p") Producto producto){
        productServices.save(producto);
        return new RedirectView("/productos");
    }

}