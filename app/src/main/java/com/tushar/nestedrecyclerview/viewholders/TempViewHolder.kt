package com.tushar.nestedrecyclerview.viewholders

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.tushar.nestedrecyclerview.adapters.HorizontalAdapter
import com.tushar.nestedrecyclerview.adapters.PopularAdapter
import com.tushar.nestedrecyclerview.databinding.HorizontalViewBinding
import com.tushar.nestedrecyclerview.databinding.PopularViewBinding
import com.tushar.nestedrecyclerview.databinding.VerticalItemBinding
import com.tushar.nestedrecyclerview.domains.ViewDomain

sealed class TempViewHolder(binding:ViewBinding):RecyclerView.ViewHolder(binding.root){
    abstract fun bind(viewObj:ViewDomain)
    class HorizontalViewHolder(private val horizontalBinding: HorizontalViewBinding):TempViewHolder(horizontalBinding){
        override fun bind(viewObj: ViewDomain){

            val list=(viewObj as ViewDomain.HorizontalView).list
            horizontalBinding.hRecycler.adapter= HorizontalAdapter(list)
            horizontalBinding.hRecycler.layoutManager=LinearLayoutManager(horizontalBinding.root.context,LinearLayoutManager.HORIZONTAL,false)
            horizontalBinding.hRecycler.setHasFixedSize(true)
            horizontalBinding.hRecycler.itemAnimator=null
        }
    }
    class VerticalViewHolder
        (private val verticalItemBinding: VerticalItemBinding,
         private val onCategoryClick:(String)->Unit
                ):TempViewHolder(verticalItemBinding){
        override fun bind(viewObj: ViewDomain) {
            val categoryName=(viewObj as ViewDomain.VerticalView).name
            verticalItemBinding.vTv.text=categoryName
            verticalItemBinding.root.setOnClickListener {
                onCategoryClick(categoryName)
            }
        }
    }
    class PopularViewHolder(private val popularViewBinding: PopularViewBinding):TempViewHolder(popularViewBinding){
        override fun bind(viewObj: ViewDomain) {
            val list=(viewObj as ViewDomain.PopularView).list
            popularViewBinding.pRecycler.adapter= PopularAdapter(list)
            popularViewBinding.pRecycler.layoutManager=LinearLayoutManager(popularViewBinding.root.context,LinearLayoutManager.HORIZONTAL,false)
            popularViewBinding.pRecycler.setHasFixedSize(true)
            popularViewBinding.pRecycler.itemAnimator=null
            val snapHelper=LinearSnapHelper()
            snapHelper.attachToRecyclerView(popularViewBinding.pRecycler)
            val middle=Int.MAX_VALUE/2
            val startPosition=middle-(middle%list.size)
            popularViewBinding.pRecycler.scrollToPosition(startPosition)
        }

    }
}
