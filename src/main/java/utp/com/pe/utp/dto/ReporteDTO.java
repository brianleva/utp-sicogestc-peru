package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReporteDTO {
    private Integer idReporte;
    private String fecha;
    private String observaciones;
    private String tipoNombre;
    private String metodoNombre;
    private String tecnicoNombre;
    private Integer ordenId;
}