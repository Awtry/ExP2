package com.awtry.exp2.core.presentation

import com.awtry.exp2.core.exception.Failure

interface OnFailure {

    fun handleFailure(failure: Failure?)
}