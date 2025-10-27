package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.OrdenRepuestoDTO;
import utp.com.pe.utp.model.OrdenRepuesto;

public class OrdenRepuestoMapper {
    public static OrdenRepuestoDTO toDTO(OrdenRepuesto or) {
        OrdenRepuestoDTO dto = new OrdenRepuestoDTO();
        dto.setIdOrdenRepuesto(or.getIdOrdenRepuesto());
        dto.setRepuestoNombre(or.getRepuesto().getNombre());
        dto.setCantidad(or.getCantidad());
        dto.setSubtotal(or.getSubtotal());
        return dto;
    }
}