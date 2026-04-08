package com.ecallejas.SistemaVentas.Service;
import com.ecallejas.SistemaVentas.Entity.Ventas;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface VentasService {
    List<Ventas> getAllVentas();
    Ventas getVentasById(Integer codigoVenta);
    Ventas saveVentas(Ventas ventas) throws RuntimeException;
    Ventas updateVentas(Integer codigoVenta, Ventas ventas);
    void deleteVentas(Integer codigoVenta);
}
