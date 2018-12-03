package br.com.mk.gestaoeducacional.domain.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity(name = "TB_PESSOA")
@AttributeOverride(name = "id", column = @Column(name = "ID_PESSOA", unique = true, nullable = false))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa extends BaseEntity {

    @Column(name = "NOME", length = 200, nullable = false)
    @Size(max = 200, message = "O campo NOME PESSOA pode ter no máximo 200 caracteres.")
    private String nome;

    @Column(name = "SOBRE_NOME", length = 200, nullable = false)
    @Size(max = 200, message = "O campo SOBRE NOME pode ter no máximo 200 caracteres.")
    private String sobreNome;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATA_NASCIMENTO")
    private Date dataNascimento;
}
