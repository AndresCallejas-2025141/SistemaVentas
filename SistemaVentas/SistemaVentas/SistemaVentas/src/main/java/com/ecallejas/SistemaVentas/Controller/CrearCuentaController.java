package com.ecallejas.SistemaVentas.Controller;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CrearCuentaController {

    // Mostrar vista Crear Cuenta
    @GetMapping("/CrearCuenta")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuarios());
        return "CrearCuenta";
    }

    // Procesar registro
    @PostMapping("/registro")
    public String registrarUsuario(@ModelAttribute("usuario") Usuarios usuario) {

        // Guardar en base de datos
        System.out.println("Usuario: " + usuario.getUsername());
        System.out.println("Password: " + usuario.getPassword());

        return "redirect:/login";
    }
}