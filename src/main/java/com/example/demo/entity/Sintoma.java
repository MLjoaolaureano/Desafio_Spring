package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Sintoma {

    String codigo;
    String nome;
    NivelGravidade nivel_de_gravidade;
}
