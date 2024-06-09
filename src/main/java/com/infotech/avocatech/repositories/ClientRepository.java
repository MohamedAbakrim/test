package com.infotech.avocatech.repositories;

import com.infotech.avocatech.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {

    public Client findClientByIceOuCinEquals(String iceOuCin);

    public List<Client> findClientByNomCompletOuRaisonSocialContainsIgnoreCase(String nomCompletOuRaisonSocial);
}
