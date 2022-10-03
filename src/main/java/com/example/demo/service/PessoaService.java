package com.example.demo.service;

import com.example.demo.entity.Pessoa;
import com.example.demo.repository.IPessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {

    @Autowired
    private IPessoaRepository pessoaRepository;

    public boolean create(Pessoa pessoa){
        try{
            this.pessoaRepository.createPessoa(pessoa);
            return true;
        }
        catch(Exception e){
            return false;
        }

    }

    public List<Pessoa> getPessoasEmRisco(){
        return this.pessoaRepository.getAllPessoa().stream().filter((p) -> p.getIdade() > 60).toList();
    }
}
