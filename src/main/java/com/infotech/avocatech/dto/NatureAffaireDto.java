package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.NatureAffaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NatureAffaireDto {

    private Integer id;

    private String intitule;

    public static NatureAffaireDto fromEntity(NatureAffaire natureAffaire) {
        return NatureAffaireDto.builder()
                .id(natureAffaire.getId())
                .intitule(natureAffaire.getIntitule())
                .build();
    }

    public static NatureAffaire toEntity(NatureAffaireDto dto) {
        return NatureAffaire.builder()
                .id(dto.getId())
                .intitule(dto.getIntitule())
                .build();
    }

}
