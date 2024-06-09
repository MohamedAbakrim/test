package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Procedure;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcedureRepository extends JpaRepository<Procedure, Integer> {
}
