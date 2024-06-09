package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.NatureAffaireDto;

public interface NatureAffaireService extends AbstractService<NatureAffaireDto>{

    NatureAffaireDto updateNatureAffaire(NatureAffaireDto dto, Integer id);
}
