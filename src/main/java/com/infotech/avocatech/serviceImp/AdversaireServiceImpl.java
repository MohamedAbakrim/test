package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.AdversaireDto;
import com.infotech.avocatech.dto.BarreauDto;
import com.infotech.avocatech.entities.Adversaire;
import com.infotech.avocatech.entities.Barreau;
import com.infotech.avocatech.repositories.AdversaireRepository;
import com.infotech.avocatech.services.AdversaireService;
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
public class AdversaireServiceImpl implements AdversaireService {

    private AdversaireRepository adversaireRepository;

    @Override
    public AdversaireDto save(AdversaireDto dto) {
        Adversaire adversaire = AdversaireDto.toEntity(dto);
        adversaire.setCreatedDate(LocalDateTime.now());
        adversaire.setLastModifiedDate(LocalDateTime.now());
        return AdversaireDto.fromEntity(adversaireRepository.save(adversaire));
    }

    @Override
    public List<AdversaireDto> findAll() {
        return adversaireRepository.findAll()
                .stream()
                .map(AdversaireDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public AdversaireDto findById(Integer id) {
        return adversaireRepository.findById(id)
                .map(AdversaireDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Adversaire found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        Adversaire adversaire = adversaireRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Adversaire found with the ID : " + id));
        Integer idDeleted = adversaire.getId();
        adversaireRepository.delete(adversaire);
        return idDeleted;
    }

    @Override
    public AdversaireDto updateAdversaire(AdversaireDto dto, Integer id) {
        AdversaireDto adversaireDto = this.findById(id);
        adversaireDto.setNomCompleOuRaisonSocial(dto.getNomCompleOuRaisonSocial());
        adversaireDto.setTypePersonne(dto.getTypePersonne());
        adversaireDto.setAdresse(dto.getAdresse());
        adversaireDto.setEmail(dto.getEmail());
        adversaireDto.setNumTel(dto.getNumTel());
        adversaireDto.setIceOuCin(dto.getIceOuCin());
        Adversaire updatedAdversaire = AdversaireDto.toEntity(adversaireDto);
        updatedAdversaire.setLastModifiedDate(LocalDateTime.now());
        return AdversaireDto.fromEntity(adversaireRepository.save(updatedAdversaire));
    }

    @Override
    public AdversaireDto findAdversaireByIceOuCin(String iceOuCin) {
        Adversaire adversaire = adversaireRepository.findAdversaireByIceOuCinEquals(iceOuCin);
        if (adversaire == null) {
            throw new EntityNotFoundException("Adversaire found with the ID : " + adversaire.getId());
        }
        return AdversaireDto.fromEntity(adversaire);
    }

    @Override
    public List<AdversaireDto> findAdversaireByNomCompletOuRaisonSocial(String nomCompletOuRaisonSocial) {
        return adversaireRepository.findAdversaireByNomCompleOuRaisonSocialContainsIgnoreCase(nomCompletOuRaisonSocial)
                .stream()
                .map(AdversaireDto::fromEntity)
                .collect(Collectors.toList());
    }
}
