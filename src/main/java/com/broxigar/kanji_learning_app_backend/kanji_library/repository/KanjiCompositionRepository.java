package com.broxigar.kanji_learning_app_backend.kanji_library.repository;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.KanjiComposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KanjiCompositionRepository extends JpaRepository<KanjiComposition, Long> {

}
