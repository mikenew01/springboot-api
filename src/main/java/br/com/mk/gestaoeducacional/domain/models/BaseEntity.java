package br.com.mk.gestaoeducacional.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Data
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "ATIVO")
    private Boolean ativo = true;

    @JsonIgnore
    @Transient
    public Boolean isPersisted() {
        return this.getId() != null && this.getId() != 0L;
    }
}
