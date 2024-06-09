package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.AffaireAdversaireDto;
import com.infotech.avocatech.entities.AffaireAdversaire;

public interface AffaireAdversaireService extends AbstractService<AffaireAdversaireDto>{

    public Integer updateAffaireAdversaire(AffaireAdversaireDto dto, Integer id);
}
