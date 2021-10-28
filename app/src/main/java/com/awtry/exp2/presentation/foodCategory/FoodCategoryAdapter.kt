package com.awtry.exp2.presentation.foodCategory

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awtry.exp2.core.utils.LayoutType
import com.awtry.exp2.domain.model.Food
import com.awtry.exp2.domain.model.FoodCategory

class FoodCategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var listCat: MutableList<FoodCategory> = mutableListOf()
    var layoutType = LayoutType.LINEAR

    lateinit var listenerCategory: (foodCategory: FoodCategory) -> Unit

    fun addData(listCat: List<FoodCategory>) {
        this.listCat = listCat.toMutableList()

        notifyDataSetChanged()
    }

    fun changeView(layoutType: LayoutType) {
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}