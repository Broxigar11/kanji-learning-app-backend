package com.broxigar.kanji_learning_app_backend.kanji_library.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KanjiDetailsDTO {

    @NotBlank
    private long id;

    @NotBlank
    @Size(min = 1, max = 1)
    private String character;

    @NotBlank
    private String name;

    @NotNull
    private int strokeCount;

    private String mnemonic;

    private int orderNumber;

    private List<KanjiDTO> components;

    private List<KanjiDTO> partOfCompositions;

    @NotEmpty
    private List<KanjiReadingDTO> readings;

}
