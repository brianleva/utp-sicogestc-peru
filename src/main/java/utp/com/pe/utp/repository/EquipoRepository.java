package utp.com.pe.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.com.pe.utp.model.Equipo;

@Repository
public interface EquipoRepository extends JpaRepository<Equipo, Integer> {
}