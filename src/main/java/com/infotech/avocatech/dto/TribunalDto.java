package com.infotech.avocatech.dto;


import com.infotech.avocatech.entities.Tribunal;
import com.infotech.avocatech.enumerations.TypeTribunal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TribunalDto {

    private Integer id;

    private TypeTribunal typeTribunal;

    private String ville;

    public static TribunalDto fromEntity(Tribunal tribunal) {
        return TribunalDto.builder()
                .id(tribunal.getId())
                .typeTribunal(tribunal.getTypeTribunal())
                .ville(tribunal.getVille())
                .build();
    }

    public static Tribunal toEntity(TribunalDto tribunalDto) {
        return Tribunal.builder()
                .id(tribunalDto.getId())
                .typeTribunal(tribunalDto.getTypeTribunal())
                .ville(tribunalDto.getVille())
                .build();
    }
}
