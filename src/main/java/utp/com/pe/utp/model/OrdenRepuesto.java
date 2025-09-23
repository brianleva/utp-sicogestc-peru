package utp.com.pe.utp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "OrdenRepuesto")
public class OrdenRepuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idOrdenRepuesto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_id", nullable = false)
    private OrdenServicio orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "repuesto_id", nullable = false)
    private Repuesto repuesto;

    @Column(name = "cantidad", nullable = false)
    private Integer cantidad = 1;

    public OrdenRepuesto(OrdenServicio ordenServicio, Repuesto repuesto, Integer cantidad) {
        this.orden = ordenServicio;
        this.repuesto = repuesto;
        this.cantidad = cantidad;
    }

    // Método para calcular subtotal
    public BigDecimal getSubtotal() {
        return repuesto.getPrecio().multiply(BigDecimal.valueOf(cantidad));
    }
}
