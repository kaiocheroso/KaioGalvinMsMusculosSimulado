package com.example.MrMusculos.controller;


import com.example.MrMusculos.dto.produtoDto;
import com.example.MrMusculos.model.produto;
import com.example.MrMusculos.repository.produtoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/msmusculos")
public class produtoController {

    @Autowired
    produtoRepository produtoRepository;

    @PostMapping
    public ResponseEntity<produto> salvar(@RequestBody @Valid produtoDto produtoDto) {
        var produto = new produto();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));

    }

    @GetMapping
    public ResponseEntity<List<produto>> pegartodos() {
        return ResponseEntity.status(HttpStatus.OK).body(produtoRepository.findAll());
    }

    @GetMapping("/{Id}")
    public ResponseEntity<Object> pegarum(@PathVariable(value = "Id") Integer Id) {
        Optional<produto> produt0 = produtoRepository.findById(Id);
        if (produt0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao achado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produt0.get());
    }

    @PutMapping("/{Id}")
    public ResponseEntity<Object> atualizar(@PathVariable(value = "Id") Integer Id,
                                            @RequestBody @Valid produtoDto produtoDto) {
        Optional<produto> produt0 = produtoRepository.findById(Id);
        if (produt0.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto nao achado");
        }
        var produto = produt0.get();
        BeanUtils.copyProperties(produtoDto, produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produto));
    }

}
