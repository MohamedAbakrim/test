package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.AffaireDto;

import java.util.List;

public interface AffaireService extends AbstractService<AffaireDto>{

    public AffaireDto findByNumeroAffaire(String numeroAffaire);

    public List<AffaireDto> findAllByBureau(Integer idBureau);

    public Integer updateAffaire(AffaireDto affaireDto, Integer idBureau);
}
