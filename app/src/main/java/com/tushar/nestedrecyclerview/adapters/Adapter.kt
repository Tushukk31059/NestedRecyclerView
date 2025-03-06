package com.tushar.nestedrecyclerview.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tushar.nestedrecyclerview.databinding.HorizontalViewBinding
import com.tushar.nestedrecyclerview.databinding.PopularItemBinding
import com.tushar.nestedrecyclerview.databinding.PopularViewBinding
import com.tushar.nestedrecyclerview.databinding.VerticalItemBinding
import com.tushar.nestedrecyclerview.domains.ViewDomain
import com.tushar.nestedrecyclerview.viewholders.TempViewHolder

class Adapter (private val listItem:ArrayList<ViewDomain>,private val onCategoryClick:(String)->Unit):RecyclerView.Adapter<TempViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TempViewHolder {
        when(viewType){
            1->{
                val horizontalViewBinding=HorizontalViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
                return TempViewHolder.HorizontalViewHolder(horizontalViewBinding)
            }2->{
            val verticalItemBinding= VerticalItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return TempViewHolder.VerticalViewHolder(verticalItemBinding,onCategoryClick)
        }else->{
            val popularViewBinding= PopularViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
            return TempViewHolder.PopularViewHolder(popularViewBinding)
        }

        }
    }

    override fun getItemCount(): Int {
        return listItem.size
    }

    override fun onBindViewHolder(holder: TempViewHolder, position: Int) {
        holder.bind(listItem[position])
    }

    override fun getItemViewType(position: Int): Int {
        return when(listItem[position]){
            is ViewDomain.HorizontalView ->1
            is ViewDomain.VerticalView ->2
            is ViewDomain.PopularView->3
            is ViewDomain.FullListVerticalView->4
        }
    }
}