package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.RepuestoDTO;
import utp.com.pe.utp.dto.RepuestoCreateDTO;
import utp.com.pe.utp.dto.RepuestoPatchDTO;

import java.util.List;

public interface RepuestoInterface {
    RepuestoDTO crearRepuesto(RepuestoCreateDTO dto);
    RepuestoDTO patchRepuesto(Integer id, RepuestoPatchDTO dto);
    RepuestoDTO obtenerRepuestoPorId(Integer id);
    List<RepuestoDTO> listarRepuestos();
}