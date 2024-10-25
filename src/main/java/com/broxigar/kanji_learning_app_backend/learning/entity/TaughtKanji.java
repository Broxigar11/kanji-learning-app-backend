package com.broxigar.kanji_learning_app_backend.learning.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
public class TaughtKanji {
    @EmbeddedId
    private TaughtKanjiId id;

    private int review_streak;

    @Column(columnDefinition = "DATE DEFAULT CURRENT_DATE")
    private Date nextReviewDate;

    @Lob
    private String note;
}
