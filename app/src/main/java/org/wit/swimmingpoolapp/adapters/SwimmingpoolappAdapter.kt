package org.wit.swimmingpoolapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import org.wit.swimmingpoolapp.databinding.CardSwimmingpoolappBinding
import org.wit.swimmingpoolapp.models.SwimmingpoolappModel



class SwimmingpoolappAdapter constructor(private var swimmingpoolapp: List<SwimmingpoolappModel>,
private val listener:SwimmingpoolappListener) :
    RecyclerView.Adapter<SwimmingpoolappAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        val binding = CardSwimmingpoolappBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)

        return MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val swimmingpoolapp = swimmingpoolapp[holder.adapterPosition]
        holder.bind(swimmingpoolapp, listener)
    }

    override fun getItemCount(): Int = swimmingpoolapp.size

    class MainHolder(private val binding : CardSwimmingpoolappBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(swimmingpoolapp: SwimmingpoolappModel, listener: SwimmingpoolappListener) {
            binding.swimmingpoolappTitle.text = swimmingpoolapp.title
            binding.description.text = swimmingpoolapp.description
            binding.root.setOnClickListener { listener.onSwmmingpoolappClick(swimmingpoolapp) }
        }
    }
}
interface SwimmingpoolappListener {
    fun onSwmmingpoolappClick(swimmingpoolapp: SwimmingpoolappModel)
}