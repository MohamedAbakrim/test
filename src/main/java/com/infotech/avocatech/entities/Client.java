package com.infotech.avocatech.entities;

import com.infotech.avocatech.enumerations.ClientAdversaire;
import com.infotech.avocatech.enumerations.TypePersonne;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Client extends AbstractEntity{

    @Enumerated(EnumType.STRING)
    private TypePersonne typePersonne;

    private String nomCompletOuRaisonSocial;

    private String numTel;

    private String email;

    private String adresse;

    private String iceOuCin;

    private Boolean estRepresentant;

}
