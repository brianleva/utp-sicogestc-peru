package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.model.TipoReporte;
import utp.com.pe.utp.service.TipoReporteInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/tipos-reporte")
public class TipoReporteController {

    @Autowired
    private TipoReporteInterface tipoService;

    @PostMapping
    public ResponseEntity<TipoReporte> crearTipo(@RequestBody TipoReporte tipo) {
        TipoReporte creado = tipoService.crearTipo(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<TipoReporte>> listarTipos() {
        return ResponseEntity.ok(tipoService.listarTipos());
    }
}