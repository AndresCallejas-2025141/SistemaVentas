package com.ecallejas.SistemaVentas.Service;
import com.ecallejas.SistemaVentas.Entity.DetalleVenta;
import com.ecallejas.SistemaVentas.Repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService {
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta getDetalleVentaById(Integer codigoDetalleVenta) {
        return detalleVentaRepository.findById(codigoDetalleVenta).orElse(null);
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) throws RuntimeException {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer codigoDetalleVenta, DetalleVenta detalleVenta) {
        DetalleVenta detalle1 = detalleVentaRepository.findById(codigoDetalleVenta).orElse(null);

        if (detalle1 != null) {
            detalle1.setCantidad(detalleVenta.getCantidad());
            detalle1.setPrecioUnitario(detalleVenta.getPrecioUnitario());
            detalle1.setSubtotal(detalleVenta.getSubtotal());
            detalle1.setCodigoProducto(detalleVenta.getCodigoProducto());
            detalle1.setCodigoVenta(detalleVenta.getCodigoVenta());
        } else {
            throw new RuntimeException("Detalle de venta no encontrado");
        }

        return detalleVentaRepository.save(detalle1);
    }

    @Override
    public void deleteDetalleVenta(Integer codigoDetalleVenta) {
        DetalleVenta detalle = detalleVentaRepository.findById(codigoDetalleVenta).orElse(null);

        if (detalle == null) {
            throw new RuntimeException("Detalle de venta no encontrado");
        }

        detalleVentaRepository.delete(detalle);
    }
}
