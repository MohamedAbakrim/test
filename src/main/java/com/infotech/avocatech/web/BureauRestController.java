package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.BarreauDto;
import com.infotech.avocatech.dto.BureauDto;
import com.infotech.avocatech.services.BarreauService;
import com.infotech.avocatech.services.BureauService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bureaux")
@RequiredArgsConstructor
@Tag(name = "bureau")
public class BureauRestController {
    private final BureauService bureauService;

    @PostMapping("/{barreau-id}/barreau")
    public ResponseEntity<BureauDto> save(@RequestBody BureauDto bureauDto, @PathVariable("barreau-id") Integer barreauId) {
        return ResponseEntity.ok(bureauService.addBureau(bureauDto, barreauId));
    }

    @PutMapping("/{bureau-id}/update")
    public ResponseEntity<BureauDto> updateBureau(@PathVariable("bureau-id") Integer bureauId, @RequestBody BureauDto bureauDto) {
        BureauDto response = bureauService.updateBureau(bureauDto, bureauId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<BureauDto>> findAll() {
        return ResponseEntity.ok(bureauService.findAll());
    }

    @GetMapping("/{barreau-id}/barreau")
    public ResponseEntity<List<BureauDto>> findAllByBarreauId(@PathVariable("barreau-id") Integer barreauId) {
        return ResponseEntity.ok(bureauService.findAllBureausByBarreauID(barreauId));
    }

    @GetMapping("/{bureau-id}")
    public ResponseEntity<BureauDto> findById(@PathVariable("bureau-id") Integer bureauId) {
        return ResponseEntity.ok(bureauService.findById(bureauId));
    }

    @GetMapping("/{bureau-intitule}/intitule")
    public ResponseEntity<List<BureauDto>> findByIntitule(@PathVariable("bureau-intitule") String intitule) {
        return ResponseEntity.ok(bureauService.findBureauByIntitule(intitule));
    }

}
