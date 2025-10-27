package utp.com.pe.utp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteCreateDTO {
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
}