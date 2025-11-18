package com.mdw.service;

import com.mdw.model.Cliente;
import java.util.List;
import java.util.Optional;

public interface ClienteService {
    List<Cliente> listarClientes();
    Cliente guardar(Cliente cliente);
    Optional<Cliente> obtenerPorId(Integer id);
    void eliminar(Integer id);
}
