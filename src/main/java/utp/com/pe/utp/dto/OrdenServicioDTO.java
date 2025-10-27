package utp.com.pe.utp.dto;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdenServicioDTO {
    private Integer idOrden;
    private String fechaRegistro;
    private String descripcion;
    private String estadoNombre;
    private String equipoSerie;
    private String clienteNombre;
    private String tecnicoNombre;
}