package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.NatureAffaireDto;
import com.infotech.avocatech.dto.NatureAffaireDto;
import com.infotech.avocatech.entities.Client;
import com.infotech.avocatech.entities.NatureAffaire;
import com.infotech.avocatech.repositories.NatureAffaireRepository;
import com.infotech.avocatech.services.NatureAffaireService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class NatureAffaireServiceImpl implements NatureAffaireService {
  
    private NatureAffaireRepository natureAffaireRepository;

    @Override
    public NatureAffaireDto save(NatureAffaireDto dto) {
        NatureAffaire natureAffaire = NatureAffaireDto.toEntity(dto);
        natureAffaire.setCreatedDate(LocalDateTime.now());
        natureAffaire.setLastModifiedDate(LocalDateTime.now());
        return NatureAffaireDto.fromEntity(natureAffaireRepository.save(natureAffaire));
    }

    @Override
    public List<NatureAffaireDto> findAll() {
        return natureAffaireRepository.findAll()
                .stream()
                .map(NatureAffaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public NatureAffaireDto findById(Integer id) {
        return natureAffaireRepository.findById(id)
                .map(NatureAffaireDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No NatureAffaire found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        NatureAffaire natureAffaire = natureAffaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No NatureAffaire found with the ID : " + id));
        Integer deletedId = natureAffaire.getId();
        natureAffaireRepository.delete(natureAffaire);
        return deletedId;
    }

    @Override
    public NatureAffaireDto updateNatureAffaire(NatureAffaireDto dto, Integer id) {
        NatureAffaire natureAffaire = natureAffaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No NatureAffaire found with the ID : " + id));
        natureAffaire.setLastModifiedDate(LocalDateTime.now());
        natureAffaire.setIntitule(dto.getIntitule());
        return NatureAffaireDto.fromEntity(natureAffaireRepository.save(natureAffaire));
    }
}
