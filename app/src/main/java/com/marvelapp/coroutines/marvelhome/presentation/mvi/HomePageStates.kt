package com.marvelapp.coroutines.marvelhome.presentation.mvi

import com.marvelapp.coroutines.marvelhome.data.entities.Results

sealed class HomePageStates {

    class SuccessState(val value: List<Results>) : HomePageStates()
    class ErrorState(val exception: Throwable) : HomePageStates()
    object LoadingState : HomePageStates()

}