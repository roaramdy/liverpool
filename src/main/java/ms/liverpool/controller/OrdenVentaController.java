package ms.liverpool.controller;

import ms.liverpool.entity.OrdenVenta;
import ms.liverpool.service.OrdenVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ordenes")
public class OrdenVentaController {
    //cambios
    @Autowired
    private OrdenVentaService ordenVentaService;

    @PostMapping
    public ResponseEntity<OrdenVenta> crearOrden(@RequestBody OrdenVenta ordenDeVenta) {
        OrdenVenta nuevaOrden = ordenVentaService.crearOrdenVenta(ordenDeVenta);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaOrden);
    }

    @GetMapping
    public ResponseEntity<List<OrdenVenta>> obtenerOrdenes() {
        List<OrdenVenta> ordenes = ordenVentaService.obtenerTodasLasOrdenes();
        return ResponseEntity.ok(ordenes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrdenVenta> obtenerOrdenPorId(@PathVariable Long id) {
        Optional<OrdenVenta> ordenOpt = ordenVentaService.obtenerOrdenPorId(id);
        return ResponseEntity.ok(ordenOpt.get());

    }

    @PutMapping("/cancelar/{id}")
    public ResponseEntity<OrdenVenta> cancelarOrden(@PathVariable Long id) {
        OrdenVenta ordenCancelada = ordenVentaService.cancelarOrden(id);
        return ResponseEntity.ok(ordenCancelada);
    }
}
