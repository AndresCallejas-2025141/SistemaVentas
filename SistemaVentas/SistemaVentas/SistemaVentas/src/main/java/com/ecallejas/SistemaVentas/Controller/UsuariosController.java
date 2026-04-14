package com.ecallejas.SistemaVentas.Controller;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import com.ecallejas.SistemaVentas.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    // LOGIN
    @GetMapping("/usuario")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {

        Usuarios u = service.login(username, password);

        if (u != null) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
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

        Usuarios u = service.registrar(username, password);

        if (u == null) {
            model.addAttribute("error", "El usuario ya existe");
            return "crearcuenta";
        }

        return "redirect:/usuario";
    }

    // LISTA
    @GetMapping("/listausuarios")
    public String listar(Model model) {
        List<Usuarios> lista = service.listar();
        model.addAttribute("usuarios", lista);
        return "usuarios";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        service.eliminar(id);
        return "redirect:/usuarios";
    }

    // HOME
    @GetMapping("/home")
    public String home() {
        return "home";
    }
}