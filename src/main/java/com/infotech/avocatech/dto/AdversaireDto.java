package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Adversaire;
import com.infotech.avocatech.enumerations.TypePersonne;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdversaireDto {

    private Integer id;

    private TypePersonne typePersonne;

    private String nomCompleOuRaisonSocial;

    private String numTel;

    private String email;

    private String adresse;

    private String iceOuCin;

    public static AdversaireDto fromEntity(Adversaire adversaire) {
        return AdversaireDto.builder()
                .id(adversaire.getId())
                .typePersonne(adversaire.getTypePersonne())
                .numTel(adversaire.getNumTel())
                .email(adversaire.getEmail())
                .adresse(adversaire.getAdresse())
                .nomCompleOuRaisonSocial(adversaire.getNomCompleOuRaisonSocial())
                .iceOuCin(adversaire.getIceOuCin())
                .build();
    }

    public static Adversaire toEntity(AdversaireDto adversaireDto) {
        return Adversaire.builder()
                .id(adversaireDto.getId())
                .typePersonne(adversaireDto.getTypePersonne())
                .numTel(adversaireDto.getNumTel())
                .email(adversaireDto.getEmail())
                .adresse(adversaireDto.getAdresse())
                .nomCompleOuRaisonSocial(adversaireDto.getNomCompleOuRaisonSocial())
                .iceOuCin(adversaireDto.getIceOuCin())
                .build();
    }
}
