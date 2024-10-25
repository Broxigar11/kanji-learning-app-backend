package com.broxigar.kanji_learning_app_backend.kanji_library.repository;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.VocabularyEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VocabularyEntryRepository extends JpaRepository<VocabularyEntry, Long> {
}
