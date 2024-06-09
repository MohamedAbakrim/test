package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.AvocatDto;
import com.infotech.avocatech.dto.BarreauDto;
import com.infotech.avocatech.services.AvocatService;
import com.infotech.avocatech.services.BarreauService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avocats")
@RequiredArgsConstructor
@Tag(name = "avocat")
public class AvocatRestController {
    private final AvocatService avocatService;

    @PostMapping("/bureau/{id-bureau}")
    public ResponseEntity<AvocatDto> save(@RequestBody AvocatDto avocatDto, @PathVariable("id-bureau") Integer idBureau) {
        return ResponseEntity.ok(avocatService.addAvocat(avocatDto, idBureau));
    }

    @GetMapping("/")
    public ResponseEntity<List<AvocatDto>> findAll() {
        return ResponseEntity.ok(avocatService.findAll());
    }

    @GetMapping("/{avocat-id}")
    public ResponseEntity<AvocatDto> findById(@PathVariable("avocat-id") Integer avocatId) {
        return ResponseEntity.ok(avocatService.findById(avocatId));
    }

    @GetMapping("/{avocat-nom}/nom")
    public ResponseEntity<List<AvocatDto>> findAvocatByName(@PathVariable("avocat-nom") String nom) {
        return ResponseEntity.ok(avocatService.findAvocatByName(nom));
    }

    @PutMapping("/{avocat-id}/update")
    public ResponseEntity<AvocatDto> updateAvocat(@PathVariable("avocat-id") Integer avocatId, @RequestBody AvocatDto avocatDto) {
        AvocatDto response = avocatService.updateAvocat(avocatDto, avocatId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping("/{avocat-id}/delete")
    public ResponseEntity<Integer> delete(@PathVariable("avocat-id") Integer avocatId) {
        return ResponseEntity.ok(avocatService.delete(avocatId));
    }
}
