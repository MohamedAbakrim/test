package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Avocat;
import com.infotech.avocatech.entities.Bureau;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AvocatDto {

    private Integer id;

    private String nom;

    private String prenom;

    private String numTel;

    private String email;


    public static AvocatDto fromEntity(Avocat avocat) {
        return AvocatDto.builder()
                .id(avocat.getId())
                .nom(avocat.getNom())
                .prenom(avocat.getPrenom())
                .numTel(avocat.getNumTel())
                .email(avocat.getEmail())
                .build();
    }

    public static Avocat toEntity(AvocatDto avocatDto) {
        return Avocat.builder()
                .id(avocatDto.getId())
                .nom(avocatDto.getNom())
                .prenom(avocatDto.getPrenom())
                .numTel(avocatDto.getNumTel())
                .email(avocatDto.getEmail())
                .build();

    }
}
