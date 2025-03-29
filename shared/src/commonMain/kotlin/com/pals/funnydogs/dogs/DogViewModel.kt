package com.pals.funnydogs.dogs

import com.pals.funnydogs.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DogViewModel(
    private val dogUseCase:DogUseCase

): BaseViewModel() {

    private val _dogState: MutableStateFlow<DogState> = MutableStateFlow(DogState(loading = true))
    val dogState:StateFlow<DogState> get() = _dogState

    init {
        scope.launch {
            repeat(108){
                getDogs()
                delay(timeMillis = 1500)
            }
        }
    }

    private fun getDogs() {
        scope.launch {
             val fetchDogs = dogUseCase.getDogApi()
            _dogState.emit(DogState(dog = fetchDogs))
        }
    }
}