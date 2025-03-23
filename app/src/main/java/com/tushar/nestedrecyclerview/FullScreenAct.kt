package com.tushar.nestedrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.tushar.nestedrecyclerview.databinding.ActivityFullScreenBinding
import com.tushar.nestedrecyclerview.viewmodels.FullScreenActViewModel

class FullScreenAct : AppCompatActivity() {
    private lateinit var binding:ActivityFullScreenBinding
    private lateinit var viewModel: FullScreenActViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_full_screen)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        viewModel=ViewModelProvider(this)[FullScreenActViewModel::class.java]
        binding.lifecycleOwner=this
        binding.viewModel=viewModel
        val imageList=intent.getIntegerArrayListExtra("imageList")?: arrayListOf()
        val position=intent.getIntExtra("position",0)
        viewModel.setImg(imageList,position)
//        val imgResId=intent.getIntExtra("Res_Id",0)
//        if (imgResId!=0) {
//            binding.img.setImageResource(imgResId)
//        }else{
//            finish()
//        }
//        binding.root.setOnClickListener {
//            finish()
//        }
    }
}