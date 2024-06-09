package com.infotech.avocatech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.entities.Avance;
import com.infotech.avocatech.entities.Frais;
import com.infotech.avocatech.enumerations.TypeAvance;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AvanceDto {

    private Integer id;

    private LocalDate date;

    private float montant;

    private TypeAvance typeAvance;

    private Integer idFrais;


    public static AvanceDto fromEntity(Avance avance) {
        return AvanceDto.builder()
                .id(avance.getId())
                .date(avance.getDate())
                .montant(avance.getMontant())
                .typeAvance(avance.getTypeAvance())
                .idFrais(avance.getFrais().getId())
                .build();
    }

    public static Avance toEntity(AvanceDto avanceDto) {
        return Avance.builder()
                .id(avanceDto.getId())
                .date(avanceDto.getDate())
                .montant(avanceDto.getMontant())
                .typeAvance(avanceDto.getTypeAvance())
                .frais(Frais.builder()
                        .id(avanceDto.getIdFrais())
                        .build())
                .build();
    }
}
