package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.OrdenServicioDTO;
import utp.com.pe.utp.dto.OrdenServicioCreateDTO;
import utp.com.pe.utp.dto.OrdenServicioPatchDTO;

import java.util.List;

public interface OrdenServicioInterface {
    OrdenServicioDTO crearOrden(OrdenServicioCreateDTO dto);
    OrdenServicioDTO patchOrden(Integer id, OrdenServicioPatchDTO dto);
    OrdenServicioDTO obtenerOrdenPorId(Integer id);
    List<OrdenServicioDTO> listarOrdenes();
}