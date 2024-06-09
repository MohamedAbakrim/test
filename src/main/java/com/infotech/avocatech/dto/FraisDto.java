package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Frais;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FraisDto {

    private Integer id;

    private float montant;

    private Integer idAffaireTribunal;

    public static FraisDto fromEntity(Frais frais) {
        return FraisDto.builder()
                .id(frais.getId())
                .montant(frais.getMontant())
                .idAffaireTribunal(frais.getAffaireTribunal().getId())
                .build();
    }

    public static Frais toEntity(FraisDto fraisDto) {
        return Frais.builder()
                .id(fraisDto.getId())
                .montant(fraisDto.getMontant())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(fraisDto.getId())
                        .build())
                .build();
    }
}
