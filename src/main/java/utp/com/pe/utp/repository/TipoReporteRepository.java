package utp.com.pe.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.com.pe.utp.model.TipoReporte;

@Repository
public interface TipoReporteRepository extends JpaRepository<TipoReporte, Integer> {
}