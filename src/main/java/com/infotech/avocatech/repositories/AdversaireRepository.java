package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Adversaire;
import com.infotech.avocatech.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AdversaireRepository extends JpaRepository<Adversaire, Integer> {

    public Adversaire findAdversaireByIceOuCinEquals(String iceOuCin);

    public List<Adversaire> findAdversaireByNomCompleOuRaisonSocialContainsIgnoreCase(String nomCompletOuRaisonSocial);
}
