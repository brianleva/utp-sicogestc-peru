package utp.com.pe.utp.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "OrdenServicio", uniqueConstraints = {
        @UniqueConstraint(columnNames = "numeroOrden"),
        @UniqueConstraint(columnNames = "codigoSeguimiento")
})
public class OrdenServicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdenServicio;

    @Column(name = "numeroOrden", length = 50, nullable = false, unique = true)
    private String numeroOrden;

    @Column(name = "codigoSeguimiento", length = 100, nullable = false, unique = true)
    private String codigoSeguimiento;

    @Column(name = "fechaRecepcion", nullable = false)
    private LocalDateTime fechaRecepcion;

    @Column(name = "fechaEntrega")
    private LocalDateTime fechaEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estado_id", nullable = false)
    private Estado estado;

    @Column(name = "fallaReportada", nullable = false, columnDefinition = "TEXT")
    private String fallaReportada;

    @Column(name = "diagnostico", columnDefinition = "TEXT")
    private String diagnostico;

    @Column(name = "costoEstimado", precision = 10, scale = 2)
    private BigDecimal costoEstimado;

    @Column(name = "costoFinal", precision = 10, scale = 2)
    private BigDecimal costoFinal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id", nullable = false)
    private Equipo equipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tecnico_id", nullable = false)
    private Usuario tecnico;

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdenRepuesto> repuestos = new ArrayList<>();

    @OneToMany(mappedBy = "orden", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Pago> pagos = new ArrayList<>();

    //Metodos para manejar la relación con OrdenRepuesto
    public void agregarRepuesto(Repuesto repuesto, Integer cantidad) {
        OrdenRepuesto ordenRepuesto = new OrdenRepuesto(this, repuesto, cantidad);
        repuestos.add(ordenRepuesto);
    }

    public BigDecimal calcularCostoTotal() {
        BigDecimal costoRepuestos = repuestos.stream()
                .map(or -> or.getRepuesto().getPrecio().multiply(BigDecimal.valueOf(or.getCantidad())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return costoFinal != null ? costoFinal :
                (costoEstimado != null ? costoEstimado : costoRepuestos);
    }

    @PrePersist
    protected void onCreate() {
        if (fechaRecepcion == null) {
            fechaRecepcion = LocalDateTime.now();
        }
    }
}
