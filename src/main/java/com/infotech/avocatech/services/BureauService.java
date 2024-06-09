package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.BureauDto;

import java.util.List;

public interface BureauService extends AbstractService<BureauDto>{

    BureauDto addBureau(BureauDto bureau, Integer barreauId);

    BureauDto updateBureau(BureauDto bureauDto, Integer id);

    List<BureauDto> findBureauByIntitule(String intitule);

    List<BureauDto> findAllBureausByBarreauID(Integer barreauId);
}
