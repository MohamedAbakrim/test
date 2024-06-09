package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.BarreauDto;

public interface BarreauService extends AbstractService<BarreauDto>{

    BarreauDto updateBarreau(BarreauDto barreauDto, Integer id);

    BarreauDto findBarreauByIntitule(String intitule);
}
