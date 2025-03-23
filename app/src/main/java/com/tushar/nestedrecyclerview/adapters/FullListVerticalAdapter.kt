package com.tushar.nestedrecyclerview.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tushar.nestedrecyclerview.FullScreenAct
import com.tushar.nestedrecyclerview.databinding.RecyclerActItemBinding

class FullListVerticalAdapter(private val list:ArrayList<Int>):RecyclerView.Adapter<FullListVerticalAdapter.VerticalHolder>(){

    class VerticalHolder(val recyclerActItemBinding: RecyclerActItemBinding):RecyclerView.ViewHolder(recyclerActItemBinding.root) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VerticalHolder {
        val binding=RecyclerActItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return VerticalHolder(binding)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: VerticalHolder, position: Int) {
        val imageResId=list[position]
        Glide.with(holder.itemView.context)
            .load(imageResId)
            .into(holder.recyclerActItemBinding.img)
            holder.recyclerActItemBinding.img.setOnClickListener {
                val context=holder.itemView.context
                val intent= Intent(context, FullScreenAct::class.java)
                intent.putIntegerArrayListExtra("imageList",list)
                intent.putExtra("position",position)
                context.startActivity(intent)
            }
    }
}