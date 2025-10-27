package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoCreateDTO {
    private String nombre;
    private Double precio;
    private Integer stock;
}