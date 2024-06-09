package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AffaireDto {

    private Integer id;

    private String numeroAffaire;

    private String observations;

    private String sujet;

    private String titre;

    private Integer idTypeAffaire;

    private Integer idNatureAffaire;

    private Integer idBureau;

    public static AffaireDto fromEntity(Affaire affaire) {
        return AffaireDto.builder()
                .id(affaire.getId())
                .numeroAffaire(affaire.getNumeroAffaire())
                .observations(affaire.getObservations())
                .sujet(affaire.getSujet())
                .titre(affaire.getTitre())
                .idTypeAffaire(affaire.getTypeAffaire().getId())
                .idNatureAffaire(affaire.getNatureAffaire().getId())
                .idBureau(affaire.getBureau().getId())
                .build();
    }

    public static Affaire toEntity(AffaireDto affaireDto) {
        return Affaire.builder()
                .id(affaireDto.getId())
                .numeroAffaire(affaireDto.getNumeroAffaire())
                .observations(affaireDto.getObservations())
                .sujet(affaireDto.getSujet())
                .titre(affaireDto.getTitre())
                .typeAffaire(TypeAffaire.builder()
                        .id(affaireDto.getIdTypeAffaire())
                        .build())
                .natureAffaire(NatureAffaire.builder()
                        .id(affaireDto.getIdNatureAffaire())
                        .build())
                .bureau(Bureau.builder()
                        .id(affaireDto.getIdBureau())
                        .build())
                .build();
    }
}
