package com.broxigar.kanji_learning_app_backend.kanji_library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.util.ArrayList;
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
    @Column(unique = true)
    private String word;

    @Lob
    @NotBlank
    private String meanings;

    @OneToMany(mappedBy = "vocabularyEntry", cascade = CascadeType.ALL)
    private List<KanjiReading> readings;

}
