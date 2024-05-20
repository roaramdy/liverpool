package ms.liverpool.repository;

import ms.liverpool.entity.Articulo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticuloRepository extends JpaRepository<Articulo,Long> {
}
