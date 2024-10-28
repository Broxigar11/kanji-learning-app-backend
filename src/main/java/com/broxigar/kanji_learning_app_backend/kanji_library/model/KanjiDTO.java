package com.broxigar.kanji_learning_app_backend.kanji_library.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanjiDTO {

    private long id;

    @NotBlank
    @Size(min = 1, max = 1)
    private String kanjiCharacter;

    @NotBlank
    private String name;

}
