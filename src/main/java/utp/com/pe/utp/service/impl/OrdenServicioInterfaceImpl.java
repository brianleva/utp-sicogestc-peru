package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.dto.OrdenServicioCreateDTO;
import utp.com.pe.utp.dto.OrdenServicioDTO;
import utp.com.pe.utp.dto.OrdenServicioPatchDTO;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.Equipo;
import utp.com.pe.utp.model.Estado;
import utp.com.pe.utp.model.OrdenServicio;
import utp.com.pe.utp.model.Usuario;
import utp.com.pe.utp.repository.EquipoRepository;
import utp.com.pe.utp.repository.EstadoRepository;
import utp.com.pe.utp.repository.OrdenServicioRepository;
import utp.com.pe.utp.repository.UsuarioRepository;
import utp.com.pe.utp.service.OrdenServicioInterface;
import utp.com.pe.utp.util.OrdenServicioMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenServicioInterfaceImpl implements OrdenServicioInterface {

    @Autowired
    private OrdenServicioRepository ordenRepo;

    @Autowired
    private EquipoRepository equipoRepo;

    @Autowired
    private EstadoRepository estadoRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Override
    public OrdenServicioDTO crearOrden(OrdenServicioCreateDTO dto) {
        Equipo equipo = equipoRepo.findById(dto.getEquipoId())
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));
        Estado estado = estadoRepo.findById(dto.getEstadoId())
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));
        Usuario tecnico = usuarioRepo.findById(dto.getTecnicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Técnico no encontrado"));

        OrdenServicio orden = new OrdenServicio();
        orden.setFechaRegistro(LocalDate.now());
        orden.setDescripcion(dto.getDescripcion());
        orden.setEquipo(equipo);
        orden.setEstado(estado);
        orden.setTecnico(tecnico);

        OrdenServicio guardado = ordenRepo.save(orden);
        return OrdenServicioMapper.toDTO(guardado);
    }

    @Override
    public OrdenServicioDTO patchOrden(Integer id, OrdenServicioPatchDTO dto) {
        OrdenServicio orden = ordenRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada"));

        if (dto.getDescripcion() != null) orden.setDescripcion(dto.getDescripcion());
        if (dto.getEstadoId() != null) {
            Estado estado = estadoRepo.findById(dto.getEstadoId())
                    .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));
            orden.setEstado(estado);
        }

        OrdenServicio actualizado = ordenRepo.save(orden);
        return OrdenServicioMapper.toDTO(actualizado);
    }

    @Override
    public OrdenServicioDTO obtenerOrdenPorId(Integer id) {
        OrdenServicio orden = ordenRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada"));
        return OrdenServicioMapper.toDTO(orden);
    }

    @Override
    public List<OrdenServicioDTO> listarOrdenes() {
        return ordenRepo.findAll().stream()
                .map(OrdenServicioMapper::toDTO)
                .collect(Collectors.toList());
    }
}