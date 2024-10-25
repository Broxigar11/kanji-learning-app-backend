package com.broxigar.kanji_learning_app_backend.kanji_library.repository;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.Kanji;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long> {
    Optional<Kanji> findById(long id);
}