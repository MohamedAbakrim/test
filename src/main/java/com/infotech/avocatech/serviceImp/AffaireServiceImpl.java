package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.AffaireDto;
import com.infotech.avocatech.entities.*;
import com.infotech.avocatech.repositories.AffaireRepository;
import com.infotech.avocatech.repositories.BureauRepository;
import com.infotech.avocatech.repositories.NatureAffaireRepository;
import com.infotech.avocatech.repositories.TypeAffaireRepository;
import com.infotech.avocatech.services.AffaireService;
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
public class AffaireServiceImpl implements AffaireService {

    private AffaireRepository affaireRepository;
    private BureauRepository bureauRepository;
    private NatureAffaireRepository natureAffaireRepository;
    private TypeAffaireRepository typeAffaireRepository;

    @Override
    public AffaireDto findByNumeroAffaire(String numeroAffaire) {
        Affaire affaire = affaireRepository.findByNumeroAffaire(numeroAffaire).orElseThrow(() -> new EntityNotFoundException("No Affaire found with numero Affaire: " + numeroAffaire));
        return AffaireDto.fromEntity(affaire);
    }

    @Override
    public List<AffaireDto> findAllByBureau(Integer idBureau) {
        Bureau bureau = bureauRepository.findById(idBureau).get();
        return affaireRepository.findAllByBureau(bureau)
                .stream()
                .map(AffaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AffaireDto save(AffaireDto dto) {
        Affaire affaire = AffaireDto.toEntity(dto);
        affaire.setCreatedDate(LocalDateTime.now());
        affaire.setLastModifiedDate(LocalDateTime.now());
        return AffaireDto.fromEntity(affaireRepository.save(affaire));
    }

    @Override
    public List<AffaireDto> findAll() {
        return affaireRepository.findAll()
                .stream()
                .map(AffaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AffaireDto findById(Integer id) {
        return affaireRepository.findById(id)
                .map(AffaireDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Affaire found with the ID : " + id));
    }

    @Override
    public Integer updateAffaire(AffaireDto affaireDto, Integer idBureau){
        Bureau bureau = bureauRepository.findById(idBureau).orElseThrow(() -> new EntityNotFoundException("No Bureau found with ID : " + idBureau));
        Affaire affaire = affaireRepository.findById(affaireDto.getId()).orElseThrow(() -> new EntityNotFoundException("No Affaire found with ID : " + affaireDto.getId()));
        if(affaire.getBureau().getId() != bureau.getId()) {
            throw new EntityNotFoundException("The Affaire with ID " + affaire.getId() + "does not belong to the Bureau with ID " + bureau.getId());
        }
        NatureAffaire natureAffaire = natureAffaireRepository.findById(affaireDto.getIdNatureAffaire()).orElseThrow(() -> new EntityNotFoundException("No NatureAffaire found with ID : " + affaireDto.getIdNatureAffaire()));
        TypeAffaire typeAffaire = typeAffaireRepository.findById(affaireDto.getIdTypeAffaire()).orElseThrow(() -> new EntityNotFoundException("No TypeAffaire found with ID : " + affaireDto.getIdTypeAffaire()));
        affaire.setNumeroAffaire(affaireDto.getNumeroAffaire());
        affaire.setTitre(affaireDto.getTitre());
        affaire.setSujet(affaireDto.getSujet());
        affaire.setObservations(affaireDto.getObservations());
        affaire.setNatureAffaire(natureAffaire);
        affaire.setTypeAffaire(typeAffaire);
        affaire.setLastModifiedDate(LocalDateTime.now());
        return affaireRepository.save(affaire).getId();
    }

    @Override
    public Integer delete(Integer id) {
        Affaire affaire = affaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No affaire found with the ID : " + id));
        Integer idDeleted = affaire.getId();
        affaireRepository.delete(affaire);
        return idDeleted;
    }

}
