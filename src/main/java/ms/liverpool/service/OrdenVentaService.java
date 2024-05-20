package ms.liverpool.service;

import ms.liverpool.entity.Articulo;
import ms.liverpool.entity.OrdenVenta;
import ms.liverpool.repository.ArticuloRepository;
import ms.liverpool.repository.OrdenVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrdenVentaService {
    @Autowired
    private OrdenVentaRepository ordenVentaRepository;
    @Autowired
    private ArticuloRepository articuloRepository;

    public OrdenVenta crearOrdenVenta(OrdenVenta ordenDeVenta) {
        double subtotal = 0;
        for (Articulo articulo : ordenDeVenta.getArticulos()) {
            articulo.setOrdenDeVenta(ordenDeVenta);
            articulo.setSubtotal(articulo.getCantidad() * articulo.getPrecio());
            subtotal += articulo.getSubtotal();
        }
        ordenDeVenta.setSubtotal(subtotal);
        ordenDeVenta.setIva(subtotal * 0.16); // Suponiendo un IVA del 16%
        ordenDeVenta.setTotal(subtotal + ordenDeVenta.getIva());
        return ordenVentaRepository.save(ordenDeVenta);
    }

    public List<OrdenVenta> obtenerTodasLasOrdenes() {

        return ordenVentaRepository.findAll();
    }

    public Optional<OrdenVenta> obtenerOrdenPorId(Long id) {
        Optional<OrdenVenta> ordenVentaOpt=ordenVentaRepository.findById(id);
        return ordenVentaOpt;
    }

    public OrdenVenta cancelarOrden(Long id) {
        Optional<OrdenVenta> ordenVentaOpt = obtenerOrdenPorId(id);
        ordenVentaOpt.get().setFechaCancelacion(LocalDate.now());
        return ordenVentaRepository.save(ordenVentaOpt.get());
    }
}
