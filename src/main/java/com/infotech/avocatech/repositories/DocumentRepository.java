package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentRepository extends JpaRepository<Document, Integer> {
}
