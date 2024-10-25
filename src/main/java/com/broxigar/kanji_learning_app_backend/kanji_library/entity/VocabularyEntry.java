package com.broxigar.kanji_learning_app_backend.kanji_library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class VocabularyEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank
    private String word;

    @Lob
    @NotBlank
    private String meanings;

    @NotEmpty
    @OneToMany(mappedBy = "id.vocabularyEntry", cascade = CascadeType.ALL)
    private List<KanjiReading> readings;
}
