package ms.liverpool.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "orden_venta")
public class OrdenVenta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fechaCreacion;
    private LocalDate fechaCancelacion;
    private String nombreCliente;
    @OneToMany(mappedBy = "ordenDeVenta", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Articulo> articulos = new ArrayList<>();
    private double subtotal;
    private double iva;
    private double total;

}