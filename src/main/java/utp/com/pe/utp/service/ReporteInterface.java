package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.ReporteDTO;
import utp.com.pe.utp.dto.ReporteCreateDTO;

import java.util.List;

public interface ReporteInterface {
    ReporteDTO crearReporte(ReporteCreateDTO dto);
    ReporteDTO obtenerReportePorId(Integer id);
    List<ReporteDTO> listarReportes();
}