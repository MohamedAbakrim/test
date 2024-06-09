package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.AdversaireDto;
import com.infotech.avocatech.dto.ClientDto;

import java.util.List;

public interface AdversaireService extends AbstractService<AdversaireDto> {

    public AdversaireDto updateAdversaire(AdversaireDto dto, Integer id);

    AdversaireDto findAdversaireByIceOuCin(String iceOuCin);

    List<AdversaireDto> findAdversaireByNomCompletOuRaisonSocial(String nomCompletOuRaisonSocial);

}
