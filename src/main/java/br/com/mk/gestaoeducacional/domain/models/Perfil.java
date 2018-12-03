package br.com.mk.gestaoeducacional.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "TB_PERFIL")
@AttributeOverride(name = "ID", column = @Column(name = "ID_PERFIL", unique = true, nullable = false))
public class Perfil extends BaseEntity implements GrantedAuthority {

    @Size(max = 150, message = "O campo NOME PERFIL pode ter no máximo 150 caracters.")
    @Column(name = "NOME_PERFIL", unique = true, length = 150, nullable = false)
    private String nome;

    @Size(max = 150, message = "O campo DESCRIÇÃO PERFIL pode ter no máximo 150 caracters.")
    @Column(name = "DESCRICAO_PERFIL", length = 150, nullable = false)
    private String descricao;

    @Override
    @JsonIgnore
    public String getAuthority() {
        return getNome();
    }
}
