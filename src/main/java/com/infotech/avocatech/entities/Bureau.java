package com.infotech.avocatech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Bureau extends AbstractEntity {

    private String intitule;

    private String adresse;

    private String numTel;

    private String email;

    private String fax;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "barreau_id")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    @Nullable
    private Barreau barreau;

    @OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
    @JoinColumn(name= "bureau_avocat_id")
    private List<Avocat> avocat;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "bureau_affaire_id")
    private List<Affaire> affaires;
}
