package utp.com.pe.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.com.pe.utp.model.OrdenRepuesto;

import java.util.List;

@Repository
public interface OrdenRepuestoRepository extends JpaRepository<OrdenRepuesto, Integer> {
    List<OrdenRepuesto> findByOrdenIdOrden(Integer ordenId);
}