package com.awtry.exp2.core.presentation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

import com.awtry.exp2.core.exception.Failure

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId), OnFailure {

    //Inyección de datos, no se inciializa hasta que se vaya a usar
    //TODO: Revisar lo del viewController, creo que se solucionara cuando vaya llenando los demás huecos
    val navController by lazy { findNavController() }
    val baseActivitiy by lazy { requireActivity() as BaseActivitiy }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Cuando otro fragmento quiera usarse, este lo pondra sin problema
        //hablando del menú inferior
        baseActivitiy.setUpNavigation(navController)
        setBinding(view)
    }

    abstract fun setBinding(view: View)

    //Esta función se puede usar o no, es una función abierta
    open fun onViewStateChanged(state: BaseViewState?) {
        when (state) {
            BaseViewState.ShowLoading -> showLoader(true)
            BaseViewState.HideLoading -> showLoader(false)
        }
    }

    open fun showLoader(show: Boolean) = baseActivitiy.showProgress(show)

    fun showToast(message: String) =
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()


    override fun handleFailure(failure: Failure?) {
        //lo que se hace en caso de un fallo
        when (failure) {
            Failure.DatabaseError -> {

            }
            is Failure.FeatureFailure -> {

            }
            Failure.NetworkConnection -> {

            }
            is Failure.ServerError -> {
                showToast(failure.serverMessage ?: "Ahh por parte del servdor, cuidado")
            }
            Failure.Unauthorized -> {

            }
            null -> {

            }
        }
    }

}