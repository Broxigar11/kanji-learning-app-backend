package com.broxigar.kanji_learning_app_backend.kanji_library.entity;

import jakarta.persistence.*;
import lombok.*;

@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"composed_kanji_id", "component_kanji_id"})
)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class KanjiComposition {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "composed_kanji_id", referencedColumnName = "id", nullable = false)
    private Kanji composedKanji;

    @ManyToOne
    @JoinColumn(name = "component_kanji_id", referencedColumnName = "id", nullable = false)
    private Kanji componentKanji;

}


