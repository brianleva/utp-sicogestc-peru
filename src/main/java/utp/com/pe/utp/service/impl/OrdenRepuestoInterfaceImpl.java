package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.dto.OrdenRepuestoDTO;
import utp.com.pe.utp.dto.OrdenRepuestoCreateDTO;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.*;
import utp.com.pe.utp.repository.*;
import utp.com.pe.utp.service.OrdenRepuestoInterface;
import utp.com.pe.utp.util.OrdenRepuestoMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrdenRepuestoInterfaceImpl implements OrdenRepuestoInterface {

    @Autowired private OrdenRepuestoRepository ordenRepuestoRepo;
    @Autowired private OrdenServicioRepository ordenRepo;
    @Autowired private RepuestoRepository repuestoRepo;

    @Override
    public OrdenRepuestoDTO agregarRepuestoAOrden(Integer ordenId, OrdenRepuestoCreateDTO dto) {
        OrdenServicio orden = ordenRepo.findById(ordenId)
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada"));

        Repuesto repuesto = repuestoRepo.findById(dto.getRepuestoId())
                .orElseThrow(() -> new ResourceNotFoundException("Repuesto no encontrado"));

        if (repuesto.getStock() < dto.getCantidad()) {
            throw new IllegalArgumentException("Stock insuficiente");
        }

        repuesto.setStock(repuesto.getStock() - dto.getCantidad());
        repuestoRepo.save(repuesto);

        OrdenRepuesto or = new OrdenRepuesto();
        or.setOrden(orden);
        or.setRepuesto(repuesto);
        or.setCantidad(dto.getCantidad());
        or.setSubtotal(repuesto.getPrecio() * dto.getCantidad());

        OrdenRepuesto guardado = ordenRepuestoRepo.save(or);
        return OrdenRepuestoMapper.toDTO(guardado);
    }

    @Override
    public List<OrdenRepuestoDTO> listarRepuestosPorOrden(Integer ordenId) {
        return ordenRepuestoRepo.findByOrdenIdOrden(ordenId).stream()
                .map(OrdenRepuestoMapper::toDTO)
                .collect(Collectors.toList());
    }
}