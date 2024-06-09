package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Integer> {
}
