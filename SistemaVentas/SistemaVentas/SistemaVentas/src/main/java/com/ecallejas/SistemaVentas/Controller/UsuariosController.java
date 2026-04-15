package com.ecallejas.SistemaVentas.Controller;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import com.ecallejas.SistemaVentas.Service.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
public class UsuariosController {

    @Autowired
    private UsuariosService service;

    // LISTAR
    @GetMapping
    public List<Usuarios> listar() {
        return service.listar();
    }

    // OBTENER POR ID
    @GetMapping("/{id}")
    public Usuarios obtener(@PathVariable Integer id) {
        return service.obtenerPorId(id);
    }

    // GUARDAR
    @PostMapping
    public Usuarios guardar(@RequestBody Usuarios usuario) {
        return service.guardar(usuario);
    }

    // ACTUALIZAR
    @PutMapping("/{id}")
    public Usuarios actualizar(@PathVariable Integer id, @RequestBody Usuarios usuario) {
        usuario.setCodigoUsuario(id);
        return service.guardar(usuario);
    }

    // ELIMINAR
    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}