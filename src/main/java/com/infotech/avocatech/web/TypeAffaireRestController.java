package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.TypeAffaireDto;
import com.infotech.avocatech.services.TypeAffaireService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeAffaires")
@RequiredArgsConstructor
@Tag(name = "typeAffaire")
public class TypeAffaireRestController {

    private final TypeAffaireService typeAffaireService;


    @PostMapping("/")
    public ResponseEntity<TypeAffaireDto> save(@RequestBody TypeAffaireDto typeAffaireDto) {
        return ResponseEntity.ok(typeAffaireService.save(typeAffaireDto));
    }

    @PutMapping("/{type-affaire-id}/update")
    public ResponseEntity<TypeAffaireDto> updateTypeAffaire(@PathVariable("type-affaire-id") Integer typeAffaireId, @RequestBody TypeAffaireDto typeAffaireDto) {
        TypeAffaireDto response = typeAffaireService.updateTypeAffaire(typeAffaireDto,typeAffaireId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeAffaireDto>> findAll() {
        return ResponseEntity.ok(typeAffaireService.findAll());
    }

    @GetMapping("/{type-affaire-id}")
    public ResponseEntity<TypeAffaireDto> findById(@PathVariable("type-affaire-id") Integer typeAffaireId) {
        return ResponseEntity.ok(typeAffaireService.findById(typeAffaireId));
    }

    @DeleteMapping("/{type-affaire-id}")
    public ResponseEntity<Integer> delete(@PathVariable("type-affaire-id") Integer typeAffaireId) {
        return ResponseEntity.ok(typeAffaireService.delete(typeAffaireId));
    }
}

