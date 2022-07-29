package com.example.inteli.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.inteli.R
import com.example.inteli.base.BaseViewHolder
import com.example.inteli.data.model.Drink
import com.example.inteli.databinding.TragosRowBinding

class MainAdapter(
    private val tragosList: List<Drink>,
    private val itemClickListener: OnTragoClickListener
) : RecyclerView.Adapter<BaseViewHolder<*>>() {

    interface OnTragoClickListener {
        fun onTragoClick(drink: Drink)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {

        return MainViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.tragos_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        when (holder) {
            is MainViewHolder -> holder.bind(tragosList[position], position)
        }
    }

    override fun getItemCount(): Int = tragosList.size

    inner class MainViewHolder(itemView: View) : BaseViewHolder<Drink>(itemView) {

        private val binding = TragosRowBinding.bind(itemView)

        override fun bind(item: Drink, position: Int) {
            Glide.with(binding.imgTrago.context).load(item.imagen).centerCrop()
                .into(binding.imgTrago)
            binding.txtTitulo.text = item.nombre
            binding.txtDescripcion.text = item.descripcion

            binding.imgTrago.setOnClickListener {
                Log.d("CLICK", "CLICKING")
                itemClickListener.onTragoClick(item)
            }

        }

    }

}