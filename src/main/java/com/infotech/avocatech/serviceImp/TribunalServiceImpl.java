package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.TribunalDto;
import com.infotech.avocatech.entities.Tribunal;
import com.infotech.avocatech.repositories.TribunalRepository;
import com.infotech.avocatech.services.TribunalService;
import com.infotech.avocatech.services.TribunalService;
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
public class TribunalServiceImpl implements TribunalService {
  
    private TribunalRepository tribunalRepository;

    @Override
    public TribunalDto save(TribunalDto dto) {
        Tribunal tribunal = TribunalDto.toEntity(dto);
        tribunal.setCreatedDate(LocalDateTime.now());
        tribunal.setLastModifiedDate(LocalDateTime.now());
        return TribunalDto.fromEntity(tribunalRepository.save(tribunal));
    }

    @Override
    public List<TribunalDto> findAll() {
        return tribunalRepository.findAll()
                .stream()
                .map(TribunalDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public TribunalDto findById(Integer id) {
        return tribunalRepository.findById(id)
                .map(TribunalDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Tribunal found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        Tribunal tribunal = tribunalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Tribunal found with the ID : " + id));
        Integer deletedId = tribunal.getId();
        tribunalRepository.delete(tribunal);
        return deletedId;
    }

    @Override
    public TribunalDto updateTribunal(TribunalDto dto, Integer id) {
        Tribunal tribunal = tribunalRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Tribunal found with the ID : " + id));
        tribunal.setLastModifiedDate(LocalDateTime.now());
        tribunal.setTypeTribunal(dto.getTypeTribunal());
        tribunal.setVille(dto.getVille());
        return TribunalDto.fromEntity(tribunalRepository.save(tribunal));
    }
}
