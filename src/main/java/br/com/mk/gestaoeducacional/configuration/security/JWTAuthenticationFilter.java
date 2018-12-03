package br.com.mk.gestaoeducacional.configuration.security;

import br.com.mk.gestaoeducacional.services.UsuarioService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Objects;

public class JWTAuthenticationFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Authentication authentication = TokenAuthenticationService.getAuthentication((HttpServletRequest) servletRequest);

        UsernamePasswordAuthenticationToken usuario = (UsernamePasswordAuthenticationToken)authentication;

        if(Objects.nonNull(usuario)){
            ServletContext servletContext = servletRequest.getServletContext();
            WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);

            UsuarioService usuarioService = webApplicationContext.getBean(UsuarioService.class);

            UserDetails userDetails = usuarioService.findByUsername(usuario.getName());

            if (Objects.nonNull(userDetails)){
                UsernamePasswordAuthenticationToken userToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(userToken);
            }else{
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }else{
            SecurityContextHolder.getContext().setAuthentication(null);
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
