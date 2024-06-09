package com.infotech.avocatech.web;

import com.infotech.avocatech.dto.TribunalDto;
import com.infotech.avocatech.services.TribunalService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tribunals")
@RequiredArgsConstructor
@Tag(name = "tribunal")
public class TribunalRestController {

    private final TribunalService tribunalService;


    @PostMapping("/")
    public ResponseEntity<TribunalDto> save(@RequestBody TribunalDto tribunalDto) {
        return ResponseEntity.ok(tribunalService.save(tribunalDto));
    }

    @PutMapping("/{tribunal-id}/update")
    public ResponseEntity<TribunalDto> updateTribunal(@PathVariable("tribunal-id") Integer tribunalId, @RequestBody TribunalDto tribunalDto) {
        TribunalDto response = tribunalService.updateTribunal(tribunalDto,tribunalId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<TribunalDto>> findAll() {
        return ResponseEntity.ok(tribunalService.findAll());
    }

    @GetMapping("/{tribunal-id}")
    public ResponseEntity<TribunalDto> findById(@PathVariable("tribunal-id") Integer tribunalId) {
        return ResponseEntity.ok(tribunalService.findById(tribunalId));
    }

    @DeleteMapping("/{tribunal-id}")
    public ResponseEntity<Integer> delete(@PathVariable("tribunal-id") Integer tribunalId) {
        return ResponseEntity.ok(tribunalService.delete(tribunalId));
    }
}

