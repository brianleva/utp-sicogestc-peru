package utp.com.pe.utp.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Reporte")
public class Reporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReporte;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoReporte tipo;

    @Column(name = "fechaGeneracion", nullable = false)
    private LocalDateTime fechaGeneracion;

    @Column(name = "datos", columnDefinition = "TEXT")
    private String datos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @PrePersist
    protected void onCreate() {
        if (fechaGeneracion == null) {
            fechaGeneracion = LocalDateTime.now();
        }
    }
}

