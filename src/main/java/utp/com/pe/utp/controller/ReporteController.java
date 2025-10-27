package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.dto.*;
import utp.com.pe.utp.service.ReporteInterface;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/reportes")
public class ReporteController {

    @Autowired
    private ReporteInterface reporteService;

    @PostMapping
    public ResponseEntity<ReporteDTO> crearReporte(@RequestBody ReporteCreateDTO dto) {
        ReporteDTO creado = reporteService.crearReporte(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<ReporteDTO>> listarReportes() {
        return ResponseEntity.ok(reporteService.listarReportes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteDTO> obtenerReportePorId(@PathVariable Integer id) {
        ReporteDTO reporte = reporteService.obtenerReportePorId(id);
        return ResponseEntity.ok(reporte);
    }
}