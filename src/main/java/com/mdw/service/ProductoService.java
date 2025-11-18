package com.mdw.service;

import com.mdw.model.Producto;
import java.util.List;
import java.util.Optional;

public interface ProductoService {
    List<Producto> listarProductos();
    Producto guardar(Producto producto);
    Optional<Producto> obtenerPorId(Integer id);
    void eliminar(Integer id);
}