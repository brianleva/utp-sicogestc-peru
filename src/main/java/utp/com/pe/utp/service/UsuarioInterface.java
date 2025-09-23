package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.UsuarioCreateDTO;
import utp.com.pe.utp.dto.UsuarioDTO;
import utp.com.pe.utp.dto.UsuarioPatchDTO;

import java.util.List;

public interface UsuarioInterface {
    UsuarioDTO crearUsuario(UsuarioCreateDTO dto);
    UsuarioDTO patchUsuario(Integer id, UsuarioPatchDTO dto);
    List<UsuarioDTO> listarUsuarios();

}
