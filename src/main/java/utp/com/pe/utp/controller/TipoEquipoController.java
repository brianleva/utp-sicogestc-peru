package utp.com.pe.utp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import utp.com.pe.utp.model.TipoEquipo;
import utp.com.pe.utp.service.TipoEquipoInterface;

import java.util.List;

@RestController
@RequestMapping("/tipo-equipo")
public class TipoEquipoController {

    @Autowired
    private TipoEquipoInterface tipoService;

    @PostMapping
    public ResponseEntity<TipoEquipo> crearTipo(@RequestBody TipoEquipo tipo) {
        TipoEquipo creado = tipoService.crearTipoEquipo(tipo);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    @GetMapping
    public ResponseEntity<List<TipoEquipo>> listarTipos() {
        return ResponseEntity.ok(tipoService.listarTipos());
    }
}