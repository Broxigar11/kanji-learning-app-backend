package com.broxigar.kanji_learning_app_backend.kanji_library.model;

import com.broxigar.kanji_learning_app_backend.kanji_library.common.ReadingFrequency;
import com.broxigar.kanji_learning_app_backend.kanji_library.common.ReadingType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanjiReadingDTO {

    @NotBlank
    private String romanization;

    @NotNull
    private ReadingType type;

    @NotNull
    private ReadingFrequency frequency;

    @NotNull
    private List<VocabularyEntryDTO> vocabulary;

}
