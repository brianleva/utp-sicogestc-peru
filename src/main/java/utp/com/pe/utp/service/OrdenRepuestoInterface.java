package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.OrdenRepuestoDTO;
import utp.com.pe.utp.dto.OrdenRepuestoCreateDTO;

import java.util.List;

public interface OrdenRepuestoInterface {
    OrdenRepuestoDTO agregarRepuestoAOrden(Integer ordenId, OrdenRepuestoCreateDTO dto);
    List<OrdenRepuestoDTO> listarRepuestosPorOrden(Integer ordenId);
}