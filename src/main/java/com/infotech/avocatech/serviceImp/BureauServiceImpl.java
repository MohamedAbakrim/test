package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.AvocatDto;
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

@AllArgsConstructor
@Service
@Transactional
public class BureauServiceImpl implements BureauService {

    private BureauRepository bureauRepository;

    private BarreauRepository barreauRepository;

    @Override
    public BureauDto save(BureauDto dto) {
        return null;
    }

    @Override
    public List<BureauDto> findAll() {
        return bureauRepository.findAll()
                .stream()
                .map(BureauDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public BureauDto findById(Integer id) {
        return bureauRepository.findById(id)
                .map(BureauDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No bureau found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        Bureau bureau = bureauRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No bureau found with the ID : " + id));
        Integer idDelete = bureau.getId();
        bureauRepository.delete(bureau);
        return idDelete;
    }

    @Override
    public BureauDto addBureau(BureauDto bureaudto, Integer barreauId) {
        Barreau barreau = barreauRepository.findById(barreauId).orElseThrow(() -> new EntityNotFoundException("Barreau not found with the ID : " + barreauId));
        Bureau bureau = BureauDto.toEntity(bureaudto);
        bureau.setCreatedDate(LocalDateTime.now());
        bureau.setBarreau(barreau);
        return BureauDto.fromEntity(bureauRepository.save(bureau));
    }

    @Override
    public BureauDto updateBureau(BureauDto bureauDto, Integer id) {
        Bureau bureau = bureauRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No bureau found with the ID : " + id));
        bureau.setLastModifiedDate(LocalDateTime.now());
        bureau.setAdresse(bureauDto.getAdresse());
        bureau.setFax(bureauDto.getFax());
        bureau.setEmail(bureauDto.getEmail());
        bureau.setNumTel(bureauDto.getNumTel());
        bureau.setIntitule(bureauDto.getIntitule());
        return BureauDto.fromEntity(bureauRepository.save(bureau));
    }

    @Override
    public List<BureauDto> findBureauByIntitule(String intitule) {
        List<BureauDto> bureauDto = null;
        try{
            bureauDto =  bureauRepository.findByIntituleIsContainingIgnoreCase(intitule)
                    .stream()
                    .map(BureauDto::fromEntity)
                    .collect(Collectors.toList());
        }catch (EntityNotFoundException exception){
            exception.getMessage();
        }

        return bureauDto;
    }

    @Override
    public List<BureauDto> findAllBureausByBarreauID(Integer barreauId) {
        return bureauRepository.findAllByBarreauId(barreauId)
                .stream()
                .map(BureauDto::fromEntity)
                .collect(Collectors.toList());
    }
}
