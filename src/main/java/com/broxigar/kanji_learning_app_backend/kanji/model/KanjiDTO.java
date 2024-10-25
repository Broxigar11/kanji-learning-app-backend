package com.broxigar.kanji_learning_app_backend.kanji.model;

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

    @NotBlank
    private long id;

    @NotBlank
    @Size(min = 1, max = 1)
    private String character;

    @NotBlank
    private String name;

}
