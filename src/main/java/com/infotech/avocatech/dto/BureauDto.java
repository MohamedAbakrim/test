package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Barreau;
import com.infotech.avocatech.entities.Bureau;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BureauDto {

    private Integer id;

    private String intitule;

    private String adresse;

    private String numTel;

    private String email;

    private String fax;


    public static BureauDto fromEntity(Bureau bureau) {
        return BureauDto.builder()
                .id(bureau.getId())
                .intitule(bureau.getIntitule())
                .adresse(bureau.getAdresse())
                .numTel(bureau.getNumTel())
                .email(bureau.getEmail())
                .fax(bureau.getFax())
                .build();
    }

    public static Bureau toEntity(BureauDto bureauDto) {
        return Bureau.builder()
                .id(bureauDto.getId())
                .intitule(bureauDto.getIntitule())
                .adresse(bureauDto.getAdresse())
                .numTel(bureauDto.getNumTel())
                .email(bureauDto.getEmail())
                .fax(bureauDto.getFax())
                .build();
    }
}
