package com.example.demo.service;

import com.example.demo.entity.Pessoa;
import com.example.demo.entity.Sintoma;
import com.example.demo.repository.IPessoaRepository;
import com.example.demo.repository.ISintomaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SintomaService {

    @Autowired
    private ISintomaRepository sintomaRepository;

    SintomaService(ISintomaRepository sintomaRepository){
        this.sintomaRepository = sintomaRepository;
    }

    public boolean create(Sintoma sintoma){
        try{
            this.sintomaRepository.createSintoma(sintoma);
            return true;
        }
        catch(Exception e){
            return false;
        }
    }

    public List<Sintoma> getAllSintomas(){
        return this.sintomaRepository.getAllSintomas();
    }
}
