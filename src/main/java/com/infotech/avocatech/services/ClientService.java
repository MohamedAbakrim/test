package com.infotech.avocatech.services;

import com.infotech.avocatech.dto.ClientDto;

import java.util.List;

public interface ClientService extends AbstractService<ClientDto>{

    ClientDto findClientByIceOuCin(String iceOuCin);

    List<ClientDto> findClientByNomCompletOuRaisonSocial(String nomCompletOuRaisonSocial);

    ClientDto updateClient(ClientDto clientDto, Integer id);
}
