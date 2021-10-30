package com.awtry.exp2.presentation.foodCategory

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awtry.exp2.core.utils.LayoutType
import com.awtry.exp2.databinding.GridCategoryBinding
import com.awtry.exp2.databinding.RowFoodBinding
import com.awtry.exp2.domain.model.Food
import com.awtry.exp2.domain.model.FoodCategory
import com.awtry.exp2.presentation.food.FoodAdapter

@SuppressLint("NotifyDataSetChanged")
class FoodCategoryAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var listCategory: MutableList<FoodCategory> = mutableListOf()
    var layoutType = LayoutType.GRID
    lateinit var listener: (foodCategory: FoodCategory) -> Unit

    fun addDataCategory(listCategory: List<FoodCategory>) {
        this.listCategory = listCategory.toMutableList()
        notifyDataSetChanged()
    }

    fun changeView(layoutType: LayoutType) {
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        //TODO: Encontrar la forma de poner el layout lineal simple
        LayoutType.GRID.ordinal -> FoodCategoryAdapter.ViewHolderItem(
            GridCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        else -> FoodCategoryAdapter.ViewHolderItem(
            //TODO: CAMBIAR ESTO EN CUANTO SEPA COMO HACERLO
            GridCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder).bind(listCategory[position], listener)

    override fun getItemCount() = listCategory.size

    //Para poder rellenar los datos, primero hay que inflarlos

    class ViewHolderItem(private val binding: GridCategoryBinding) : BaseViewHolder(binding.root) {
        override fun bind(data: FoodCategory, listener: (foodCategory: FoodCategory) -> Unit) {
            binding.itemCategory = data

            binding.root.setOnClickListener {
                listener(data)
            }
        }
    }

    abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root) {
        abstract fun bind(data: FoodCategory, listener: (foodCategory: FoodCategory) -> Unit)
    }


}