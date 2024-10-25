package com.broxigar.kanji_learning_app_backend.user.entity;

import com.broxigar.kanji_learning_app_backend.user.common.ScriptType;
import com.broxigar.kanji_learning_app_backend.user.common.UserLevel;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @NotBlank
    @Column(unique = true)
    private String email;

    @NotBlank
    private String passwordHash;

    @NotBlank
    private String username;

    private int lastTaughtKanjiOrderNumber;

    @NotBlank
    private ScriptType preferredScript;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private UserLevel level;
}
