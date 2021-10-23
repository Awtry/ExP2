package com.awtry.exp2.core.presentation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController

abstract class BaseActivitiy : AppCompatActivity() {

    abstract fun layoutId(): Int
    abstract val fragmentContainerView: FragmentContainerView

    abstract fun setUpNavigation(navController: NavController)

    abstract fun showProgress(show: Boolean)

    abstract fun setBinding()

}