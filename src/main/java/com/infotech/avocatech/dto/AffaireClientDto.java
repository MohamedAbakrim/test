package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Affaire;
import com.infotech.avocatech.entities.AffaireClient;
import com.infotech.avocatech.entities.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AffaireClientDto {

    private Integer id;

    private LocalDate dateAffectation;

    private Integer idAffaire;

    private Integer idClient;

    public static AffaireClientDto fromEntity(AffaireClient affaireClient) {
        return AffaireClientDto.builder()
                .id(affaireClient.getId())
                .dateAffectation(affaireClient.getDateAffectation())
                .idAffaire(affaireClient.getAffaire().getId())
                .idClient(affaireClient.getClient().getId())
                .build();
    }

    public static AffaireClient toEntity(AffaireClientDto affaireClientDto) {
        return AffaireClient.builder()
                .id(affaireClientDto.getId())
                .dateAffectation(affaireClientDto.getDateAffectation())
                .affaire(Affaire.builder()
                        .id(affaireClientDto.getIdAffaire())
                        .build())
                .client(Client.builder()
                        .id(affaireClientDto.getIdClient())
                        .build())
                .build();
    }
}
