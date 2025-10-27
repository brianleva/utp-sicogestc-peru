package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.ClienteDTO;
import utp.com.pe.utp.model.Cliente;

public class ClienteMapper {
    public static ClienteDTO toDTO(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setIdCliente(cliente.getIdCliente());
        dto.setNombre(cliente.getNombre());
        dto.setTelefono(cliente.getTelefono());
        dto.setEmail(cliente.getEmail());
        dto.setDireccion(cliente.getDireccion());
        return dto;
    }
}