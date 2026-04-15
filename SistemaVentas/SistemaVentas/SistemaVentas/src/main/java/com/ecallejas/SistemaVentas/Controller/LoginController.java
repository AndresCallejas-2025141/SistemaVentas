package com.ecallejas.SistemaVentas.Controller;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import com.ecallejas.SistemaVentas.Service.UsuariosService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @Autowired
    private UsuariosService service;

    // LOGIN PAGE
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model,
                        HttpSession session) {

        try {
            Usuarios u = service.login(username, password);

            //GUARDAR SESIÓN
            session.setAttribute("usuarioLogueado", u.getUsername());
            session.setAttribute("rol", u.getRol());

            return "redirect:/home";

        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "login";
        }
    }

    // REGISTRO
    @GetMapping("/registro")
    public String registro() {
        return "crearcuenta";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {

        try {
            service.registrar(username, password);
            return "redirect:/login";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "crearcuenta";
        }
    }

    // HOME
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}