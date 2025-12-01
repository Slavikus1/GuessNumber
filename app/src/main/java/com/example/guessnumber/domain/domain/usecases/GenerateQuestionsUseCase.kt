package com.example.guessnumber.domain.domain.usecases

import com.example.guessnumber.domain.domain.entity.Question
import com.example.guessnumber.domain.domain.repository.GuessNumberRepository

class GenerateQuestionsUseCase(private val repository: GuessNumberRepository) {

    operator fun invoke(maxSumValue: Int): Question {
        return repository.generateQuestion(maxSumValue, MAX_VARIANTS)
    }

    private companion object {
        private const val MAX_VARIANTS = 6
    }
}