package com.broxigar.kanji_learning_app_backend.kanji_library.repository;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.VocabularyEntry;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VocabularyEntryRepository extends JpaRepository<VocabularyEntry, Long> {

    Optional<VocabularyEntry> findByWord(String word);

    @Query("""
        SELECT v FROM KanjiReading r
        JOIN r.vocabularyEntry v
        WHERE r.kanji.id = :kanjiId
    """)
    List<VocabularyEntry> findAllByKanjiId(@Param("kanjiId") Long kanjiId);

    @Query("""
        SELECT v FROM KanjiReading r
        JOIN r.vocabularyEntry v
        WHERE r.kanji.id = :kanjiId AND r.romanization = :romanization
    """)
    List<VocabularyEntry> findAllByKanjiIdAndRomanization(
            @Param("kanjiId") @NonNull Long kanjiId,
            @Param("romanization") @NonNull String romanization
    );

}
