package com.ecallejas.SistemaVentas.Service;
import com.ecallejas.SistemaVentas.Entity.Clientes;
import com.ecallejas.SistemaVentas.Repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {
    private final ClienteRepository clienteRepository;

    public ClientesServiceImplements(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Clientes> getAllClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Clientes getClientesById(Integer dpiCliente) {
        return clienteRepository.findById(dpiCliente).orElse(null);
    }

    @Override
    public Clientes saveClientes(Clientes clientes) throws RuntimeException {
        return clienteRepository.save(clientes);
    }

    @Override
    public Clientes updateClientes(Integer dpiCliente, Clientes clientes) {
        Clientes cliente1 = clienteRepository.findById(dpiCliente).orElse(null);

        if (cliente1 != null) {
            cliente1.setNombreCliente(clientes.getNombreCliente());
            cliente1.setApellidoCliente(clientes.getApellidoCliente());
            cliente1.setDireccion(clientes.getDireccion());
            cliente1.setEstado(clientes.getEstado());
        } else {
            throw new RuntimeException("Cliente no encontrado");
        }

        return clienteRepository.save(cliente1);
    }

    @Override
    public void deleteClientes(Integer dpiCliente) {
        Clientes clientes = clienteRepository.findById(dpiCliente).orElse(null);

        if (clientes == null) {
            throw new RuntimeException("Cliente no encontrado");
        }

        clienteRepository.delete(clientes);
    }
}
