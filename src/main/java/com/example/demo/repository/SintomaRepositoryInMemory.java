package com.example.demo.repository;

import com.example.demo.entity.NivelGravidade;
import com.example.demo.entity.Pessoa;
import com.example.demo.entity.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SintomaRepositoryInMemory implements ISintomaRepository {
    final List<Sintoma> sintomaList;

    @Autowired
    public SintomaRepositoryInMemory(List<Sintoma> sintomaList){
        this.sintomaList = sintomaList;
    }
    @Override
    public List<Sintoma> getAllSintomas() {
        return this.sintomaList;
    }

    @Override
    public void createSintoma(Sintoma sintoma) {

        this.sintomaList.add(sintoma);
    }
}
