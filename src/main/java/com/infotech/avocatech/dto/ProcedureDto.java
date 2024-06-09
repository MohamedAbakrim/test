package com.infotech.avocatech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.entities.Assemble;
import com.infotech.avocatech.entities.Procedure;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcedureDto {

    private Integer id;

    private String name;

    private String description;

    private LocalDate dateLimite;

    private Integer idAssemble;

    public static ProcedureDto fromEntity(Procedure procedure) {
        return ProcedureDto.builder()
                .id(procedure.getId())
                .name(procedure.getName())
                .description(procedure.getDescription())
                .dateLimite(procedure.getDateLimite())
                .idAssemble(procedure.getAssemble().getId())
                .build();
    }

    public static Procedure toEntity(ProcedureDto procedureDto) {
        return Procedure.builder()
                .id(procedureDto.getId())
                .name(procedureDto.getName())
                .description(procedureDto.getDescription())
                .dateLimite(procedureDto.getDateLimite())
                .assemble(Assemble.builder()
                        .id(procedureDto.getIdAssemble())
                        .build())
                .build();
    }

}
