package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.AffaireDto;
import com.infotech.avocatech.dto.TypeAffaireDto;
import com.infotech.avocatech.entities.Affaire;
import com.infotech.avocatech.entities.TypeAffaire;
import com.infotech.avocatech.entities.TypeAffaire;
import com.infotech.avocatech.repositories.TypeAffaireRepository;
import com.infotech.avocatech.services.TypeAffaireService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class TypeAffaireServiceImpl implements TypeAffaireService {

    private TypeAffaireRepository typeAffaireRepository;

    @Override
    public TypeAffaireDto save(TypeAffaireDto dto) {
        TypeAffaire typeaffaire = TypeAffaireDto.toEntity(dto);
        typeaffaire.setCreatedDate(LocalDateTime.now());
        typeaffaire.setLastModifiedDate(LocalDateTime.now());
        return TypeAffaireDto.fromEntity(typeAffaireRepository.save(typeaffaire));
    }

    @Override
    public List<TypeAffaireDto> findAll() {
        return typeAffaireRepository.findAll()
                .stream()
                .map(TypeAffaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TypeAffaireDto findById(Integer id) {
        return typeAffaireRepository.findById(id)
                .map(TypeAffaireDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No TypeAffaire found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        TypeAffaire typeAffaire = typeAffaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No TypeAffaire found with the ID : " + id));
        Integer deletedId = typeAffaire.getId();
        typeAffaireRepository.delete(typeAffaire);
        return deletedId;
    }

    @Override
    public TypeAffaireDto updateTypeAffaire(TypeAffaireDto typeAffaireDto, Integer id) {
        TypeAffaire typeAffaire = typeAffaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No TypeAffaire found with the ID : " + id));
        typeAffaire.setLastModifiedDate(LocalDateTime.now());
        typeAffaire.setIntitule(typeAffaireDto.getIntitule());
        return TypeAffaireDto.fromEntity(typeAffaireRepository.save(typeAffaire));
    }
}
