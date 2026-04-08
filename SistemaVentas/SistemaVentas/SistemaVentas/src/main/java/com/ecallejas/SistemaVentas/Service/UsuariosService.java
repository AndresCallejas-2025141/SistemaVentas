package com.ecallejas.SistemaVentas.Service;
import com.ecallejas.SistemaVentas.Entity.Usuarios;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface UsuariosService {
    List<Usuarios> getAllUsuarios();
    Usuarios getUsuariosById(Integer codigoUsuario);
    Usuarios saveUsuarios(Usuarios usuarios) throws RuntimeException;
    Usuarios updateUsuarios(Integer codigoUsuario, Usuarios usuarios);
    void deleteUsuarios(Integer codigoUsuario);
}
