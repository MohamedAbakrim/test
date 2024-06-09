package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.AffaireClientDto;
import com.infotech.avocatech.entities.AffaireClient;

public interface AffaireClientService extends AbstractService<AffaireClientDto>{

    public Integer updateAffaireClient(AffaireClientDto dto, Integer id);
}
