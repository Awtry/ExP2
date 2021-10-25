package com.awtry.exp2


import android.os.Bundle
import androidx.core.view.isVisible
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.awtry.exp2.core.presentation.BaseActivitiy
import com.awtry.exp2.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivitiy() {

    private lateinit var binding: ActivityMainBinding

    //Para que tome la posición del nuevo layout dependiendo de quien llegue
    override fun layoutId() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setBinding()
    }

    override val fragmentContainerView: FragmentContainerView
        get() = binding.MainBase

    override fun setUpNavigation(navController: NavController) =
        NavigationUI.setupWithNavController(binding.MenuInferior, navController)

    override fun showProgress(show: Boolean) {
        binding.progresiveView.isVisible = show
    }

    override fun setBinding() {
        binding = DataBindingUtil.setContentView(this, layoutId())
    }


}