package com.broxigar.kanji_learning_app_backend.kanji_library.service;

import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDetailsDTO;

import java.util.List;

public interface KanjiService {

    List<KanjiDTO> getKanjiPage(Integer page, Integer pageSize);

    KanjiDTO getKanjiById(Long id);

    KanjiDetailsDTO getNextKanjiDetailsByOrderNumber(Integer orderNumber);

    KanjiDetailsDTO getKanjiDetailsById(Long id);

    KanjiDetailsDTO createKanji(KanjiDetailsDTO kanjiDetailsDTO);

}
