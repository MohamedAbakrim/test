package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.AffaireClientDto;
import com.infotech.avocatech.dto.AffaireTribunalDto;
import com.infotech.avocatech.entities.AffaireTribunal;

public interface AffaireTribunalService extends AbstractService<AffaireTribunalDto>{

    public Integer updateAffaireTrbibunal(AffaireTribunalDto dto, Integer id);
}
