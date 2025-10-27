package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.ReporteDTO;
import utp.com.pe.utp.model.Reporte;

public class ReporteMapper {
    public static ReporteDTO toDTO(Reporte r) {
        ReporteDTO dto = new ReporteDTO();
        dto.setIdReporte(r.getIdReporte());
        dto.setFecha(r.getFecha().toString());
        dto.setObservaciones(r.getObservaciones());
        dto.setTipoNombre(r.getTipo().getNombre());
        dto.setMetodoNombre(r.getMetodo().getNombre());
        dto.setTecnicoNombre(r.getTecnico().getNombre());
        dto.setOrdenId(r.getOrden().getIdOrden());
        return dto;
    }
}