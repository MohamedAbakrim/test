package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.AvocatDto;
import com.infotech.avocatech.dto.BarreauDto;
import com.infotech.avocatech.dto.BureauDto;
import com.infotech.avocatech.entities.Avocat;
import com.infotech.avocatech.entities.Barreau;
import com.infotech.avocatech.entities.Bureau;
import com.infotech.avocatech.repositories.AvocatRepository;
import com.infotech.avocatech.repositories.BarreauRepository;
import com.infotech.avocatech.services.AvocatService;
import com.infotech.avocatech.services.BureauService;
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
public class AvocatServiceImpl implements AvocatService {

    private AvocatRepository avocatRepository;
    private BureauService bureauService;
    @Override
    public AvocatDto save(AvocatDto dto) {
        return null;
    }

    @Override
    public List<AvocatDto> findAll() {
        return avocatRepository.findAll()
                .stream()
                .map(AvocatDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AvocatDto findById(Integer id) {
        return avocatRepository.findById(id)
                .map(AvocatDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Avocat found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        return 0;
    }

    @Override
    public List<AvocatDto> findAvocatByName(String name) {
        return avocatRepository.findAvocatsByNomContaining(name)
                .stream()
                .map(AvocatDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AvocatDto updateAvocat(AvocatDto avocatDto, Integer id) {
        Avocat avocat = avocatRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Avocat found with the ID : " + id));
        avocat.setLastModifiedDate(LocalDateTime.now());
        avocat.setNom(avocatDto.getNom());
        avocat.setPrenom(avocatDto.getPrenom());
        avocat.setEmail(avocatDto.getEmail());
        avocat.setNumTel(avocatDto.getNumTel());

        return AvocatDto.fromEntity(avocatRepository.save(avocat));
    }

    @Override
    public AvocatDto addAvocat(AvocatDto avocatDto, Integer idBureau) {
        BureauDto bureaudto = bureauService.findById(idBureau);
        Avocat avocat = AvocatDto.toEntity(avocatDto);
        avocat.setCreatedDate(LocalDateTime.now());
        avocat.setLastModifiedDate(LocalDateTime.now());
        avocat.setBureau(BureauDto.toEntity(bureaudto));
        return AvocatDto.fromEntity(avocatRepository.save(avocat));
    }
}
