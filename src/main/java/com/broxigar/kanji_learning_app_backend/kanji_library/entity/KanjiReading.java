package com.broxigar.kanji_learning_app_backend.kanji_library.entity;

import com.broxigar.kanji_learning_app_backend.kanji_library.common.ReadingFrequency;
import com.broxigar.kanji_learning_app_backend.kanji_library.common.ReadingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"kanji_id", "vocabulary_entry_id", "romanization"})
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class KanjiReading {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "kanji_id", referencedColumnName = "id")
    private Kanji kanji;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vocabulary_entry_id", referencedColumnName = "id")
    private VocabularyEntry vocabularyEntry;

    @NotBlank
    private String romanization;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReadingType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReadingFrequency frequency;

}
