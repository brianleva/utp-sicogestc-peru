package utp.com.pe.utp.service;

import utp.com.pe.utp.dto.EquipoDTO;
import utp.com.pe.utp.dto.EquipoCreateDTO;
import utp.com.pe.utp.dto.EquipoPatchDTO;

import java.util.List;

public interface EquipoInterface {
    EquipoDTO crearEquipo(EquipoCreateDTO dto);
    EquipoDTO patchEquipo(Integer id, EquipoPatchDTO dto);
    List<EquipoDTO> listarEquipos();
}