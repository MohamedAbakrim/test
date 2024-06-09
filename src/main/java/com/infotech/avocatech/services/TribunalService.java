package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.TribunalDto;

public interface TribunalService extends AbstractService<TribunalDto>{

    TribunalDto updateTribunal(TribunalDto tribunalDto, Integer tribunalId);
}
