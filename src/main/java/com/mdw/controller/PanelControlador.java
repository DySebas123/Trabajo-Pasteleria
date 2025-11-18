package com.mdw.controller;

import com.mdw.service.ClienteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.mdw.service.ProductoService;
import com.mdw.service.EmpleadoServiceImpl;
import com.mdw.service.PedidoServiceImpl;

@Controller
public class PanelControlador {

    @Autowired
    private ProductoService productoService;

    @Autowired
    private EmpleadoServiceImpl empleadoService;
    
    @Autowired
    private PedidoServiceImpl pedidoService;
    
    @Autowired
    private ClienteServiceImpl clienteService;

    @GetMapping("/panel")
    public String panel() {
        return "bienvenida";
    }

    @GetMapping("/panel/productos")
    public String productos(Model model) {
        model.addAttribute("productos", productoService.listarProductos());
        return "productos/productos";
    }

    @GetMapping("/panel/empleados")
    public String empleados(Model model) {
        model.addAttribute("empleados", empleadoService.listar());
        return "empleados/empleadoListar";
    }
    
    @GetMapping("/panel/pedidos")
    public String pedidos(Model model) {
        model.addAttribute("pedidos", pedidoService.listarPedidos());
        return "pedidos/pedidos";
    }
    
    @GetMapping("/panel/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.listarClientes());
        return "clientes/clientes";
    }
    
}
