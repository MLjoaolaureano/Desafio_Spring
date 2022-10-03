package com.example.demo.controller;

import com.example.demo.entity.Sintoma;
import com.example.demo.service.SintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sintoma")
public class SintomaController {

    @Autowired
    private SintomaService sintomaService;

    @PostMapping
    public ResponseEntity<Sintoma> create(@RequestBody Sintoma sintoma) {
        boolean result = this.sintomaService.create(sintoma);
        if (result) {
            return ResponseEntity.ok(sintoma);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<List<Sintoma>> getAll() {
        return new ResponseEntity<>(this.sintomaService.getAllSintomas(), HttpStatus.FOUND);
    }
}
