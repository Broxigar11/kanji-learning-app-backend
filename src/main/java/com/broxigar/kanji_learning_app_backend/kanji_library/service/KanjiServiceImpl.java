package com.broxigar.kanji_learning_app_backend.kanji_library.service;

import com.broxigar.kanji_learning_app_backend.kanji_library.entity.*;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiDetailsDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.KanjiReadingDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.model.VocabularyEntryDTO;
import com.broxigar.kanji_learning_app_backend.kanji_library.repository.KanjiCompositionRepository;
import com.broxigar.kanji_learning_app_backend.kanji_library.repository.KanjiReadingRepository;
import com.broxigar.kanji_learning_app_backend.kanji_library.repository.KanjiRepository;
import com.broxigar.kanji_learning_app_backend.kanji_library.repository.VocabularyEntryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KanjiServiceImpl implements KanjiService {

    private final KanjiRepository kanjiRepository;
    private final KanjiReadingRepository kanjiReadingRepository;
    private final VocabularyEntryRepository vocabularyRepository;
    private final KanjiCompositionRepository compositionRepository;

    @Override
    public List<KanjiDTO> getKanjiPage(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        List<KanjiDTO> kanjiDTOList = kanjiRepository.findAllKanjiDTO(pageable).getContent();

        if (kanjiDTOList.isEmpty()) {
            throw new EntityNotFoundException("No Kanji found for the requested page.");
        }

        return kanjiDTOList;
    }

    @Override
    public KanjiDTO getKanjiById(Long id) {
        return kanjiRepository.findKanjiDTOById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kanji not found with id: " + id));
    }

    @Override
    @Transactional(readOnly = true)
    public KanjiDetailsDTO getNextKanjiDetailsByOrderNumber(Integer orderNumber) {
        Kanji nextKanji = kanjiRepository.findFirstByOrderNumberGreaterThanOrderByOrderNumber(orderNumber)
                .orElseThrow(() -> new EntityNotFoundException("No next Kanji found for order number " + orderNumber));

        return convertToKanjiDetailsDTO(nextKanji);
    }

    @Override
    @Transactional(readOnly = true)
    public KanjiDetailsDTO getKanjiDetailsById(Long id) {
        Kanji nextKanji = kanjiRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Kanji not found with id: " + id));

        return convertToKanjiDetailsDTO(nextKanji);
    }

    @Override
    public KanjiDetailsDTO createKanji(KanjiDetailsDTO kanjiDetailsDTO) {
        Kanji kanji = kanjiRepository.save(convertToKanji(kanjiDetailsDTO));

        createKanjiComposition(kanji, kanjiDetailsDTO.getComponents());

        kanjiDetailsDTO.getReadings().forEach(kanjiReadingDTO -> {
            List<VocabularyEntry> vocabularyEntries = kanjiReadingDTO.getVocabulary().stream()
                    .map(this::createOrGetVocabularyEntry)
                    .collect(Collectors.toList());
            createKanjiReading(kanji, kanjiReadingDTO, vocabularyEntries);
        });

        return kanjiDetailsDTO;
    }

    private VocabularyEntry createOrGetVocabularyEntry(VocabularyEntryDTO vocabularyEntryDTO) {
        return vocabularyRepository.findByWord(vocabularyEntryDTO.getWord())
                .orElseGet(() -> vocabularyRepository.save(
                        VocabularyEntry.builder()
                                .word(vocabularyEntryDTO.getWord())
                                .meanings(vocabularyEntryDTO.getMeanings())
                                .build()
                ));
    }

    private void createKanjiReading(Kanji kanji, KanjiReadingDTO kanjiReadingDTO, List<VocabularyEntry> vocabularyEntries) {
        vocabularyEntries.forEach(vocabularyEntry -> kanjiReadingRepository.save(
                KanjiReading.builder()
                        .kanji(kanji)
                        .vocabularyEntry(vocabularyEntry)
                        .romanization(kanjiReadingDTO.getRomanization())
                        .type(kanjiReadingDTO.getType())
                        .frequency(kanjiReadingDTO.getFrequency())
                        .build()
        ));
    }

    private void createKanjiComposition(Kanji composedKanji, List<KanjiDTO> componentDTOList) {
        componentDTOList.forEach(componentDTO -> {
            Kanji componentKanji =  kanjiRepository.findById(componentDTO.getId())
                    .orElseThrow(() -> new EntityNotFoundException("Kanji not found with id: " + componentDTO.getId()));

            compositionRepository.save(KanjiComposition.builder()
                    .composedKanji(composedKanji)
                    .componentKanji(componentKanji)
                    .build()
            );
        });
    }

    private Kanji convertToKanji(KanjiDetailsDTO kanjiDetailsDTO) {
        return Kanji.builder()
                .kanjiCharacter(kanjiDetailsDTO.getKanjiCharacter())
                .name(kanjiDetailsDTO.getName())
                .strokeCount(kanjiDetailsDTO.getStrokeCount())
                .mnemonic(kanjiDetailsDTO.getMnemonic())
                .build();
    }

    private KanjiDetailsDTO convertToKanjiDetailsDTO(Kanji kanji) {
        return KanjiDetailsDTO.builder()
                .id(kanji.getId())
                .kanjiCharacter(kanji.getKanjiCharacter())
                .name(kanji.getName())
                .strokeCount(kanji.getStrokeCount())
                .mnemonic(kanji.getMnemonic())
                .orderNumber(kanji.getOrderNumber())
                .components(mapComponents(kanji.getComponents()))
                .usedInCompositions(mapPartOfCompositions(kanji.getUsedInCompositions()))
                .readings(mapReadings(kanji.getReadings(), kanji.getId()))
                .build();
    }

    private List<KanjiDTO> mapComponents(List<KanjiComposition> components) {
        return components.stream()
                .map(comp -> new KanjiDTO(comp.getComponentKanji().getId(), comp.getComponentKanji().getKanjiCharacter(), comp.getComponentKanji().getName()))
                .collect(Collectors.toList());
    }

    private List<KanjiDTO> mapPartOfCompositions(List<KanjiComposition> componentOf) {
        return componentOf.stream()
                .map(comp -> new KanjiDTO(comp.getComposedKanji().getId(), comp.getComposedKanji().getKanjiCharacter(), comp.getComposedKanji().getName()))
                .collect(Collectors.toList());
    }

    private List<KanjiReadingDTO> mapReadings(List<KanjiReading> readings, long kanjiId) {
        return readings.stream()
                .map(reading -> new KanjiReadingDTO(
                        reading.getRomanization(),
                        reading.getType(),
                        reading.getFrequency(),
                        mapVocabularyEntries(vocabularyRepository.findAllByKanjiIdAndRomanization(
                                kanjiId,
                                reading.getRomanization()
                        ))
                ))
                .collect(Collectors.toList());
    }

    private List<VocabularyEntryDTO> mapVocabularyEntries(List<VocabularyEntry> vocabulary) {
        return vocabulary.stream()
                .map(entry -> new VocabularyEntryDTO(
                        entry.getWord(),
                        entry.getMeanings()
                ))
                .collect(Collectors.toList());
    }
}
