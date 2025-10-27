package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.Estado;
import utp.com.pe.utp.repository.EstadoRepository;
import utp.com.pe.utp.service.EstadoInterface;

import java.util.List;

@Service
public class EstadoInterfaceImpl implements EstadoInterface {

    @Autowired
    private EstadoRepository estadoRepo;

    @Override
    public Estado crearEstado(Estado estado) {
        return estadoRepo.save(estado);
    }

    @Override
    public Estado actualizarEstado(Integer id, Estado estado) {
        Estado existente = estadoRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estado no encontrado"));
        existente.setNombre(estado.getNombre());
        return estadoRepo.save(existente);
    }

    @Override
    public List<Estado> listarEstados() {
        return estadoRepo.findAll();
    }
}