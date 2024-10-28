package com.broxigar.kanji_learning_app_backend.kanji_library.repository;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.Kanji;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDTO;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface KanjiRepository extends JpaRepository<Kanji, Long> {

    @Query("""
        SELECT new com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDTO(k.id, k.kanjiCharacter, k.name)
        FROM Kanji k ORDER BY k.orderNumber ASC
    """)
    Page<KanjiDTO> findAllKanjiDTO(Pageable pageable);

    Optional<KanjiDTO> findKanjiDTOById(@NonNull Long id);

    Optional<Kanji> findFirstByOrderNumberGreaterThanOrderByOrderNumber(@NonNull Integer orderNumber);



}
