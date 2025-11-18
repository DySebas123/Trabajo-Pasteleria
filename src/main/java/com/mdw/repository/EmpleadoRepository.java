package com.mdw.repository;

import com.mdw.model.Empleado;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {
    List<Empleado> findByNombreContainingIgnoreCase(String nombre);
}