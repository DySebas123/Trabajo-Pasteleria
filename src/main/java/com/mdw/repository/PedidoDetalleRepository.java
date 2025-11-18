package com.mdw.repository;

import com.mdw.model.PedidoDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle, Integer> {
    List<PedidoDetalle> findByPedidoId(Integer pedidoId);
}