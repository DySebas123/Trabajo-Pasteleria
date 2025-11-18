package com.mdw.repository;

import com.mdw.model.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
     List<Producto> findByNombreContainingIgnoreCase(String nombre);
}