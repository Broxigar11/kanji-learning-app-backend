package com.broxigar.kanji_learning_app_backend.kanji_library.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public class VocabularyEntryDTO {

    @NotBlank
    private String word;

    @NotBlank
    private String meanings;

    @NotEmpty
    private List<KanjiDTO> containedKanji;

}
