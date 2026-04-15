package com.ecallejas.SistemaVentas.Service;

import com.ecallejas.SistemaVentas.Entity.Usuarios;

import java.util.List;

public interface UsuariosService {

    // LOGIN Y REGISTRO
    Usuarios registrar(String username, String password);
    Usuarios login(String username, String password);

    // CRUD
    List<Usuarios> listar();
    Usuarios obtenerPorId(Integer codigoUsuario);
    Usuarios guardar(Usuarios usuario);
    void eliminar(Integer codigoUsuario);
}
