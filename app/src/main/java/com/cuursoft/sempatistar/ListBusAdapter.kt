package com.cuursoft.sempatistar

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListBusAdapter(private val listBus: ArrayList<Bus>) :
    RecyclerView.Adapter<ListBusAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_bus, viewGroup, false)
        return ListViewHolder(view)
    }
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (clas, fas, pict) = listBus[position]
        Glide.with(holder.itemView.context)
            .load(pict)
            .apply(RequestOptions().override(70, 70))
            .into(holder.pictbus)
        holder.busclas.text = clas
        holder.busFas.text = fas

        holder.itemView.setOnClickListener { onItemClickCallback.onItemClicked(listBus[holder.adapterPosition]) }
    }

    override fun getItemCount(): Int {
        return listBus.size
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var busclas: TextView = itemView.findViewById(R.id.class_bus)
        var busFas: TextView = itemView.findViewById(R.id.fas_bus)
        var pictbus: ImageView = itemView.findViewById(R.id.img_bus)
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Bus)
    }

}