package com.ecallejas.SistemaVentas.Repository;
import com.ecallejas.SistemaVentas.Entity.Productos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
@Component
public interface ProductoRepository  extends JpaRepository<Productos,Integer>{

}
