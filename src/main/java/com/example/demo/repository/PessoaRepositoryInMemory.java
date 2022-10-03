package com.example.demo.repository;

import com.example.demo.entity.NivelGravidade;
import com.example.demo.entity.Pessoa;
import com.example.demo.entity.Sintoma;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class PessoaRepositoryInMemory implements IPessoaRepository {
    final List<Pessoa> pessoaList;

    @Autowired
    public PessoaRepositoryInMemory(List<Pessoa> pessoaList){
        this.pessoaList = pessoaList;
    }

    @Override
    public List<Pessoa> getAllPessoa() {
        return this.pessoaList;
    }

    @Override
    public void createPessoa(Pessoa pessoa) {

        this.pessoaList.add(pessoa);
    }
}
