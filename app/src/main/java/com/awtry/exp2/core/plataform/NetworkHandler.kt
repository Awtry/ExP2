package com.awtry.exp2.core.plataform

import android.content.Context
import com.awtry.exp2.core.extension.networkInfo
import javax.inject.Inject

class NetworkHandler @Inject constructor(private val context: Context){

    val isConnected get() = context.networkInfo?.isConnectedOrConnecting == true
}