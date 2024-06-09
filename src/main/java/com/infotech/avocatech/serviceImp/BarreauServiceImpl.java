package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.BarreauDto;
import com.infotech.avocatech.dto.BureauDto;
import com.infotech.avocatech.entities.Barreau;
import com.infotech.avocatech.entities.Bureau;
import com.infotech.avocatech.repositories.BarreauRepository;
import com.infotech.avocatech.repositories.BureauRepository;
import com.infotech.avocatech.services.BarreauService;
import com.infotech.avocatech.services.BureauService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class BarreauServiceImpl implements BarreauService {


    private BureauRepository bureauRepository;

    private BarreauRepository barreauRepository;

    @Override
    public BarreauDto save(BarreauDto dto) {
        Barreau barreau = BarreauDto.toEntity(dto);
        barreau.setCreatedDate(LocalDateTime.now());
        barreau.setLastModifiedDate(LocalDateTime.now());
        return BarreauDto.fromEntity(barreauRepository.save(barreau));
    }

    @Override
    public List<BarreauDto> findAll() {
        return barreauRepository.findAll()
                .stream()
                .map(BarreauDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BarreauDto findById(Integer id) {
        return barreauRepository.findById(id)
                .map(BarreauDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Barreau found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        return 0;
    }

    @Override
    public BarreauDto updateBarreau(BarreauDto barreauDto, Integer id) {
        Barreau barreau = barreauRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Barreau found with the ID : " + id));

        barreau.setLastModifiedDate(LocalDateTime.now());
        barreau.setIntitule(barreauDto.getIntitule());
        barreau.setVille(barreauDto.getVille());

        return BarreauDto.fromEntity(barreauRepository.save(barreau));

    }

    @Override
    public BarreauDto findBarreauByIntitule(String intitule) {
        BarreauDto barreauDto = BarreauDto.fromEntity(barreauRepository.findByIntituleContainsIgnoreCase(intitule));
        if (barreauDto == null) {
            throw new EntityNotFoundException("No Barreau found with the name : " + intitule);
        }
        return barreauDto;
    }
}
