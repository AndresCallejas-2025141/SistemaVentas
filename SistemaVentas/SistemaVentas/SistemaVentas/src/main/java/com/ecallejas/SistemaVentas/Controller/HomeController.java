package com.ecallejas.SistemaVentas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"/", "/inicio"})
    public String home() {
        return "home"; // home.html
    }

    @GetMapping("/ventas")
    public String ventas() {
        return "ventas"; // ventas.html
    }

    @GetMapping("/detalleventas")
    public String detalleVentas() {
        return "detalleventas"; // detalleventas.html
    }

    @GetMapping("/productos")
    public String productos() {
        return "productos"; // productos.html
    }

    @GetMapping("/clientes")
    public String clientes() {
        return "clientes"; // clientes.html
    }

    @GetMapping("/usuarios")
    public String usuarios() {
        return "usuarios"; // usuarios.html
    }
}