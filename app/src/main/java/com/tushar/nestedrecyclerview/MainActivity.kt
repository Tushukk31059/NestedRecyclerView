package com.tushar.nestedrecyclerview

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tushar.nestedrecyclerview.adapters.Adapter
import com.tushar.nestedrecyclerview.databinding.ActivityMainBinding
import com.tushar.nestedrecyclerview.domains.ViewDomain

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val itemList=ArrayList<ViewDomain>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        setupRecyclerView()
    }
    private fun setupRecyclerView(){
        val demonSlayerList= arrayListOf(
            R.drawable.demon_slayer,R.drawable.demon_slayer_2,R.drawable.demon_slayer_3,
            R.drawable.demon_slayer_4,R.drawable.demon_slayer_5,R.drawable.demon_slayer_6,
            R.drawable.demon_slayer_7,R.drawable.demon_slayer_8,R.drawable.demon_slayer_9,
            R.drawable.demon_slayer_10,R.drawable.demon_slayer_11,R.drawable.demon_slayer_12,
            R.drawable.demon_slayer_13,R.drawable.demon_slayer_14,R.drawable.demon_slayer_15,
            R.drawable.demon_slayer_16)
        val yourNameList= arrayOf(R.drawable.your_name,R.drawable.your_name_2,R.drawable.your_name_3,
            R.drawable.your_name_4,R.drawable.your_name_5,R.drawable.your_name_6,
            R.drawable.your_name_7,R.drawable.your_name_8,R.drawable.your_name_9,
            R.drawable.your_name_10,R.drawable.your_name_11,R.drawable.your_name_12,
            R.drawable.your_name_13,R.drawable.your_name_14,R.drawable.your_name_15
            ,R.drawable.your_name_16,R.drawable.your_name_17)
        val aotList=arrayListOf(R.drawable.aot,R.drawable.aot2,R.drawable.aot3,
            R.drawable.aot4,R.drawable.aot5,R.drawable.aot6,R.drawable.aot7,
            R.drawable.aot8,R.drawable.aot9)
        val narutoList= arrayListOf(R.drawable.naruto,R.drawable.naruto2,R.drawable.naruto3,
            R.drawable.naruto4,R.drawable.naruto5,R.drawable.naruto6,R.drawable.naruto7,
            R.drawable.naruto8,R.drawable.naruto9,R.drawable.naruto10,R.drawable.naruto11,
            R.drawable.naruto12,R.drawable.naruto13,R.drawable.naruto14,R.drawable.naruto15,
            R.drawable.naruto16,R.drawable.naruto17,R.drawable.naruto18)

        val imageList= ArrayList(demonSlayerList+yourNameList+aotList+narutoList)
        imageList.shuffle()
        val randomImages=ArrayList(imageList.take((6..8).random()))
        val popularImageList2=randomImages.toCollection(ArrayList())
        itemList.add(ViewDomain.PopularView(popularImageList2))

        itemList.add(ViewDomain.VerticalView("Demon Slayer"))

            var limitedList=ArrayList(demonSlayerList.take(6))
        val imageList2=limitedList.toCollection(ArrayList())
        itemList.add(ViewDomain.HorizontalView(imageList2))
        itemList.add(ViewDomain.VerticalView("Your Name"))
        limitedList=ArrayList(yourNameList.take(6))
        val imageList3=limitedList.toCollection(ArrayList())
        itemList.add(ViewDomain.HorizontalView(imageList3))
        itemList.add(ViewDomain.VerticalView("Attack On Titan"))
        limitedList=ArrayList(aotList.take(6))
        val imageList4=limitedList.toCollection(ArrayList())
        itemList.add(ViewDomain.HorizontalView(imageList4))
        itemList.add(ViewDomain.VerticalView("Naruto"))
        limitedList=ArrayList(narutoList.take(6))
        val imageList5=limitedList.toCollection(ArrayList())
        itemList.add(ViewDomain.HorizontalView(imageList5))
        val adapter= Adapter(itemList){ categoryName->
            onCategoryClicked(categoryName)
        }
        binding.recycler.adapter=adapter
        binding.recycler.layoutManager=LinearLayoutManager(this)
    }
    private fun onCategoryClicked(categoryName:String){
        val intent= Intent(this,RecyclerAct::class.java)
        intent.putExtra("Category_Name",categoryName)
        startActivity(intent)
    }
}