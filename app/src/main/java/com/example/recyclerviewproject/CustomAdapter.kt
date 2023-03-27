package com.example.recyclerviewproject

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewproject.databinding.ItemViewBinding

// 3. customAdapter를 생성한다.
class CustomAdapter(val dataList: MutableList<DataList>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {

    // 6. 아이템뷰를 객체화시킨다.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val itemViewBinding: ItemViewBinding =
            ItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CustomViewHolder(itemViewBinding)
    }

    // 5. 사이즈 설정
    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val itemViewBinding = holder.itemViewBinding
        itemViewBinding.tvName.text = dataList.get(position).tvName
        itemViewBinding.tvAge.text = dataList.get(position).tvAge
        itemViewBinding.tvEmail.text = dataList.get(position).tvEmail
        itemViewBinding.ivMan.setImageResource(dataList.get(position).ivMan)
        itemViewBinding.root.setOnClickListener {
            Toast.makeText(
                itemViewBinding.root.context,
                "${itemViewBinding.tvName.text}",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    // 4. 뷰홀더 내부클래스를 만든다.
    class CustomViewHolder(val itemViewBinding: ItemViewBinding) :
        RecyclerView.ViewHolder(itemViewBinding.root)
}