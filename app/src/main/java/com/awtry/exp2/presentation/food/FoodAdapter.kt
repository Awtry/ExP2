package com.awtry.exp2.presentation.food

import android.annotation.SuppressLint
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.awtry.exp2.domain.model.Food

@SuppressLint("NotifyDataSetChanged")
class FoodAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private var list: MutableList<Food> = mutableListOf()
    //TODO: Revisar la forma en la que se van a revisar los datos

    lateinit var listene: (food: Food) -> Unit


    fun addData(list: List<Food>){
        this.list = list.toMutableList()
        notifyDataSetChanged()
    }

    //TODO: Revisar dependiendo la forma de mostrar los datos agregar LAOUT TIPE

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