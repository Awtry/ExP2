package com.awtry.exp2.core.presentation

abstract class BaseViewState {

    //Para saber si realmente esta mostrandose algo, habrá que revisar aquí
    object ShowLoading : BaseViewState()
    object HideLoading : BaseViewState()
}