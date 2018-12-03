package br.com.mk.gestaoeducacional.configuration.security;

import br.com.mk.gestaoeducacional.domain.models.Usuario;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Objects;

public class TokenAuthenticationService {

    static final long EXPIRATION_TIME = 860_000_000;
    static final String SECRET = "MySecret";
    static final String TOKEN_PREFIX = "Bearer";
    static final String HEADER_STRING = "Authorization";

    public static void addAuthentication(HttpServletResponse response, Authentication authentication){
        final Usuario usuario = (Usuario)authentication.getPrincipal();

        HashMap<String, Object> mapa = new HashMap<>();
        mapa.put("id", usuario.getId());
        mapa.put("username", usuario.getUsername());
        mapa.put("roels", usuario.getAuthorities()); //Retornar os roles

        final String JWT = Jwts.builder()
                .setClaims(mapa)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        response.addHeader(HEADER_STRING, TOKEN_PREFIX + " " + JWT);
    }

    public static Authentication getAuthentication(HttpServletRequest request){
        String token = request.getHeader(HEADER_STRING);

        if(Objects.nonNull(token)){
            final String user = (String)Jwts.parser()
                    .setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody()
                    .get("username");

            if(Objects.nonNull(user))
                return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
            else
                return null; //trocar para exception
        }

        return null;
    }
}
