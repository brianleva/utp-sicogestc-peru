package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.UsuarioDTO;
import utp.com.pe.utp.model.Usuario;

public class UsuarioMapper {
    public static UsuarioDTO toDTO(Usuario usuario) {
        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(usuario.getIdUsuario());
        dto.setNombre(usuario.getNombre());
        dto.setEmail(usuario.getEmail());
        dto.setRolNombre(
                usuario.getRol() != null ? usuario.getRol().getNombre() : null
        );
        return dto;
    }
}