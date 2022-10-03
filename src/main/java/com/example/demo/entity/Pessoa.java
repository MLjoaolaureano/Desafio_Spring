package com.example.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Pessoa {
    String id;
    String nome;
    String sobrenome;
    int idade;
}
