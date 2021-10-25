package com.awtry.exp2.presentation.food

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awtry.exp2.core.utils.LayoutType
import com.awtry.exp2.databinding.RowFoodBinding
import com.awtry.exp2.domain.model.Food

@SuppressLint("NotifyDataSetChanged")
class FoodAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var list: MutableList<Food> = mutableListOf()
    //TODO: Revisar la forma en la que se van a revisar los datos
    var layoutType = LayoutType.LINEAR

    lateinit var listener: (food: Food) -> Unit

    fun addData(list: List<Food>){
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    fun changeView(layoutType: LayoutType){
        this.layoutType = layoutType
        notifyDataSetChanged()
    }

    override fun getItemViewType(position: Int) = layoutType.ordinal

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = when (viewType) {
        //TODO: Encontrar la forma de poner el layout lineal simple
        LayoutType.LINEAR.ordinal -> ViewHolderItem(
            RowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
        else -> ViewHolderItem(
            //TODO: CAMBIAR ESTO EN CUANTO SEPA COMO HACERLO
            RowFoodBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) =
        (holder as BaseViewHolder).bind(list[position], listener)


    override fun getItemCount() = list.size

    //Para poder rellenar los datos, primero hay que inflarlos

    class ViewHolderItem(private val binding: RowFoodBinding) : BaseViewHolder(binding.root){
        override fun bind(data: Food, listener: (food: Food) -> Unit){
            binding.itemFood = data

            binding.root.setOnClickListener{
                listener(data)
            }

        }
    }

    abstract class BaseViewHolder(private val root: View) : RecyclerView.ViewHolder(root){
        abstract fun bind(data: Food, listener: (food: Food) -> Unit)
    }

}