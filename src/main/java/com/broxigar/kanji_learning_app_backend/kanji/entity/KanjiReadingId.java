package com.broxigar.kanji_learning_app_backend.kanji.entity;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Embeddable
public class KanjiReadingId implements Serializable {
    @ManyToOne
    @JoinColumn(name = "kanji_id", referencedColumnName = "id")
    private Kanji kanji;

    @ManyToOne
    @JoinColumn(name = "vocabulary_entry_id", referencedColumnName = "id")
    private VocabularyEntry vocabularyEntry;
}
