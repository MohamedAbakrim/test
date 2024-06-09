package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.RegionNotification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegionNotificationDto {

    private Integer id;

    private String intitule;

    private String tel;

    private String fax;

    private String email;

    public static RegionNotificationDto fromEntity(RegionNotification regionNotification) {
        return RegionNotificationDto.builder()
                .id(regionNotification.getId())
                .intitule(regionNotification.getIntitule())
                .tel(regionNotification.getTel())
                .fax(regionNotification.getFax())
                .email(regionNotification.getEmail())
                .build();
    }

    public static RegionNotification toEntity(RegionNotificationDto regionNotificationDto) {
        return RegionNotification.builder()
                .id(regionNotificationDto.getId())
                .intitule(regionNotificationDto.getIntitule())
                .tel(regionNotificationDto.getTel())
                .fax(regionNotificationDto.getFax())
                .email(regionNotificationDto.getEmail())
                .build();
    }
}
