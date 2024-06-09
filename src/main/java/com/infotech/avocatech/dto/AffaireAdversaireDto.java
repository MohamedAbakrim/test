package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Adversaire;
import com.infotech.avocatech.entities.Affaire;
import com.infotech.avocatech.entities.AffaireAdversaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AffaireAdversaireDto {

    private Integer id;

    private LocalDate dateAffectation;

    private Integer idAdversaire;

    private Integer idAffaire;

    public static AffaireAdversaireDto fromEntity(AffaireAdversaire affaireAdversaire) {
        return AffaireAdversaireDto.builder()
                .id(affaireAdversaire.getId())
                .dateAffectation(affaireAdversaire.getDateAffectation())
                .idAdversaire(affaireAdversaire.getAffaire().getId())
                .idAffaire(affaireAdversaire.getAffaire().getId())
                .build();
    }

    public static AffaireAdversaire toEntity(AffaireAdversaireDto affaireAdversaireDto) {
        return AffaireAdversaire.builder()
                .id(affaireAdversaireDto.getId())
                .dateAffectation(affaireAdversaireDto.getDateAffectation())
                .adversaire(Adversaire.builder()
                        .id(affaireAdversaireDto.getIdAdversaire())
                        .build())
                .affaire(Affaire.builder()
                        .id(affaireAdversaireDto.getIdAffaire())
                        .build())
                .build();
    }
}
