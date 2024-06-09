package com.infotech.avocatech.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Note;
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
public class NoteDto {

    private Integer id;

    private String contenu;

    private LocalDate date;

    private Integer idAffaireTribunal;

    public static NoteDto fromEntity(Note note) {
        return NoteDto.builder()
                .id(note.getId())
                .contenu(note.getContenu())
                .date(note.getDate())
                .idAffaireTribunal(note.getAffaireTribunal().getId())
                .build();
    }

    public static Note toEntity(NoteDto noteDto) {
        return Note.builder()
                .id(noteDto.getId())
                .contenu(noteDto.getContenu())
                .date(noteDto.getDate())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(noteDto.getIdAffaireTribunal())
                        .build())
                .build();
    }

}
