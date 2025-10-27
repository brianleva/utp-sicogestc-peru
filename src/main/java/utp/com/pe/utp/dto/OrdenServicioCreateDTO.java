package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenServicioCreateDTO {
    private String descripcion;
    private Integer equipoId;
    private Integer estadoId;
    private Integer tecnicoId;
}

