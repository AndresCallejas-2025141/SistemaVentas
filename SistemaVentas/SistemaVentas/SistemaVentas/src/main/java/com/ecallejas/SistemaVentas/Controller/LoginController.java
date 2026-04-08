package com.ecallejas.SistemaVentas.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    // Mostrar la página de login
    @GetMapping("/login")
    public String mostrarLogin() {
        return "Login";
    }

    // Procesar el formulario de login
    @PostMapping("/login")
    public String procesarLogin(
            @RequestParam("usuario") String usuario,
            @RequestParam("contraseña") String contraseña,
            Model model
    ) {
        if ("admin".equals(usuario) && "1234".equals(contraseña)) {
            // Usuario válido, redirige a home
            return "redirect:/home";
        } else {
            // Usuario inválido, enviar mensaje de error
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "Login";
        }
    }

    // Página de inicio después del login
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}