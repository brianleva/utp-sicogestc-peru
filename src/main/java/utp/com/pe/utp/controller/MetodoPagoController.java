package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.model.MetodoPago;
import utp.com.pe.utp.service.MetodoPagoInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/metodos-pago")
public class MetodoPagoController {

    @Autowired
    private MetodoPagoInterface metodoService;

    @PostMapping
    public ResponseEntity<MetodoPago> crearMetodo(@RequestBody MetodoPago metodo) {
        MetodoPago creado = metodoService.crearMetodo(metodo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<MetodoPago>> listarMetodos() {
        return ResponseEntity.ok(metodoService.listarMetodos());
    }
}