package com.mk.mkspringboot.resources;

import com.mk.mkspringboot.models.Pessoa;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static java.util.Arrays.asList;

@RestController
@RequestMapping("/pessoas")
@ResponseBody
public class PessoaResource {

    @GetMapping("/listar")
    public ResponseEntity<List<Pessoa>> listar(){
        return new ResponseEntity<>(asList(new Pessoa("Maikon", "Canuto", 22)), HttpStatus.OK);
    }
}
