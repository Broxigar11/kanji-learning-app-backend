package com.broxigar.kanji_learning_app_backend.kanji_library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class Kanji {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank
    private String kanjiCharacter;

    @NotBlank
    private String name;

    @NotNull
    private int strokeCount;

    @Lob
    private String mnemonic;

    @Column(unique = true)
    private int orderNumber;

    @OneToMany(mappedBy = "composedKanji", cascade = CascadeType.ALL)
    private List<KanjiComposition> components;

    @OneToMany(mappedBy = "componentKanji", cascade = CascadeType.ALL)
    private List<KanjiComposition> usedInCompositions;

    @OneToMany(mappedBy = "id.kanji", cascade = CascadeType.ALL)
    private List<KanjiReading> readings;

}
