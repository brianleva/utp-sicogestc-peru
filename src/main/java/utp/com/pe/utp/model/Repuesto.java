package utp.com.pe.utp.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Repuesto", uniqueConstraints = {
        @UniqueConstraint(columnNames = "codigo")
})
public class Repuesto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRepuesto;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "codigo", length = 50, nullable = false, unique = true)
    private String codigo;

    @Column(name = "precio", nullable = false, precision = 10, scale = 2)
    private BigDecimal precio;

    @Column(name = "stock", nullable = false)
    private Integer stock = 0;

    @OneToMany(mappedBy = "repuesto", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrdenRepuesto> ordenes = new ArrayList<>();

    // Métodos de negocio
    public void aumentarStock(Integer cantidad) {
        this.stock += cantidad;
    }

    public void disminuirStock(Integer cantidad) {
        if (this.stock >= cantidad) {
            this.stock -= cantidad;
        } else {
            throw new IllegalArgumentException("Stock insuficiente");
        }
    }
}
