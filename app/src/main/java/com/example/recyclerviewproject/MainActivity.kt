package com.example.recyclerviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var dataList: MutableList<DataList>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 1. mutable 데이터 리스트를 만들어서 adapter에 제공공
        dataList = mutableListOf<DataList>()
        for(i in 1..30){
            if(i % 2 ==0){
                dataList.add(DataList("홍길동${i}","${20+i}세","rlawn${i}@gmail.com",R.drawable.user))
            } else {
                dataList.add(DataList("홍길여${i}","${20+i}세","rlawn${i}@gmail.com",R.drawable.woman))
            }
        }
        // 2. customAdapter(dataList)
        val customAdapter = CustomAdapter(dataList)

        // 3. 리사이클러뷰에 어답터를 적용시킴
        binding.recyclerView.adapter = customAdapter
        // 4. LayoutManager를 통해서 리사이클러뷰에 방향을 설정
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.recyclerView.layoutManager = layoutManager
    }
}