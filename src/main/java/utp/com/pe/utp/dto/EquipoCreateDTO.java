package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EquipoCreateDTO {
    private String numeroSerie;
    private String marca;
    private String modelo;
    private Integer tipoId;
    private Integer clienteId;
}