package com.mk.mkspringboot.resources;

import com.mk.mkspringboot.domain.models.pessoa.Pessoa;
import com.mk.mkspringboot.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
@ResponseBody
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar(){
        List<Pessoa> pessoas = pessoaService.listar();

        if(pessoas == null)
            return new ResponseEntity<>(pessoas, HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(pessoas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa){
        Pessoa pessoaBanco = pessoaService.salvar(pessoa);

        if(pessoaBanco == null)
            return new ResponseEntity<>(pessoaBanco, HttpStatus.UNPROCESSABLE_ENTITY);

        return new ResponseEntity<>(pessoaBanco, HttpStatus.OK);
    }
}
