package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.dto.*;
import utp.com.pe.utp.service.EquipoInterface;

import java.util.List;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private EquipoInterface equipoService;

    @PostMapping
    public ResponseEntity<EquipoDTO> crearEquipo(@RequestBody EquipoCreateDTO dto) {
        EquipoDTO creado = equipoService.crearEquipo(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<EquipoDTO> patchEquipo(
            @PathVariable Integer id,
            @RequestBody EquipoPatchDTO dto) {
        EquipoDTO actualizado = equipoService.patchEquipo(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping
    public ResponseEntity<List<EquipoDTO>> listarEquipos() {
        return ResponseEntity.ok(equipoService.listarEquipos());
    }
}