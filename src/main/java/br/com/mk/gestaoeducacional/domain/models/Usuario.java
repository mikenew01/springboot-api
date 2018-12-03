package br.com.mk.gestaoeducacional.domain.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "TB_USUARIO")
@AttributeOverride(name = "id", column = @Column(name = "ID_USUARIO", nullable = false, unique = true))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Usuario extends BaseEntity{

    @Column(name = "NO_USUARIO", unique = true)
    private String username;

    @Column(name = "SENHA")
    private String password;
}
