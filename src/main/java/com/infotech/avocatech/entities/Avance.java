package com.infotech.avocatech.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.enumerations.TypeAvance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Avance extends AbstractEntity{

    @Temporal(TemporalType.DATE)
    private LocalDate date;

    private float montant;

    @Enumerated(EnumType.STRING)
    private TypeAvance typeAvance;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "frais_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Frais frais;
}
