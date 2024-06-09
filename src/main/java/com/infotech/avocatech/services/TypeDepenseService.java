package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.TypeDepenseDto;
import com.infotech.avocatech.entities.TypeDepense;

public interface TypeDepenseService extends AbstractService<TypeDepenseDto>{

    TypeDepenseDto updateTypeDepense(TypeDepenseDto typeDepenseDto, Integer id);

}
