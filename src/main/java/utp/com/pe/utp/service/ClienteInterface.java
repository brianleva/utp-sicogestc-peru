package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.ClienteCreateDTO;
import utp.com.pe.utp.dto.ClienteDTO;
import utp.com.pe.utp.dto.ClientePatchDTO;

import java.util.List;

public interface ClienteInterface {
    ClienteDTO crearCliente(ClienteCreateDTO dto);
    ClienteDTO patchCliente(Integer id, ClientePatchDTO dto);
    ClienteDTO obtenerClientePorId(Integer id);
    List<ClienteDTO> listarClientes();
}