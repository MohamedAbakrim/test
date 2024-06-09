package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.TypeAffaireDto;

public interface TypeAffaireService extends AbstractService<TypeAffaireDto> {

    TypeAffaireDto updateTypeAffaire(TypeAffaireDto typeAffaireDto, Integer id);
}
