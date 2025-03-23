package com.tushar.nestedrecyclerview.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tushar.nestedrecyclerview.R

class FullScreenActViewModel : ViewModel() {
    private val imageList = MutableLiveData<ArrayList<Int>>()
    val currentImage = MutableLiveData<Int>()
    private var currentIndex = 0
    fun setImg(img: ArrayList<Int>, position: Int) {
        imageList.value = img
        currentIndex = position
        currentImage.value = img[position]
    }

    fun changeImg() {
        val img = imageList.value
        if (img != null) {
            if (img.isNotEmpty()) {
                currentIndex = (currentIndex + 1) % img.size
                currentImage.value = img[currentIndex]
            }
        }
    }
}