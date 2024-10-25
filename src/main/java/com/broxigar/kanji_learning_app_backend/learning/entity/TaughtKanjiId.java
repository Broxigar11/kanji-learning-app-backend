package com.broxigar.kanji_learning_app_backend.learning.entity;

import com.broxigar.kanji_learning_app_backend.kanji.entity.Kanji;
import com.broxigar.kanji_learning_app_backend.kanji.entity.VocabularyEntry;
import com.broxigar.kanji_learning_app_backend.user.entity.Users;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@Embeddable
public class TaughtKanjiId {
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;


    @ManyToOne
    @JoinColumn(name = "kanji_id", referencedColumnName = "id")
    private Kanji kanji;

}