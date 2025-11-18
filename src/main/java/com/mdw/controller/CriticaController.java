package com.mdw.controller;

import com.mdw.model.Critica;
import com.mdw.service.CriticaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/criticas")
public class CriticaController {

    @Autowired
    private CriticaService criticaService;

    @GetMapping
    public String mostrarCriticas(Model model) {
        model.addAttribute("listaCriticas", criticaService.listarTodas());
        model.addAttribute("nuevaCritica", new Critica());
        return "criticas/lista"; // Vista Thymeleaf
    }

    @PostMapping("/guardar")
    public String guardarCritica(@Valid @ModelAttribute("nuevaCritica") Critica critica,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("listaCriticas", criticaService.listarTodas());
            return "criticas/lista";
        }
        criticaService.guardar(critica);
        return "redirect:/criticas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCritica(@PathVariable Integer id) {
        criticaService.eliminar(id);
        return "redirect:/criticas";
    }
}
