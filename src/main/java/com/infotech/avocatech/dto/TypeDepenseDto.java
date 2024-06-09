package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.TypeDepense;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TypeDepenseDto {

    private Integer id;

    private String intitule;

    public static TypeDepenseDto fromEntity(TypeDepense typeDepense) {
        return TypeDepenseDto.builder()
                .id(typeDepense.getId())
                .intitule(typeDepense.getIntitule())
                .build();
    }

    public static TypeDepense toEntity(TypeDepenseDto typeDepenseDto) {
        return TypeDepense.builder()
                .id(typeDepenseDto.getId())
                .intitule(typeDepenseDto.getIntitule())
                .build();
    }
}
