package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.AffaireTribunal;
import com.infotech.avocatech.entities.Notification;
import com.infotech.avocatech.entities.RegionNotification;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class NotificationDto {

    private Integer id;

    private LocalDate date;

    private String description;

    private Integer idRegionNotification;

    private Integer idAffaireTribunal;

    public static NotificationDto fromEntity(Notification notification) {
        return NotificationDto.builder()
                .id(notification.getId())
                .date(notification.getDate())
                .description(notification.getDescription())
                .idRegionNotification(notification.getRegionNotification().getId())
                .idAffaireTribunal(notification.getAffaireTribunal().getId())
                .build();
    }

    public static Notification toEntity(NotificationDto notificationDto) {
        return Notification.builder()
                .id(notificationDto.getId())
                .date(notificationDto.getDate())
                .description(notificationDto.getDescription())
                .regionNotification(RegionNotification.builder()
                        .id(notificationDto.getIdRegionNotification())
                        .build())
                .affaireTribunal(AffaireTribunal.builder()
                        .id(notificationDto.getIdAffaireTribunal())
                        .build())
                .build();
    }
}
