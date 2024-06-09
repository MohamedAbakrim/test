package com.infotech.avocatech.serviceImp;

import com.infotech.avocatech.dto.AvocatDto;
import com.infotech.avocatech.dto.ClientDto;
import com.infotech.avocatech.entities.Client;
import com.infotech.avocatech.repositories.ClientRepository;
import com.infotech.avocatech.services.ClientService;
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
public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    @Override
    public ClientDto save(ClientDto dto) {
        Client client = ClientDto.toEntity(dto);
        client.setCreatedDate(LocalDateTime.now());
        return ClientDto.fromEntity(clientRepository.save(client));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientRepository.findAll()
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto findById(Integer id) {
        return clientRepository.findById(id)
                .map(ClientDto::fromEntity)
                .orElseThrow(() -> new EntityNotFoundException("No Client found with the ID : " + id));
    }

    @Override
    public Integer delete(Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Client found with the ID : " + id));
        Integer deletedId = client.getId();
        clientRepository.delete(client);
        return deletedId;
    }

    @Override
    public ClientDto findClientByIceOuCin(String iceOuCin) {
        Client client = clientRepository.findClientByIceOuCinEquals(iceOuCin);
        if(client == null){
            throw new EntityNotFoundException("No Client found with the IceOuCin : " + iceOuCin);
        }
        return ClientDto.fromEntity(client);
    }

    @Override
    public List<ClientDto> findClientByNomCompletOuRaisonSocial(String nomCompletOuRaisonSocial) {
        return clientRepository.findClientByNomCompletOuRaisonSocialContainsIgnoreCase(nomCompletOuRaisonSocial)
                .stream()
                .map(ClientDto::fromEntity)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto updateClient(ClientDto clientDto, Integer id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("No Client found with the ID : " + id));

        client.setAdresse(clientDto.getAdresse());
        client.setEmail(clientDto.getEmail());
        client.setNumTel(clientDto.getNumTel());
        client.setEstRepresentant(clientDto.getEstRepresentant());
        client.setIceOuCin(clientDto.getIceOuCin());
        client.setTypePersonne(clientDto.getTypePersonne());
        client.setNomCompletOuRaisonSocial(clientDto.getNomCompletOuRaisonSocial());
        client.setLastModifiedDate(LocalDateTime.now());
        Client updatedClient = clientRepository.save(client);
        return ClientDto.fromEntity(updatedClient);
    }
}
