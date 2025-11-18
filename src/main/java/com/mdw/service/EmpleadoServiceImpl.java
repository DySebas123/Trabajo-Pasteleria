package com.mdw.service;

import com.mdw.model.Empleado;
import com.mdw.repository.EmpleadoRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    @Autowired
    private EmpleadoRepository repository;

    @Override
    public List<Empleado> listar() {
        return repository.findAll();
    }
    
    @Override
    public Empleado guardar(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public Optional<Empleado> obtenerPorId(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void eliminar(Integer id) {
        repository.deleteById(id);
    }
}
