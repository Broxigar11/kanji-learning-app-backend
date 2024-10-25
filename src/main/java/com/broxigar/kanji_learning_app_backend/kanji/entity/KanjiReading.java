package com.broxigar.kanji_learning_app_backend.kanji.entity;

import com.broxigar.kanji_learning_app_backend.kanji.common.ReadingFrequency;
import com.broxigar.kanji_learning_app_backend.kanji.common.ReadingType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class KanjiReading {
    @EmbeddedId
    private KanjiReadingId id;

    @NotBlank
    private String romanization;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReadingType type;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ReadingFrequency frequency;

}
