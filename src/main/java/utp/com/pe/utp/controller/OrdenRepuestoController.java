package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.dto.*;
import utp.com.pe.utp.service.OrdenRepuestoInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ordenes/{ordenId}/repuestos")
public class OrdenRepuestoController {

    @Autowired
    private OrdenRepuestoInterface ordenRepuestoService;

    @PostMapping
    public ResponseEntity<OrdenRepuestoDTO> agregarRepuesto(
            @PathVariable Integer ordenId,
            @RequestBody OrdenRepuestoCreateDTO dto) {
        OrdenRepuestoDTO creado = ordenRepuestoService.agregarRepuestoAOrden(ordenId, dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<OrdenRepuestoDTO>> listarRepuestos(@PathVariable Integer ordenId) {
        return ResponseEntity.ok(ordenRepuestoService.listarRepuestosPorOrden(ordenId));
    }
}