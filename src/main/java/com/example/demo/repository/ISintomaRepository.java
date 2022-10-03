package com.example.demo.repository;

import com.example.demo.entity.NivelGravidade;
import com.example.demo.entity.Sintoma;

import java.util.List;

public interface ISintomaRepository {

    public List<Sintoma> getAllSintomas();
    public void createSintoma(Sintoma sintoma);

}
