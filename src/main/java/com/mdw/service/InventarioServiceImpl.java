package com.mdw.service;

import com.mdw.model.Inventario;
import com.mdw.repository.InventarioRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements InventarioService {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public List<Inventario> listarInventarios() {
        return inventarioRepository.findAll();
    }

    @Override
    public Inventario guardar(Inventario inventario) {
        return inventarioRepository.save(inventario);
    }

    @Override
    public Optional<Inventario> obtenerPorId(Integer id) {
        return inventarioRepository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        inventarioRepository.deleteById(id);
    }
}
