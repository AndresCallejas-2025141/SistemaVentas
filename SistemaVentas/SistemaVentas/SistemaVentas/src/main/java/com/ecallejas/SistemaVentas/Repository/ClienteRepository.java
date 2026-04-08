package com.ecallejas.SistemaVentas.Repository;
import com.ecallejas.SistemaVentas.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
public interface ClienteRepository  extends JpaRepository<Clientes,Integer> {

}
