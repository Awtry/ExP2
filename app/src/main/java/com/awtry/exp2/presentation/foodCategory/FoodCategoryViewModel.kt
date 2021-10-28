package com.awtry.exp2.presentation.foodCategory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.awtry.exp2.core.exception.Failure
import com.awtry.exp2.core.presentation.BaseViewState

class FoodCategoryViewModel : ViewModel() {
    var state: MutableLiveData<BaseViewState> = MutableLiveData()
    var failure: MutableLiveData<Failure> = MutableLiveData()

    protected fun handleFailure(failure: Failure) {
        this.failure.value = failure
        state.value = BaseViewState.HideLoading
    }

}