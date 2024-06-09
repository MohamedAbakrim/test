package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Assemble;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AssembleDto {

    private Integer id;

    private LocalDateTime date;

    private String observation;

    private Integer idAffaireTribunal;

    public static AssembleDto fromEntity(Assemble assemble) {
        return AssembleDto.builder()
                .id(assemble.getId())
                .date(assemble.getDate())
                .observation(assemble.getObservation())
                .idAffaireTribunal(assemble.getAffaireTribunal().getId())
                .build();
    }

    public static Assemble toEntity(AssembleDto assembleDto) {
        return Assemble.builder()
                .id(assembleDto.getId())
                .date(assembleDto.getDate())
                .observation(assembleDto.getObservation())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(assembleDto.getIdAffaireTribunal())
                        .build())
                .build();
    }


}
