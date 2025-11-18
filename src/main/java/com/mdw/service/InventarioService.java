package com.mdw.service;

import com.mdw.model.Inventario;
import java.util.List;
import java.util.Optional;

public interface InventarioService {
    List<Inventario> listarInventarios();
    Inventario guardar(Inventario inventario);
    Optional<Inventario> obtenerPorId(Integer id);
    void eliminar(Integer id);
}
