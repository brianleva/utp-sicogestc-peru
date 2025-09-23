package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.dto.UsuarioCreateDTO;
import utp.com.pe.utp.dto.UsuarioDTO;
import utp.com.pe.utp.dto.UsuarioPatchDTO;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.Rol;
import utp.com.pe.utp.model.Usuario;
import utp.com.pe.utp.repository.RolRepository;
import utp.com.pe.utp.repository.UsuarioRepository;
import utp.com.pe.utp.service.UsuarioInterface;
import utp.com.pe.utp.util.UsuarioMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioInterfaceImpl implements UsuarioInterface {
    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private RolRepository rolRepo;

    @Override
    public UsuarioDTO crearUsuario(UsuarioCreateDTO dto) {
        Rol rol = rolRepo.findById(dto.getRolId())
                .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));

        Usuario usuario = new Usuario();
        usuario.setNombre(dto.getNombre());
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getPassword());
        usuario.setRol(rol);

        Usuario guardado = usuarioRepo.save(usuario);

        return UsuarioMapper.toDTO(guardado);
    }

    @Override
    public UsuarioDTO patchUsuario(Integer id, UsuarioPatchDTO dto) {
        Usuario usuario = usuarioRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario no encontrado"));

        if (dto.getNombre() != null) usuario.setNombre(dto.getNombre());
        if (dto.getEmail() != null) {
            Optional<Usuario> existente = usuarioRepo.findByEmail(dto.getEmail());
            if (existente.isPresent() && !existente.get().getIdUsuario().equals(id)) {
                throw new IllegalArgumentException("Email ya registrado");
            }
            usuario.setEmail(dto.getEmail());
        }
        if (dto.getPassword() != null) usuario.setPassword(dto.getPassword());

        if (dto.getRolId() != null) {
            Rol rol = rolRepo.findById(dto.getRolId())
                    .orElseThrow(() -> new ResourceNotFoundException("Rol no encontrado"));
            usuario.setRol(rol);
        }

        Usuario actualizado = usuarioRepo.save(usuario);
        return UsuarioMapper.toDTO(actualizado);
    }

    @Override
    public List<UsuarioDTO> listarUsuarios() {
        return usuarioRepo.findAll().stream()
                .map(UsuarioMapper::toDTO)
                .collect(Collectors.toList());
    }
}
