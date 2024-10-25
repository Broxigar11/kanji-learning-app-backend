package com.broxigar.kanji_learning_app_backend.kanji.repository;

import com.broxigar.kanji_learning_app_backend.kanji.entity.VocabularyEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyEntryRepository extends JpaRepository<VocabularyEntry, Long> {
}
