package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.dto.*;
import utp.com.pe.utp.service.RepuestoInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoInterface repuestoService;

    @PostMapping
    public ResponseEntity<RepuestoDTO> crearRepuesto(@RequestBody RepuestoCreateDTO dto) {
        RepuestoDTO creado = repuestoService.crearRepuesto(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<RepuestoDTO> patchRepuesto(
            @PathVariable Integer id,
            @RequestBody RepuestoPatchDTO dto) {
        RepuestoDTO actualizado = repuestoService.patchRepuesto(id, dto);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping
    public ResponseEntity<List<RepuestoDTO>> listarRepuestos() {
        return ResponseEntity.ok(repuestoService.listarRepuestos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RepuestoDTO> obtenerRepuestoPorId(@PathVariable Integer id) {
        RepuestoDTO repuesto = repuestoService.obtenerRepuestoPorId(id);
        return ResponseEntity.ok(repuesto);
    }
}