package com.mdw.service;

import com.mdw.model.Critica;
import java.util.List;

public interface CriticaService {

    List<Critica> listarTodas();

    Critica guardar(Critica critica);

    void eliminar(Integer id);
}
