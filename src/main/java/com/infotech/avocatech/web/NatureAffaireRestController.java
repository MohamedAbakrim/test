package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.NatureAffaireDto;
import com.infotech.avocatech.dto.TypeAffaireDto;
import com.infotech.avocatech.services.NatureAffaireService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/natureAffaires")
@RequiredArgsConstructor
@Tag(name = "natureAffaire")
public class NatureAffaireRestController {

    private final NatureAffaireService natureAffaireService;


    @PostMapping("/")
    public ResponseEntity<NatureAffaireDto> save(@RequestBody NatureAffaireDto natureAffaireDto) {
        return ResponseEntity.ok(natureAffaireService.save(natureAffaireDto));
    }

    @PutMapping("/{nature-affaire-id}/update")
    public ResponseEntity<NatureAffaireDto> updateNatureAffaire(@PathVariable("nature-affaire-id") Integer natureAffaireId, @RequestBody NatureAffaireDto natureAffaireDto) {
        NatureAffaireDto response = natureAffaireService.updateNatureAffaire(natureAffaireDto,natureAffaireId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<NatureAffaireDto>> findAll() {
        return ResponseEntity.ok(natureAffaireService.findAll());
    }

    @GetMapping("/{nature-affaire-id}")
    public ResponseEntity<NatureAffaireDto> findById(@PathVariable("nature-affaire-id") Integer natureAffaireId) {
        return ResponseEntity.ok(natureAffaireService.findById(natureAffaireId));
    }

    @DeleteMapping("/{nature-affaire-id}")
    public ResponseEntity<Integer> delete(@PathVariable("nature-affaire-id") Integer natureAffaireId) {
        return ResponseEntity.ok(natureAffaireService.delete(natureAffaireId));
    }
}

