package com.infotech.avocatech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Jugement;
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
public class JugementDto {

    private Integer id;

    private String numJugement;

    private LocalDate date;

    private String contenu;

    private Integer idAffaireTribunal;

    public static JugementDto fromEntity(Jugement jugement) {
        return JugementDto.builder()
                .id(jugement.getId())
                .numJugement(jugement.getNumJugement())
                .date(jugement.getDate())
                .contenu(jugement.getContenu())
                .idAffaireTribunal(jugement.getAffaireTribunal().getId())
                .build();
    }

    public static Jugement toEntity(JugementDto dto) {
        return Jugement.builder()
                .id(dto.getId())
                .numJugement(dto.getNumJugement())
                .date(dto.getDate())
                .contenu(dto.getContenu())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(dto.getIdAffaireTribunal())
                        .build())
                .build();
    }
}
