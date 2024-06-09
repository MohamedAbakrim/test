package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.ClientDto;
import com.infotech.avocatech.services.ClientService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Tag(name = "client")
public class ClientRestController {
    private final ClientService clientService;

    @PostMapping("/")
    public ResponseEntity<ClientDto> save(@RequestBody ClientDto clientDto) {
        return ResponseEntity.ok(clientService.save(clientDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<ClientDto>> findAll() {
        return ResponseEntity.ok(clientService.findAll());
    }

    @GetMapping("/{client-id}")
    public ResponseEntity<ClientDto> findById(@PathVariable("client-id") Integer clientId) {
        return ResponseEntity.ok(clientService.findById(clientId));
    }

    @GetMapping("/{nom-rs}/nom")
    public ResponseEntity<List<ClientDto>> findClientByNomCompletOuRaisonSocial(@PathVariable("nom-rs") String nomCompletOuRaisonSocial) {
        return ResponseEntity.ok(clientService.findClientByNomCompletOuRaisonSocial(nomCompletOuRaisonSocial));
    }

    @GetMapping("/{cin-ice}/identifiant")
    public ResponseEntity<ClientDto> findClientByCinOuIce(@PathVariable("cin-ice") String identifiant) {
        return ResponseEntity.ok(clientService.findClientByIceOuCin(identifiant));
    }

    @PutMapping("/{client-id}/update")
    public ResponseEntity<ClientDto> updateClient(@PathVariable("client-id") Integer clientId, @RequestBody ClientDto clientDto) {
        ClientDto response = clientService.updateClient(clientDto, clientId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{client-id}/delete")
    public ResponseEntity<Integer> delete(@PathVariable("client-id") Integer clientId) {
        return ResponseEntity.ok(clientService.delete(clientId));
    }
}
