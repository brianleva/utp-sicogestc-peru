package utp.com.pe.utp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import utp.com.pe.utp.dto.*;
import utp.com.pe.utp.exception.ResourceNotFoundException;
import utp.com.pe.utp.model.*;
import utp.com.pe.utp.repository.*;
import utp.com.pe.utp.service.ReporteInterface;
import utp.com.pe.utp.util.ReporteMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReporteInterfaceImpl implements ReporteInterface {

    @Autowired
    private ReporteRepository reporteRepo;

    @Autowired
    private OrdenServicioRepository ordenRepo;

    @Autowired
    private UsuarioRepository usuarioRepo;

    @Autowired
    private TipoReporteRepository tipoRepo;

    @Autowired
    private MetodoPagoRepository metodoRepo;

    @Override
    public ReporteDTO crearReporte(ReporteCreateDTO dto) {
        OrdenServicio orden = ordenRepo.findById(dto.getOrdenId())
                .orElseThrow(() -> new ResourceNotFoundException("Orden no encontrada"));
        Usuario tecnico = usuarioRepo.findById(dto.getTecnicoId())
                .orElseThrow(() -> new ResourceNotFoundException("Técnico no encontrado"));
        TipoReporte tipo = tipoRepo.findById(dto.getTipoId())
                .orElseThrow(() -> new ResourceNotFoundException("Tipo de reporte no encontrado"));
        MetodoPago metodo = metodoRepo.findById(dto.getMetodoId())
                .orElseThrow(() -> new ResourceNotFoundException("Método de pago no encontrado"));

        Reporte r = new Reporte();
        r.setFecha(LocalDate.now());
        r.setObservaciones(dto.getObservaciones());
        r.setOrden(orden);
        r.setTecnico(tecnico);
        r.setTipo(tipo);
        r.setMetodo(metodo);

        Reporte guardado = reporteRepo.save(r);
        return ReporteMapper.toDTO(guardado);
    }

    @Override
    public ReporteDTO obtenerReportePorId(Integer id) {
        Reporte r = reporteRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Reporte no encontrado"));
        return ReporteMapper.toDTO(r);
    }

    @Override
    public List<ReporteDTO> listarReportes() {
        return reporteRepo.findAll().stream()
                .map(ReporteMapper::toDTO)
                .collect(Collectors.toList());
    }
}