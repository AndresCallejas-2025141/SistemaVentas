package com.ecallejas.SistemaVentas.Service;
import com.ecallejas.SistemaVentas.Entity.Productos;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public interface ProductosService {
    List<Productos> getAllProductos();
    Productos getProductosById(Integer codigoProducto);
    Productos saveProductos(Productos productos) throws RuntimeException;
    Productos updateProductos(Integer codigoProducto, Productos productos);
    void deleteProductos(Integer codigoProducto);
}
