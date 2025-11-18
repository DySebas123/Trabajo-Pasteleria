package com.mdw.service;

import com.mdw.model.Empleado;
import java.util.List;
import java.util.Optional;

public interface EmpleadoService {
    List<Empleado> listar();
    Empleado guardar(Empleado empleado);
    Optional<Empleado> obtenerPorId(Integer id);
    void eliminar(Integer id);
}
