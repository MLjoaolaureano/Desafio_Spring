package com.example.demo.controller;

import com.example.demo.entity.Pessoa;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<Pessoa> create(@RequestBody Pessoa pessoa) {
        boolean result = this.pessoaService.create(pessoa);
        if (result) {
            return ResponseEntity.ok(pessoa);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("emRisco")
    public ResponseEntity<List<Pessoa>> getPessoasEmRisco() {
        return new ResponseEntity<>(this.pessoaService.getPessoasEmRisco(), HttpStatus.FOUND);
    }
}
