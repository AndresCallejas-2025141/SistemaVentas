package com.ecallejas.SistemaVentas.Repository;

import com.ecallejas.SistemaVentas.Entity.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuarios, Integer> {

    Usuarios findByUsername(String username);
}