package utp.com.pe.utp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoDTO {
    private Integer idEquipo;
    private String numeroSerie;
    private String marca;
    private String modelo;
    private String tipoNombre;
    private String clienteNombre;
}