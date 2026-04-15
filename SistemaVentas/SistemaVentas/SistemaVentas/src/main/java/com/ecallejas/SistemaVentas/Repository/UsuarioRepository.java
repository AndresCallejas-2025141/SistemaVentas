package com.ecallejas.SistemaVentas.Repository;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    Optional<Usuarios> findByUsername(String username);

    Optional<Usuarios> findByUsernameAndPassword(String username, String password);
}