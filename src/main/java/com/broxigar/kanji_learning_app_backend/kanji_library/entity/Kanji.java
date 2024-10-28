package com.broxigar.kanji_learning_app_backend.kanji_library.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

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
    @Size(min = 1, max = 1)
    @Column(unique = true)
    private String kanjiCharacter;

    @NotBlank
    @Column(unique = true)
    private String name;

    @NotNull
    private int strokeCount;

    @Lob
    private String mnemonic;

    @NotNull
    @Column(unique = true)
    private int orderNumber;

    @OneToMany(mappedBy = "composedKanji", cascade = CascadeType.ALL)
    private List<KanjiComposition> components;

    @OneToMany(mappedBy = "componentKanji", cascade = CascadeType.ALL)
    private List<KanjiComposition> usedInCompositions;

    @OneToMany(mappedBy = "kanji", cascade = CascadeType.ALL)
    private List<KanjiReading> readings;

}
