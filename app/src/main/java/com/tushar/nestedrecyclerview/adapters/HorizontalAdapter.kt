package com.tushar.nestedrecyclerview.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tushar.nestedrecyclerview.FullScreenAct
import com.tushar.nestedrecyclerview.databinding.HorizontalItemBinding
class HorizontalAdapter(private val list: ArrayList<Int>):RecyclerView.Adapter<HorizontalAdapter.ViewHolder>(){
    class ViewHolder (val horizontalItemBinding: HorizontalItemBinding):RecyclerView.ViewHolder(horizontalItemBinding.root){
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val horizontalItemBinding=HorizontalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(horizontalItemBinding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imageResId=list[position]
        Glide.with(holder.itemView.context)
            .load(imageResId)
            .into(holder.horizontalItemBinding.hImg)
        holder.horizontalItemBinding.hImg.setOnClickListener {
            val context=holder.itemView.context
            val intent= Intent(context,FullScreenAct::class.java)
            intent.putExtra("Res_Id",imageResId)
            context.startActivity(intent)
        }
    }

}