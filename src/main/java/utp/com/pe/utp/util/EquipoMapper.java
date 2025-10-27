package utp.com.pe.utp.util;

import utp.com.pe.utp.dto.EquipoDTO;
import utp.com.pe.utp.model.Equipo;

public class EquipoMapper {
    public static EquipoDTO toDTO(Equipo equipo) {
        EquipoDTO dto = new EquipoDTO();
        dto.setIdEquipo(equipo.getIdEquipo());
        dto.setNumeroSerie(equipo.getNumeroSerie());
        dto.setMarca(equipo.getMarca());
        dto.setModelo(equipo.getModelo());
        dto.setTipoNombre(equipo.getTipo() != null ? equipo.getTipo().getNombre() : null);
        dto.setClienteNombre(equipo.getCliente() != null ? equipo.getCliente().getNombre() : null);
        return dto;
    }
}