package com.awtry.exp2.core.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awtry.exp2.core.exception.Failure

abstract class BaseViewModel : ViewModel() {

    //Cuando estas variables mutan, se notifica a todas las vistas
    var state: MutableLiveData<BaseViewState> = MutableLiveData()
    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure){
        this.failure.value = failure
        state.value = BaseViewState.HideLoading
    }

}