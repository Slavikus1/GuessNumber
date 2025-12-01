package com.example.guessnumber.domain.domain.usecases

import com.example.guessnumber.domain.domain.entity.GameSettings
import com.example.guessnumber.domain.domain.entity.Levels
import com.example.guessnumber.domain.domain.repository.GuessNumberRepository

class GetGameSettingsUseCase(private val repository: GuessNumberRepository) {
    operator fun invoke(level: Levels): GameSettings {
        return repository.getGameSettings(level)
    }
}