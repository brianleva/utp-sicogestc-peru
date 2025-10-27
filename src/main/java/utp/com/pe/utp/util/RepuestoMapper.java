package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.RepuestoDTO;
import utp.com.pe.utp.model.Repuesto;

public class RepuestoMapper {
    public static RepuestoDTO toDTO(Repuesto repuesto) {
        RepuestoDTO dto = new RepuestoDTO();
        dto.setIdRepuesto(repuesto.getIdRepuesto());
        dto.setNombre(repuesto.getNombre());
        dto.setPrecio(repuesto.getPrecio());
        dto.setStock(repuesto.getStock());
        return dto;
    }
}