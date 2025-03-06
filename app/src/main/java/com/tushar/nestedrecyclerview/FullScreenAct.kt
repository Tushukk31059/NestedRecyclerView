package com.tushar.nestedrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.tushar.nestedrecyclerview.databinding.ActivityFullScreenBinding

class FullScreenAct : AppCompatActivity() {
    private lateinit var binding:ActivityFullScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityFullScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val imgResId=intent.getIntExtra("Res_Id",0)
        if (imgResId!=0) {
            Glide.with(this)
                .load(imgResId)
                .into(binding.img)
            Glide.with(this)
                .load(imgResId)
                .into(binding.blurImg)
        }else{
            finish()
        }
        binding.root.setOnClickListener {
            finish()
        }
    }
}