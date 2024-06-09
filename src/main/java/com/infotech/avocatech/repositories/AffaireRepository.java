package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Affaire;
import com.infotech.avocatech.entities.Bureau;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AffaireRepository extends JpaRepository<Affaire, Integer> {

   public  Optional<Affaire> findByNumeroAffaire(String numeroAffaire);

    public List<Affaire> findAllByBureau(Bureau bureau);
}