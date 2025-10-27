package utp.com.pe.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.com.pe.utp.model.OrdenServicio;

@Repository
public interface OrdenServicioRepository extends JpaRepository<OrdenServicio, Integer> {
}