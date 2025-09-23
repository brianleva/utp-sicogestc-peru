package utp.com.pe.utp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utp.com.pe.utp.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
}

