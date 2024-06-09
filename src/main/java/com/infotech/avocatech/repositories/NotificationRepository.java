package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
