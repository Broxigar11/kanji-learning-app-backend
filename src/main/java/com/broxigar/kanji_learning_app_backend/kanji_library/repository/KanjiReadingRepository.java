package com.broxigar.kanji_learning_app_backend.kanji_library.repository;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.KanjiReading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KanjiReadingRepository extends JpaRepository<KanjiReading, Long> {
}
