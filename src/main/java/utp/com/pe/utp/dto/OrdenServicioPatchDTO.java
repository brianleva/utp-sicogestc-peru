package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenServicioPatchDTO {
    private String descripcion;
    private Integer estadoId;
}