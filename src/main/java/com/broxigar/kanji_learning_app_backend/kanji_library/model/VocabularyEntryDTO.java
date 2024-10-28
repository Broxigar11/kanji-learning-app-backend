package com.broxigar.kanji_learning_app_backend.kanji_library.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VocabularyEntryDTO {

    @NotBlank
    private String word;

    @NotBlank
    private String meanings;

}
