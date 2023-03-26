package com.ruben.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class prueba {

    @GetMapping("/prueba/{nombre}")
    public String welcomeDefault(@PathVariable String nombre, Model model){
        model.addAttribute("persona", nombre);
        return "prueba";
    }
}