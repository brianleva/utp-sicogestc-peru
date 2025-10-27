package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.dto.*;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.Repuesto;
import utp.com.pe.utp.repository.RepuestoRepository;
import utp.com.pe.utp.service.RepuestoInterface;
import utp.com.pe.utp.util.RepuestoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RepuestoInterfaceImpl implements RepuestoInterface {

    @Autowired
    private RepuestoRepository repuestoRepo;

    @Override
    public RepuestoDTO crearRepuesto(RepuestoCreateDTO dto) {
        Repuesto repuesto = new Repuesto();
        repuesto.setNombre(dto.getNombre());
        repuesto.setPrecio(dto.getPrecio());
        repuesto.setStock(dto.getStock());

        Repuesto guardado = repuestoRepo.save(repuesto);
        return RepuestoMapper.toDTO(guardado);
    }

    @Override
    public RepuestoDTO patchRepuesto(Integer id, RepuestoPatchDTO dto) {
        Repuesto repuesto = repuestoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto no encontrado"));

        if (dto.getPrecio() != null) repuesto.setPrecio(dto.getPrecio());
        if (dto.getStock() != null) repuesto.setStock(dto.getStock());

        Repuesto actualizado = repuestoRepo.save(repuesto);
        return RepuestoMapper.toDTO(actualizado);
    }

    @Override
    public RepuestoDTO obtenerRepuestoPorId(Integer id) {
        Repuesto repuesto = repuestoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto no encontrado"));
        return RepuestoMapper.toDTO(repuesto);
    }

    @Override
    public List<RepuestoDTO> listarRepuestos() {
        return repuestoRepo.findAll().stream()
                .map(RepuestoMapper::toDTO)
                .collect(Collectors.toList());
    }
}