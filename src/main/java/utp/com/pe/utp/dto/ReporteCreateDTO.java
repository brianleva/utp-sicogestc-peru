package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteCreateDTO {
    private String observaciones;
    private Integer ordenId;
    private Integer tecnicoId;
    private Integer tipoId;
    private Integer metodoId;
}