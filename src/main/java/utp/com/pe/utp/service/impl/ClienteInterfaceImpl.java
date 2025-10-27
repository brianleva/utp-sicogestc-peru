package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.dto.ClienteCreateDTO;
import utp.com.pe.utp.dto.ClienteDTO;
import utp.com.pe.utp.dto.ClientePatchDTO;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.Cliente;
import utp.com.pe.utp.repository.ClienteRepository;
import utp.com.pe.utp.service.ClienteInterface;
import utp.com.pe.utp.util.ClienteMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteInterfaceImpl implements ClienteInterface {

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public ClienteDTO crearCliente(ClienteCreateDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEmail(dto.getEmail());
        cliente.setDireccion(dto.getDireccion());

        Cliente guardado = clienteRepo.save(cliente);
        return ClienteMapper.toDTO(guardado);
    }

    @Override
    public ClienteDTO patchCliente(Integer id, ClientePatchDTO dto) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        if (dto.getNombre() != null) cliente.setNombre(dto.getNombre());
        if (dto.getTelefono() != null) cliente.setTelefono(dto.getTelefono());
        if (dto.getEmail() != null) cliente.setEmail(dto.getEmail());
        if (dto.getDireccion() != null) cliente.setDireccion(dto.getDireccion());

        Cliente actualizado = clienteRepo.save(cliente);
        return ClienteMapper.toDTO(actualizado);
    }

    @Override
    public ClienteDTO obtenerClientePorId(Integer id) {
        Cliente cliente = clienteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));
        return ClienteMapper.toDTO(cliente);
    }

    @Override
    public List<ClienteDTO> listarClientes() {
        return clienteRepo.findAll().stream()
                .map(ClienteMapper::toDTO)
                .collect(Collectors.toList());
    }
}