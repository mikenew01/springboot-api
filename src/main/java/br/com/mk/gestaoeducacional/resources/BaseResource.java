package br.com.mk.gestaoeducacional.resources;

import br.com.mk.gestaoeducacional.domain.models.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class BaseResource {

    public Usuario getUsuarioLogado(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            return (Usuario) authentication.getPrincipal();
        }catch (Exception e){
            throw e;
        }
    }

    public String perfilLogado(){
        try {
            Usuario usuario = this.getUsuarioLogado();
            String perfil = "";

            if (usuario.getAuthorities().stream().findFirst().isPresent()) {
//                perfil = usuario.getAuthorities().stream().findFirst().get();
            }

            return perfil;
        } catch (Exception ex) {
            throw ex;
        }
    }

}
