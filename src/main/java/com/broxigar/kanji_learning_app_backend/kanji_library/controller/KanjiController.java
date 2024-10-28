package com.broxigar.kanji_learning_app_backend.kanji_library.controller;

import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDetailsDTO;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/kanji")
public interface KanjiController {

    @GetMapping("/{id}")
    ResponseEntity<KanjiDTO> getKanjiById(@Valid @PathVariable long id);

    @GetMapping("/details/{id}")
    ResponseEntity<KanjiDetailsDTO> getKanjiDetailsById(@Valid @PathVariable long id);

    @GetMapping("/next/{orderNumber}")
    ResponseEntity<KanjiDetailsDTO> getNextKanjiDetails(@Valid @PathVariable int orderNumber);

    @GetMapping("/page")
    ResponseEntity<List<KanjiDTO>> getKanjiPage(
            @RequestParam(defaultValue = "0") @Min(0) Integer page,
            @RequestParam(defaultValue = "10") @Min(1) Integer pageSize
    );

    @PostMapping("/")
    ResponseEntity<Void> createKanji (@RequestBody KanjiDetailsDTO kanjiDTO);
}
