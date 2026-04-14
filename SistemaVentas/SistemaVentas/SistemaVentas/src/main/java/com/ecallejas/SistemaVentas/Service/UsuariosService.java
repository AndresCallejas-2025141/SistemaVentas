package com.ecallejas.SistemaVentas.Service;

import com.ecallejas.SistemaVentas.Entity.Usuarios;

import java.util.List;

public interface UsuariosService {

    Usuarios registrar(String username, String password);

    Usuarios login(String username, String password);

    List<Usuarios> listar();

    void eliminar(Integer id);
}
