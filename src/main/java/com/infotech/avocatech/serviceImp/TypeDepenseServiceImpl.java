package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.TypeDepenseDto;
import com.infotech.avocatech.entities.TypeDepense;
import com.infotech.avocatech.repositories.TypeDepenseRepository;
import com.infotech.avocatech.services.TypeDepenseService;
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
public class TypeDepenseServiceImpl implements TypeDepenseService {

    private TypeDepenseRepository typeDepenseRepository;

    @Override
    public TypeDepenseDto save(TypeDepenseDto dto) {
        TypeDepense typeDepense = TypeDepenseDto.toEntity(dto);
        typeDepense.setCreatedDate(LocalDateTime.now());
        typeDepense.setLastModifiedDate(LocalDateTime.now());
        return TypeDepenseDto.fromEntity(typeDepenseRepository.save(typeDepense));
    }

    @Override
    public List<TypeDepenseDto> findAll() {
        return typeDepenseRepository.findAll()
                .stream()
                .map(TypeDepenseDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TypeDepenseDto findById(Integer id) {
        return typeDepenseRepository.findById(id)
                .map(TypeDepenseDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No TypeDepense found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        TypeDepense typeDepense = typeDepenseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No TypeDepense found with the ID : " + id));
        Integer deletedId = typeDepense.getId();
        typeDepenseRepository.delete(typeDepense);
        return deletedId;
    }

    @Override
    public TypeDepenseDto updateTypeDepense(TypeDepenseDto typeDepenseDto, Integer id) {
        TypeDepense typeDepense = typeDepenseRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No TypeDepense found with the ID : " + id));
        typeDepense.setLastModifiedDate(LocalDateTime.now());
        typeDepense.setIntitule(typeDepenseDto.getIntitule());
        return TypeDepenseDto.fromEntity(typeDepenseRepository.save(typeDepense));
    }
}
