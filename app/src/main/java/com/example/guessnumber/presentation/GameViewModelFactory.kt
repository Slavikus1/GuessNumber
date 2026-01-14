package com.example.guessnumber.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.guessnumber.domain.domain.entity.Levels

class GameViewModelFactory(
    private val level: Levels,
    private val context: Application,
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)){
            return GameViewModel(context, level) as T
        }
        throw RuntimeException("unknown view model")
    }
}