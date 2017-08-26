package com.mk.mkspringboot.domain.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@SuppressWarnings("unused")
public class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long newId) {
        this.id = newId;
    }

    @JsonIgnore
    @Transient
    public Boolean isPersisted() {
        return this.getId() != null && this.getId() != 0L;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.id == null) ? 0 : this.id.hashCode());
        return result;
    }

    @SuppressWarnings("EqualsWhichDoesntCheckParameterClass")
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || (Hibernate.getClass(this) != Hibernate.getClass(obj))) {
            return false;
        }

        BaseEntity other = (BaseEntity) obj;

        if (this.getId() == null && other.getId() == null) {
            return false;
        } else if (this.getId() == null && other.getId() != null) {
            return false;
        } else if (!this.getId().equals(other.getId())) {
            return false;
        }

        return true;
    }
}
