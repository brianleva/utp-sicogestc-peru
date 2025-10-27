package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoDTO {
    private Integer idRepuesto;
    private String nombre;
    private Double precio;
    private Integer stock;
}