package com.ruben.prueba.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class prueba {

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

}