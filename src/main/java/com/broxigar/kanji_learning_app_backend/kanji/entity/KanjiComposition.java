package com.broxigar.kanji_learning_app_backend.kanji.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KanjiComposition {

    @Id
    @ManyToOne
    @JoinColumn(name = "composed_kanji_id", referencedColumnName = "id", nullable = false)
    private Kanji composedKanji;

    @Id
    @ManyToOne
    @JoinColumn(name = "component_kanji_id", referencedColumnName = "id", nullable = false)
    private Kanji componentKanji;

}


