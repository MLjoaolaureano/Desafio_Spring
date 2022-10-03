package com.example.demo.repository;

import com.example.demo.entity.NivelGravidade;
import com.example.demo.entity.Pessoa;
import com.example.demo.entity.Sintoma;

import java.util.List;

public interface IPessoaRepository {

    public List<Pessoa> getAllPessoa();
    public void createPessoa(Pessoa pessoa);

}
