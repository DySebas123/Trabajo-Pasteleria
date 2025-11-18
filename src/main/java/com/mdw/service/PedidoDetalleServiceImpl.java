package com.mdw.service;

import com.mdw.model.PedidoDetalle;
import com.mdw.repository.PedidoDetalleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoDetalleServiceImpl implements PedidoDetalleService {

    @Autowired
    private PedidoDetalleRepository detalleRepository;

    @Override
    public List<PedidoDetalle> listarPorPedido(Integer pedidoId) {
        return detalleRepository.findByPedidoId(pedidoId);
    }

    @Override
    public PedidoDetalle guardar(PedidoDetalle detalle) {
        return detalleRepository.save(detalle);
    }

    @Override
    public void eliminar(Integer id) {
        detalleRepository.deleteById(id);
    }
}
