package com.infotech.avocatech.web;


import com.infotech.avocatech.dto.AffaireDto;
import com.infotech.avocatech.services.AffaireService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/affaires")
@RequiredArgsConstructor
@Tag(name = "affaire")
public class AffaireRestController {

    private final AffaireService affaireService;

    @PostMapping("/")
    public ResponseEntity<AffaireDto> save(@RequestBody AffaireDto affaireDto) {
        return ResponseEntity.ok(affaireService.save(affaireDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<AffaireDto>> findAll() {
        return ResponseEntity.ok(affaireService.findAll());
    }

    @GetMapping("/{bureau-id}/bureau")
    public ResponseEntity<List<AffaireDto>> findAllByBureau(@PathVariable("bureau-id") Integer bureauId) {
        return ResponseEntity.ok(affaireService.findAllByBureau(bureauId));
    }

    @GetMapping("/{affaire-id}/affaire")
    public ResponseEntity<AffaireDto> findById(@PathVariable("affaire-id") Integer affaireId) {
        return ResponseEntity.ok(affaireService.findById(affaireId));
    }

    @GetMapping("/{numAffaire}")
    public ResponseEntity<AffaireDto> findById(@PathVariable("numAffaire") String numAffaire) {
        return ResponseEntity.ok(affaireService.findByNumeroAffaire(numAffaire));
    }

    @DeleteMapping("/{affaire-id}")
    public ResponseEntity<Integer> delete(@PathVariable("affaire-id") Integer affaireId) {
        return ResponseEntity.ok(affaireService.delete(affaireId));
    }


}
