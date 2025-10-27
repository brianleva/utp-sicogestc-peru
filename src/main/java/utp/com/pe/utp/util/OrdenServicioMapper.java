package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.OrdenServicioDTO;
import utp.com.pe.utp.model.OrdenServicio;

public class OrdenServicioMapper {
    public static OrdenServicioDTO toDTO(OrdenServicio orden) {
        OrdenServicioDTO dto = new OrdenServicioDTO();
        dto.setIdOrden(orden.getIdOrden());
        dto.setFechaRegistro(orden.getFechaRegistro().toString());
        dto.setDescripcion(orden.getDescripcion());
        dto.setEstadoNombre(orden.getEstado().getNombre());
        dto.setEquipoSerie(orden.getEquipo().getNumeroSerie());
        dto.setClienteNombre(orden.getEquipo().getCliente().getNombre());
        dto.setTecnicoNombre(orden.getTecnico().getNombre());
        return dto;
    }
}