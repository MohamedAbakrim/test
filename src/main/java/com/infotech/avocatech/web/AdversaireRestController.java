package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.AdversaireDto;
import com.infotech.avocatech.entities.Adversaire;
import com.infotech.avocatech.services.AdversaireService;
import com.infotech.avocatech.services.AdversaireService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/adversaires")
@RequiredArgsConstructor
@Tag(name = "adversaire")
public class AdversaireRestController {
    private final AdversaireService adversaireService;

    @PostMapping("/")
    public ResponseEntity<AdversaireDto> save(@RequestBody AdversaireDto adversaireDto) {
        return ResponseEntity.ok(adversaireService.save(adversaireDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AdversaireDto>> findAll() {
        return ResponseEntity.ok(adversaireService.findAll());
    }

    @GetMapping("/{adversaire-id}")
    public ResponseEntity<AdversaireDto> findById(@PathVariable("adversaire-id") Integer adversaireId) {
        return ResponseEntity.ok(adversaireService.findById(adversaireId));
    }

    @GetMapping("/{nom-rs}/nom")
    public ResponseEntity<List<AdversaireDto>> findAdversaireByNomCompletOuRaisonSocial(@PathVariable("nom-rs") String nomCompletOuRaisonSocial) {
        return ResponseEntity.ok(adversaireService.findAdversaireByNomCompletOuRaisonSocial(nomCompletOuRaisonSocial));
    }

    @GetMapping("/{cin-ice}/identifiant")
    public ResponseEntity<AdversaireDto> findAdversaireByCinOuIce(@PathVariable("cin-ice") String identifiant) {
        return ResponseEntity.ok(adversaireService.findAdversaireByIceOuCin(identifiant));
    }

    @PutMapping("/{adversaire-id}/update")
    public ResponseEntity<AdversaireDto> updateAdversaire(@PathVariable("adversaire-id") Integer adversaireId, @RequestBody AdversaireDto adversaireDto) {
        AdversaireDto response = adversaireService.updateAdversaire(adversaireDto, adversaireId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{adversaire-id}/delete")
    public ResponseEntity<Integer> delete(@PathVariable("adversaire-id") Integer adversaireId) {
        return ResponseEntity.ok(adversaireService.delete(adversaireId));
    }
}
