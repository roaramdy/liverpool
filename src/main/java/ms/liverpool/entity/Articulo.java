package ms.liverpool.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "articulo")
public class Articulo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private double precio;
    private int cantidad;
    private double subtotal;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orden_de_venta_id")
    @JsonIgnore
    private OrdenVenta ordenDeVenta;
}