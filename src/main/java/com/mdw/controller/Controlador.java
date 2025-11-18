package com.mdw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Controlador {
    @GetMapping("/inicio")
    public String getInicio() {
        return "index";
    }
    
    @GetMapping("/carta")
    public String getCarta() {
        return "carta";
    }
    
    @GetMapping("/nosotros")
    public String getNosotros() {
        return "nosotros";
    }
    
    @GetMapping("/contacto")
    public String getContacto() {
        return "contactanos";
    }
}
