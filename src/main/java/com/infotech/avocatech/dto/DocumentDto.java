package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DocumentDto {

    private Integer id;

    private String title;

    private String url;

    private Integer idAffaireTribunal;

    public static DocumentDto fromEntity(Document document) {
        return DocumentDto.builder()
                .id(document.getId())
                .title(document.getTitle())
                .url(document.getUrl())
                .idAffaireTribunal(document.getAffaireTribunal().getId())
                .build();
    }

    public static Document toEntity(DocumentDto documentDto) {
        return Document.builder()
                .id(documentDto.getId())
                .title(documentDto.getTitle())
                .url(documentDto.getUrl())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(documentDto.getIdAffaireTribunal())
                        .build())
                .build();

    }
}
