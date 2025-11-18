package com.mdw.controller;

import com.mdw.model.Inventario;
import com.mdw.service.InventarioService;
import com.mdw.service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/inventario")
public class InventarioController {

    @Autowired
    private InventarioService inventarioService;

    @Autowired
    private ProductoService productoService;

    @GetMapping
    public String listarInventario(Model model) {
        model.addAttribute("inventarios", inventarioService.listarInventarios());
        return "inventario/listar_inventario";  // vista actualizada
    }

    @GetMapping("/nuevo")
    public String nuevoInventario(Model model) {
        model.addAttribute("inventario", new Inventario());
        model.addAttribute("productos", productoService.listarProductos());
        return "inventario/formulario_inventario";  // vista actualizada
    }

    @PostMapping("/guardar")
    public String guardarInventario(@Valid @ModelAttribute Inventario inventario, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("productos", productoService.listarProductos());
            return "inventario/formulario_inventario";
        }
        inventarioService.guardar(inventario);
        return "redirect:/inventario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarInventario(@PathVariable Integer id) {
        inventarioService.eliminar(id);
        return "redirect:/inventario";
    }
}
