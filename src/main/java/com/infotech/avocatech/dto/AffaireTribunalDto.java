package com.infotech.avocatech.dto;


import com.infotech.avocatech.entities.Affaire;
import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Tribunal;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AffaireTribunalDto {

    private Integer id;

    private String numAffaireTribunal;

    private LocalDate dateAffectation;

    private Integer idAffaire;

    private Integer idTribunal;

    public static AffaireTribunalDto fromEntity(AffaireTribunal affaireTribunal) {
        return AffaireTribunalDto.builder()
                .id(affaireTribunal.getId())
                .numAffaireTribunal(affaireTribunal.getNumAffaireTribunal())
                .dateAffectation(affaireTribunal.getDateAffectation())
                .idAffaire(affaireTribunal.getAffaire().getId())
                .idTribunal(affaireTribunal.getTribunal().getId())
                .build();
    }

    public static AffaireTribunal toEntity(AffaireTribunalDto affaireTribunalDto) {
        return AffaireTribunal.builder()
                .id(affaireTribunalDto.getId())
                .numAffaireTribunal(affaireTribunalDto.getNumAffaireTribunal())
                .dateAffectation(affaireTribunalDto.getDateAffectation())
                .affaire(Affaire.builder()
                        .id(affaireTribunalDto.getIdAffaire())
                        .build())
                .tribunal(Tribunal.builder()
                        .id(affaireTribunalDto.getIdTribunal())
                        .build())
                .build();
    }


}
