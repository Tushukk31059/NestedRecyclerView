package com.tushar.nestedrecyclerview.adapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter

@BindingAdapter("imgRes")
fun setImage(view:ImageView,resId:Int){
    view.setImageResource(resId)

}