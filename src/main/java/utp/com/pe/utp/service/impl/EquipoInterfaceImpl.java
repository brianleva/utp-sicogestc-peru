package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import utp.com.pe.utp.dto.EquipoCreateDTO;
import utp.com.pe.utp.dto.EquipoDTO;
import utp.com.pe.utp.dto.EquipoPatchDTO;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.Cliente;
import utp.com.pe.utp.model.Equipo;
import utp.com.pe.utp.model.TipoEquipo;
import utp.com.pe.utp.repository.ClienteRepository;
import utp.com.pe.utp.repository.EquipoRepository;
import utp.com.pe.utp.repository.TipoEquipoRepository;
import utp.com.pe.utp.service.EquipoInterface;
import utp.com.pe.utp.util.EquipoMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EquipoInterfaceImpl implements EquipoInterface {

    @Autowired
    private EquipoRepository equipoRepo;

    @Autowired
    private TipoEquipoRepository tipoRepo;

    @Autowired
    private ClienteRepository clienteRepo;

    @Override
    public EquipoDTO crearEquipo(EquipoCreateDTO dto) {
        TipoEquipo tipo = tipoRepo.findById(dto.getTipoId())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de equipo no encontrado"));

        Cliente cliente = clienteRepo.findById(dto.getClienteId())
                .orElseThrow(() -> new ResourceNotFoundException("Cliente no encontrado"));

        Equipo equipo = new Equipo();
        equipo.setNumeroSerie(dto.getNumeroSerie());
        equipo.setMarca(dto.getMarca());
        equipo.setModelo(dto.getModelo());
        equipo.setTipo(tipo);
        equipo.setCliente(cliente);

        Equipo guardado = equipoRepo.save(equipo);
        return EquipoMapper.toDTO(guardado);
    }

    @Override
    public EquipoDTO patchEquipo(Integer id, EquipoPatchDTO dto) {
        Equipo equipo = equipoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Equipo no encontrado"));

        if (dto.getMarca() != null) equipo.setMarca(dto.getMarca());
        if (dto.getModelo() != null) equipo.setModelo(dto.getModelo());

        Equipo actualizado = equipoRepo.save(equipo);
        return EquipoMapper.toDTO(actualizado);
    }

    @Override
    public List<EquipoDTO> listarEquipos() {
        return equipoRepo.findAll().stream()
                .map(EquipoMapper::toDTO)
                .collect(Collectors.toList());
    }
}
