package com.mdw.service;

import com.mdw.model.PedidoDetalle;
import java.util.List;

public interface PedidoDetalleService {
    List<PedidoDetalle> listarPorPedido(Integer pedidoId);
    PedidoDetalle guardar(PedidoDetalle detalle);
    void eliminar(Integer id);
}