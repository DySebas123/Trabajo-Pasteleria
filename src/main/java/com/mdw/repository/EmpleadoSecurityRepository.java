package com.mdw.repository;

import com.mdw.model.EmpleadoSecurity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface EmpleadoSecurityRepository extends JpaRepository<EmpleadoSecurity, Long> {
    Optional<EmpleadoSecurity> findByUsername(String username);
}