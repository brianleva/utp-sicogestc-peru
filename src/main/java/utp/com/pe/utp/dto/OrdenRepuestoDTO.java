package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenRepuestoDTO {
    private Integer idOrdenRepuesto;
    private String repuestoNombre;
    private Integer cantidad;
    private Double subtotal;
}