package com.example.guessnumber.domain.domain.repository

import com.example.guessnumber.domain.domain.entity.GameSettings
import com.example.guessnumber.domain.domain.entity.Levels
import com.example.guessnumber.domain.domain.entity.Question

interface GuessNumberRepository {

    fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question

    fun getGameSettings(level: Levels): GameSettings
}