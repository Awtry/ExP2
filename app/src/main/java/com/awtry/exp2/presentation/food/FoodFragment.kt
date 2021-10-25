package com.awtry.exp2.presentation.food

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.awtry.exp2.R
import com.awtry.exp2.core.presentation.BaseFragment
import com.awtry.exp2.databinding.FoodFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.WithFragmentBindings
import kotlinx.coroutines.DelicateCoroutinesApi

@AndroidEntryPoint
@WithFragmentBindings
@DelicateCoroutinesApi
class FoodFragment : BaseFragment(R.layout.food_fragment) {

    private lateinit var binding: FoodFragmentBinding

    private val adapter: FoodAdapter by lazy { FoodAdapter() }
    //private val foodViewModel by viewModels<FoodViewModel>()

    override fun setBinding(view: View) {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.food_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //viewModel = ViewModelProvider(this).get(FoodViewModel::class.java)
        // TODO: Use the ViewModel
    }

}