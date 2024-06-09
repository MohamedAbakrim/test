package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.AvocatDto;
import com.infotech.avocatech.dto.BureauDto;

import java.util.List;

public interface AvocatService extends AbstractService<AvocatDto>{

    List<AvocatDto> findAvocatByName(String name);

    AvocatDto updateAvocat(AvocatDto avocatDto, Integer id);

    AvocatDto addAvocat(AvocatDto avocatDto, Integer idBureau);

}
