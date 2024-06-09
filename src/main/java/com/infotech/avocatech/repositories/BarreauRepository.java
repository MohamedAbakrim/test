package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Barreau;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarreauRepository extends JpaRepository<Barreau, Integer> {

    public Barreau findByIntituleContainsIgnoreCase(String intitule);
}
