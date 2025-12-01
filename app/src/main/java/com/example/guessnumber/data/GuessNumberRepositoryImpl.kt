package com.example.guessnumber.data

import com.example.guessnumber.domain.domain.entity.GameSettings
import com.example.guessnumber.domain.domain.entity.Levels
import com.example.guessnumber.domain.domain.entity.Question
import com.example.guessnumber.domain.domain.repository.GuessNumberRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GuessNumberRepositoryImpl : GuessNumberRepository {

    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestion(maxSumValue: Int, countOfOptions: Int): Question {
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        val options = HashSet<Int>()
        val rightAnswer = sum - visibleNumber
        options.add(rightAnswer)
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Levels): GameSettings {
        return when (level) {
            Levels.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }
            Levels.EASY -> {
                GameSettings(
                    10,
                    10,
                    70,
                    60
                )
            }
            Levels.NORMAL -> {
                GameSettings(
                    20,
                    20,
                    80,
                    40
                )
            }
            Levels.HARD -> {
                GameSettings(
                    30,
                    30,
                    90,
                    40
                )
            }
        }
    }
}