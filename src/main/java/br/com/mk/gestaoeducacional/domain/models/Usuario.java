package br.com.mk.gestaoeducacional.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Entity(name = "TB_USUARIO")
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO", nullable = false, unique = true))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends BaseEntity implements UserDetails {

    @Column(name = "NO_USUARIO", unique = true)
    private String username;

    @Column(name = "SENHA")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_USUARIO_PERFIL",
            joinColumns = {@JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PERFIL")})
    private Collection<Perfil> perfis;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getPerfis();
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return getAtivo();
    }
}
