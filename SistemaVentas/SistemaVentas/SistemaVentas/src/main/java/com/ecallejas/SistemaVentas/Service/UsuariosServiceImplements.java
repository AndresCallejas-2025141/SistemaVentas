package com.ecallejas.SistemaVentas.Service;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import com.ecallejas.SistemaVentas.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuariosServiceImplements implements UsuariosService {

    @Autowired
    private UsuarioRepository repo;

    // Registrar
    @Override
    public Usuarios registrar(String username, String password) {

        Optional<Usuarios> existente = repo.findByUsername(username);

        if (existente.isPresent()) {
            throw new RuntimeException("El usuario ya existe");
        }

        Usuarios u = new Usuarios();
        u.setUsername(username);
        u.setPassword(password);

        return repo.save(u);
    }

    // Login
    @Override
    public Usuarios login(String username, String password) {

        Usuarios u = repo.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!u.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return u;
    }

    // LISTAR
    @Override
    public List<Usuarios> listar() {
        return repo.findAll();
    }

    // BuscarporID
    @Override
    public Usuarios obtenerPorId(Integer codigoUsuario) {
        return repo.findById(codigoUsuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Guardar
    @Override
    public Usuarios guardar(Usuarios usuario) {
        return repo.save(usuario);
    }

    // Eliminar
    @Override
    public void eliminar(Integer codigoUsuario) {
        if (!repo.existsById(codigoUsuario)) {
            throw new RuntimeException("Usuario no existe");
        }
        repo.deleteById(codigoUsuario);
    }

}