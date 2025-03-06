package com.tushar.nestedrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tushar.nestedrecyclerview.adapters.Adapter
import com.tushar.nestedrecyclerview.adapters.FullListVerticalAdapter
import com.tushar.nestedrecyclerview.databinding.ActivityRecyclerBinding
import com.tushar.nestedrecyclerview.domains.ViewDomain

class RecyclerAct : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    private val listItem=ArrayList<ViewDomain>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding=ActivityRecyclerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val categoryName=intent.getStringExtra("Category_Name")
        val imgList=when(categoryName){
            "Demon Slayer"-> arrayListOf(R.drawable.demon_slayer,R.drawable.demon_slayer_2,R.drawable.demon_slayer_3,
                R.drawable.demon_slayer_4,R.drawable.demon_slayer_5,R.drawable.demon_slayer_6,
                R.drawable.demon_slayer_7,R.drawable.demon_slayer_8,R.drawable.demon_slayer_9,
                R.drawable.demon_slayer_10,R.drawable.demon_slayer_11,R.drawable.demon_slayer_12,
                R.drawable.demon_slayer_13,R.drawable.demon_slayer_14,R.drawable.demon_slayer_15,
                R.drawable.demon_slayer_16)
            "Your Name"-> arrayListOf( R.drawable.your_name_4,R.drawable.your_name_5,R.drawable.your_name_6,
                R.drawable.your_name_7,R.drawable.your_name_8,R.drawable.your_name_9,
                R.drawable.your_name_10,R.drawable.your_name_11,R.drawable.your_name_12,
                R.drawable.your_name_13,R.drawable.your_name_14,R.drawable.your_name_15
                ,R.drawable.your_name_16,R.drawable.your_name_17)
            "Attack On Titan"-> arrayListOf(R.drawable.aot,R.drawable.aot2,R.drawable.aot3,
                R.drawable.aot4,R.drawable.aot5,R.drawable.aot6,R.drawable.aot7,
                R.drawable.aot8,R.drawable.aot9)
            "Naruto"->arrayListOf(R.drawable.naruto,R.drawable.naruto2,R.drawable.naruto3,
                R.drawable.naruto4,R.drawable.naruto5,R.drawable.naruto6,R.drawable.naruto7,
                R.drawable.naruto8,R.drawable.naruto9,R.drawable.naruto10,R.drawable.naruto11,
                R.drawable.naruto12,R.drawable.naruto13,R.drawable.naruto14,R.drawable.naruto15,
                R.drawable.naruto16,R.drawable.naruto17,R.drawable.naruto18)
            else-> arrayListOf()
        }
        val verticalAdapter=FullListVerticalAdapter(imgList)
        binding.recycler.adapter=verticalAdapter
        binding.recycler.layoutManager= LinearLayoutManager(this)

    }
}