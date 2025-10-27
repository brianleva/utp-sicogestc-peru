package utp.com.pe.utp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientePatchDTO {
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
}