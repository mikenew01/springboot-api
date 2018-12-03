package br.com.mk.gestaoeducacional.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.collection.internal.PersistentSortedMap;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity(name = "TB_USUARIO")
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO", nullable = false, unique = true))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends BaseEntity implements UserDetails {

    @Size(max = 150, message = "O campo USUÁRIO pode ter no máximo 150 caracteres.")
    @Column(name = "NO_USUARIO", unique = true, nullable = false)
    private String username;

    @Column(name = "SENHA", length = 255, nullable = false)
    @Size(max = 255, message = "O campo SENHA pode ter no máximo 255 caracteres.")
    @JsonIgnore
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ID_PESSOA")
    private Pessoa pessoa;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "TB_USUARIO_PERFIL",
            joinColumns = {@JoinColumn(name = "ID_USUARIO")},
            inverseJoinColumns = {@JoinColumn(name = "ID_PERFIL")})
    private Collection<Perfil> perfis;

    @Override
    @JsonIgnore
    public Collection<Perfil> getAuthorities() {
        return getPerfis();
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonIgnore
    public boolean isEnabled() {
        return getAtivo();
    }
}
