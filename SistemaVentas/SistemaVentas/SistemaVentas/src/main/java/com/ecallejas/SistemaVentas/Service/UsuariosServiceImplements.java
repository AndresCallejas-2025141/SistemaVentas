package com.ecallejas.SistemaVentas.Service;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import com.ecallejas.SistemaVentas.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuariosServiceImplements implements UsuariosService {

    @Autowired
    private UsuarioRepository repo;

    @Override
    public Usuarios registrar(String username, String password) {

        if (repo.findByUsername(username) != null) {
            return null;
        }

        Usuarios u = new Usuarios();
        u.setUsername(username);
        u.setPassword(password);

        return repo.save(u);
    }

    @Override
    public Usuarios login(String username, String password) {

        Usuarios u = repo.findByUsername(username);

        if (u != null && u.getPassword().equals(password)) {
            return u;
        }

        return null;
    }

    @Override
    public List<Usuarios> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}