package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Barreau;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BarreauDto {

    private Integer id;

    private String intitule;

    private String ville;

    public static BarreauDto fromEntity(Barreau barreau) {
        return BarreauDto.builder()
                .id(barreau.getId())
                .ville(barreau.getVille())
                .intitule(barreau.getIntitule())
                .build();
    }

    public static Barreau toEntity(BarreauDto barreauDto) {
        return Barreau.builder()
                .id(barreauDto.getId())
                .ville(barreauDto.getVille())
                .intitule(barreauDto.getIntitule())
                .build();
    }
}
