package br.com.mk.gestaoeducacional.domain.dtos;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class PerfilDTO implements Serializable {

    private String nome;
    private String descricao;


}
