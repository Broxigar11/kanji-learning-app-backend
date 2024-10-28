package com.broxigar.kanji_learning_app_backend.kanji_library.controller;

import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDetailsDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.service.KanjiService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class KanjiControllerImpl implements KanjiController {

    private final KanjiService kanjiService;

    @Override
    public ResponseEntity<KanjiDTO> getKanjiById(long id) {
        KanjiDTO kanjiDTO = kanjiService.getKanjiById(id);
        return ResponseEntity.ok(kanjiDTO);
    }

    @Override
    public ResponseEntity<KanjiDetailsDTO> getKanjiDetailsById(long id) {
        KanjiDetailsDTO kanjiDetailsDTO = kanjiService.getKanjiDetailsById(id);
        return ResponseEntity.ok(kanjiDetailsDTO);
    }

    @Override
    public ResponseEntity<KanjiDetailsDTO> getNextKanjiDetails(int orderNumber) {
        KanjiDetailsDTO kanjiDetailsDTO = kanjiService.getNextKanjiDetailsByOrderNumber(orderNumber);
        return ResponseEntity.ok(kanjiDetailsDTO);
    }

    @Override
    public ResponseEntity<List<KanjiDTO>> getKanjiPage(Integer startIndex, Integer pageSize) {
        List<KanjiDTO> kanjiList = kanjiService.getKanjiPage(startIndex, pageSize);
        return ResponseEntity.ok(kanjiList);
    }

    @Override
    public ResponseEntity<Void> createKanji(KanjiDetailsDTO kanjiDetailsDTO) {
        kanjiService.createKanji(kanjiDetailsDTO);
        return ResponseEntity.ok(null);
    }
}