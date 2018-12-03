package br.com.mk.gestaoeducacional.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_PERFIL")
@AttributeOverride(name = "ID", column = @Column(name = "ID_PERFIL", unique = true, nullable = false))
public class Perfil extends BaseEntity implements GrantedAuthority {

    @Column(name = "NOME")
    private String nome;

    @Column(name = "DESCRICAO")
    private String descricao;

    @Override
    public String getAuthority() {
        return getNome();
    }
}
