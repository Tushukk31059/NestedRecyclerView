package com.tushar.nestedrecyclerview

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tushar.nestedrecyclerview.adapters.Adapter
import com.tushar.nestedrecyclerview.adapters.FullListVerticalAdapter
import com.tushar.nestedrecyclerview.databinding.ActivityRecyclerBinding
import com.tushar.nestedrecyclerview.domains.ViewDomain

class RecyclerAct : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= DataBindingUtil.setContentView(this,R.layout.activity_recycler)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val demonSlayerList=intent.getIntegerArrayListExtra("DemonSlayerList")
        val aotList=intent.getIntegerArrayListExtra("AotList")
        val narutoList=intent.getIntegerArrayListExtra("NarutoList")
        val yourNameList=intent.getIntegerArrayListExtra("YourNameList")
        val categoryName=intent.getStringExtra("Category_Name")
        val imgList=when(categoryName){
            "Demon Slayer"->demonSlayerList?: arrayListOf()
            "Your Name"-> yourNameList?: arrayListOf()
            "Attack On Titan"-> aotList?: arrayListOf()
            "Naruto"->narutoList?: arrayListOf()
            else-> arrayListOf()
        }
        val verticalAdapter=FullListVerticalAdapter(imgList)
        binding.recycler.adapter=verticalAdapter
        binding.recycler.layoutManager= LinearLayoutManager(this)

    }
}