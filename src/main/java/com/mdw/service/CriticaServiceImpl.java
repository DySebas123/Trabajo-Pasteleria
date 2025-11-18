package com.mdw.service;

import com.mdw.model.Critica;
import com.mdw.repository.CriticaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CriticaServiceImpl implements CriticaService {

    @Autowired
    private CriticaRepository criticaRepository;

    @Override
    public List<Critica> listarTodas() {
        return criticaRepository.findAll();
    }

    @Override
    public Critica guardar(Critica critica) {
        return criticaRepository.save(critica);
    }

    @Override
    public void eliminar(Integer id) {
        criticaRepository.deleteById(id);
    }
}
