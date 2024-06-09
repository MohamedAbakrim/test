package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.TypeDepenseDto;
import com.infotech.avocatech.services.TypeDepenseService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/typeDepenses")
@RequiredArgsConstructor
@Tag(name = "typeDepense")
public class TypeDepenseRestController {

    private final TypeDepenseService typeDepenseService;


    @PostMapping("/")
    public ResponseEntity<TypeDepenseDto> save(@RequestBody TypeDepenseDto typeDepenseDto) {
        return ResponseEntity.ok(typeDepenseService.save(typeDepenseDto));
    }

    @PutMapping("/{type-depense-id}/update")
    public ResponseEntity<TypeDepenseDto> updateTypeDepense(@PathVariable("type-depense-id") Integer typeDepenseId, @RequestBody TypeDepenseDto typeDepenseDto) {
        TypeDepenseDto response = typeDepenseService.updateTypeDepense(typeDepenseDto,typeDepenseId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TypeDepenseDto>> findAll() {
        return ResponseEntity.ok(typeDepenseService.findAll());
    }

    @GetMapping("/{type-depense-id}")
    public ResponseEntity<TypeDepenseDto> findById(@PathVariable("type-depense-id") Integer typeDepenseId) {
        return ResponseEntity.ok(typeDepenseService.findById(typeDepenseId));
    }

    @DeleteMapping("/{type-depense-id}")
    public ResponseEntity<Integer> delete(@PathVariable("type-depense-id") Integer typeDepenseId) {
        return ResponseEntity.ok(typeDepenseService.delete(typeDepenseId));
    }
}

