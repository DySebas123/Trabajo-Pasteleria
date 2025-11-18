package com.mdw.controller;

import com.mdw.model.Empleado;
import com.mdw.service.EmpleadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoService.listar());
        model.addAttribute("nuevoEmpleado", new Empleado());
        return "empleados/empleadoListar";
    }

    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("nuevoEmpleado") Empleado empleado, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("empleados", empleadoService.listar());
            model.addAttribute("nuevoEmpleado", empleado);
            return "empleados/empleadoListar";
        }
        empleadoService.guardar(empleado);
        return "redirect:/empleados";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        empleadoService.eliminar(id);
        return "redirect:/empleados";
    }
}
