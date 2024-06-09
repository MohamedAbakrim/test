package com.infotech.avocatech.dto;

import com.infotech.avocatech.entities.Client;
import com.infotech.avocatech.enumerations.TypePersonne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientDto {

    private Integer id;

    private TypePersonne typePersonne;

    private String nomCompletOuRaisonSocial;

    private String numTel;

    private String email;

    private String adresse;

    private String iceOuCin;

    private Boolean estRepresentant;

    public static ClientDto fromEntity(Client client) {
        return ClientDto.builder()
                .nomCompletOuRaisonSocial(client.getNomCompletOuRaisonSocial())
                .id(client.getId())
                .typePersonne(client.getTypePersonne())
                .numTel(client.getNumTel())
                .email(client.getEmail())
                .adresse(client.getAdresse())
                .iceOuCin(client.getIceOuCin())
                .estRepresentant(client.getEstRepresentant())
                .build();
    }

    public static Client toEntity(ClientDto clientDto) {
        return Client.builder()
                .id(clientDto.getId())
                .nomCompletOuRaisonSocial(clientDto.getNomCompletOuRaisonSocial())
                .typePersonne(clientDto.getTypePersonne())
                .numTel(clientDto.getNumTel())
                .email(clientDto.getEmail())
                .adresse(clientDto.getAdresse())
                .iceOuCin(clientDto.getIceOuCin())
                .estRepresentant(clientDto.getEstRepresentant())
                .build();
    }
}
