package com.infotech.avocatech.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Depense;
import com.infotech.avocatech.entities.TypeDepense;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class DepenseDto {

    private Integer id;

    private LocalDate date;

    private String motif;

    private float montant;

    private Integer idTypeDepense;

    private Integer idAffaireTribunal;

    public static DepenseDto fromEntity(Depense depense) {
        return DepenseDto.builder()
                .id(depense.getId())
                .date(depense.getDate())
                .motif(depense.getMotif())
                .montant(depense.getMontant())
                .idTypeDepense(depense.getTypeDepense().getId())
                .idAffaireTribunal(depense.getAffaireTribunal().getId())
                .build();
    }

    public static Depense toEntity(DepenseDto depenseDto) {
        return Depense.builder()
                .id(depenseDto.getId())
                .date(depenseDto.getDate())
                .motif(depenseDto.getMotif())
                .montant(depenseDto.getMontant())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(depenseDto.getIdTypeDepense())
                        .build())
                .typeDepense(TypeDepense.builder()
                        .id(depenseDto.getIdTypeDepense())
                        .build())
                .build();
    }
}
