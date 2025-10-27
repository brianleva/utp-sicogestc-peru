package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.model.Estado;
import utp.com.pe.utp.service.EstadoInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/estados")
public class EstadoController {

    @Autowired
    private EstadoInterface estadoService;

    @PostMapping
    public ResponseEntity<Estado> crearEstado(@RequestBody Estado estado) {
        Estado creado = estadoService.crearEstado(estado);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Estado> actualizarEstado(
            @PathVariable Integer id,
            @RequestBody Estado estado) {
        Estado actualizado = estadoService.actualizarEstado(id, estado);
        return ResponseEntity.ok(actualizado);
    }

    @GetMapping
    public ResponseEntity<List<Estado>> listarEstados() {
        return ResponseEntity.ok(estadoService.listarEstados());
    }
}