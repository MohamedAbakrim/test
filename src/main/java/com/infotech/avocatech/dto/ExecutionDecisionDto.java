package com.infotech.avocatech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.ExecutionDecision;
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
public class ExecutionDecisionDto {

    private Integer id;

    private String numExecutions;

    private LocalDate date;

    private String executeur;

    private String observation;

    private Integer idAffaireTribunal;

    public static ExecutionDecisionDto fromEntity(ExecutionDecision executionDecision) {
        return ExecutionDecisionDto.builder()
                .id(executionDecision.getId())
                .numExecutions(executionDecision.getNumExecutions())
                .date(executionDecision.getDate())
                .executeur(executionDecision.getExecuteur())
                .observation(executionDecision.getObservation())
                .idAffaireTribunal(executionDecision.getAffaireTribunal().getId())
                .build();
    }

    public static ExecutionDecision toEntity(ExecutionDecisionDto executionDecisionDto) {
        return ExecutionDecision.builder()
                .id(executionDecisionDto.getId())
                .numExecutions(executionDecisionDto.getNumExecutions())
                .date(executionDecisionDto.getDate())
                .executeur(executionDecisionDto.getExecuteur())
                .observation(executionDecisionDto.getObservation())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(executionDecisionDto.getIdAffaireTribunal())
                        .build())
                .build();

    }
}
