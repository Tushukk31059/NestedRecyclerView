package com.tushar.nestedrecyclerview.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tushar.nestedrecyclerview.FullScreenAct
import com.tushar.nestedrecyclerview.databinding.PopularItemBinding
import com.tushar.nestedrecyclerview.domains.ViewDomain

class PopularAdapter(private val list: ArrayList<Int>):RecyclerView.Adapter<PopularAdapter.ViewHolder>() {
    class ViewHolder(val popularItemBinding: PopularItemBinding):RecyclerView.ViewHolder(popularItemBinding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val popularItemBinding=PopularItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(popularItemBinding)
    }

    override fun getItemCount(): Int {
       return Int.MAX_VALUE
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val actualPosition=position%list.size
        val imageResId=list[actualPosition]
        Glide.with(holder.itemView.context)
            .load(imageResId)
            .into(holder.popularItemBinding.pImg)
        holder.popularItemBinding.pImg.setOnClickListener {
            val context=holder.itemView.context
            val intent= Intent(context, FullScreenAct::class.java)
            intent.putExtra("Res_Id",imageResId)
            context.startActivity(intent)
        }
    }
}