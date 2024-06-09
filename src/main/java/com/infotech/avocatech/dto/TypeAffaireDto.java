package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.TypeAffaire;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TypeAffaireDto {

    private Integer id;

    private String intitule;

    public static TypeAffaireDto fromEntity(TypeAffaire typeAffaire) {
        return TypeAffaireDto.builder()
                .id(typeAffaire.getId())
                .intitule(typeAffaire.getIntitule())
                .build();
    }

    public static TypeAffaire toEntity(TypeAffaireDto dto) {
        return TypeAffaire.builder()
                .id(dto.getId())
                .intitule(dto.getIntitule())
                .build();
    }
}
