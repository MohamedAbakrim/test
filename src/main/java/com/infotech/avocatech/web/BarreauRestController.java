package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.BarreauDto;
import com.infotech.avocatech.dto.NatureAffaireDto;
import com.infotech.avocatech.services.BarreauService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/barreaux")
@RequiredArgsConstructor
@Tag(name = "barreau")
public class BarreauRestController {
    private final BarreauService barreauService;

    @PostMapping("/")
    public ResponseEntity<BarreauDto> save(@RequestBody BarreauDto barreauDto) {
        return ResponseEntity.ok(barreauService.save(barreauDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<BarreauDto>> findAll() {
        return ResponseEntity.ok(barreauService.findAll());
    }

    @GetMapping("/{barreau-id}")
    public ResponseEntity<BarreauDto> findById(@PathVariable("barreau-id") Integer barreauId) {
        return ResponseEntity.ok(barreauService.findById(barreauId));
    }

    @GetMapping("/{barreau-intitule}/intitule")
    public ResponseEntity<BarreauDto> findByIntitule(@PathVariable("barreau-intitule") String barreauIntitule) {
        return ResponseEntity.ok(barreauService.findBarreauByIntitule(barreauIntitule));
    }

    @PutMapping("/{barreau-id}/update")
    public ResponseEntity<BarreauDto> updateBarreau(@PathVariable("barreau-id") Integer barreauId, @RequestBody BarreauDto barreauDto) {
        BarreauDto response = barreauService.updateBarreau(barreauDto, barreauId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
