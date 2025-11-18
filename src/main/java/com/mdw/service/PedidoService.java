package com.mdw.service;

import com.mdw.model.Pedido;
import java.util.List;
import java.util.Optional;

public interface PedidoService {
    List<Pedido> listarPedidos();
    Pedido guardar(Pedido pedido);
    Optional<Pedido> obtenerPorId(Integer id);
    void eliminar(Integer id);
}