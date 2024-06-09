package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BureauRepository extends JpaRepository<Bureau, Integer> {

    public List<Bureau> findByIntituleIsContainingIgnoreCase(String intitule);

    @Query("SELECT b FROM Bureau b WHERE b.barreau.id = :barreauId")
    public List<Bureau> findAllByBarreauId(@Param("barreauId") int barreauId);
}
