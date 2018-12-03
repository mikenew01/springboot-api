package br.com.mk.gestaoeducacional.resources;

import br.com.mk.gestaoeducacional.domain.models.Usuario;
import br.com.mk.gestaoeducacional.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/usuarios")
public class UsuarioResource extends BaseResource{

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioResource(final UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public ResponseEntity<?> findAll(){
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }
}
