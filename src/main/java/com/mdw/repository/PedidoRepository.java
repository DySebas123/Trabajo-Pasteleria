package com.mdw.repository;

import com.mdw.model.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
    List<Pedido> findByClienteNombreContainingIgnoreCase(String nombreCliente);
}