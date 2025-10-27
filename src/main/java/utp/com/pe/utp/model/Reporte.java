package utp.com.pe.utp.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Reporte")
public class Reporte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReporte;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(length = 255)
    private String observaciones;

    @ManyToOne
    @JoinColumn(name = "orden_id", nullable = false)
    private OrdenServicio orden;

    @ManyToOne
    @JoinColumn(name = "tecnico_id", nullable = false)
    private Usuario tecnico;

    @ManyToOne
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoReporte tipo;

    @ManyToOne
    @JoinColumn(name = "metodo_id", nullable = false)
    private MetodoPago metodo;
}