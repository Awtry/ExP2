package com.awtry.exp2.presentation.foodDetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.awtry.exp2.R
import com.awtry.exp2.core.presentation.BaseFragment
import com.awtry.exp2.databinding.FootDetailFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings


@AndroidEntryPoint
@WithFragmentBindings
class FootDetail : BaseFragment(R.layout.foot_detail_fragment) {

    private lateinit var binding: FootDetailFragmentBinding
    private val args: FootDetailArgs by navArgs()

    override fun setBinding(view: View) {

        binding = FootDetailFragmentBinding.bind(view)

        binding.apply {
            lifecycleOwner = this@FootDetail
            detail = args.foodDetail
        }
    }


}