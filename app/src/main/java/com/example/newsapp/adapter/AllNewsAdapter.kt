///*
// * Copyright (c) 2024. Seth Torralba
// */
//
//import android.content.Context
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.lifecycle.MutableLiveData
//import androidx.recyclerview.widget.RecyclerView
//import com.bumptech.glide.Glide
//import com.example.newsapp.data.DataItem
//import com.example.newsapp.databinding.ItemAllNewsBinding
//
//class AllNewsAdapter(val data: List<DataItem>, val context: Context, val onItemClicked: (String) -> Unit) : RecyclerView.Adapter<AllNewsAdapter.ViewHolder>() {
//    val onClick = MutableLiveData<String>()
//
//    //creating view holder
//    inner class ViewHolder(val binding: ItemAllNewsBinding) : RecyclerView.ViewHolder(binding.root)
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
//            = ViewHolder(ItemAllNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//
//    override fun getItemCount() = data.size
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.binding.tvTitle.text = data[position].title
//
//        //Call Back to communicate back to Fragment
//        holder.binding.root.setOnClickListener {
//            onItemClicked(data[position].url)
//        }
//
//        if(data[position].imageUrl == null) holder.binding.imageView.visibility = View.GONE
//        else {
//            Glide.with(context)
//                .load(data[position].imageUrl)
//                .centerCrop()
//                .into(holder.binding.imageView)
//        }
//
//
//
//    }
//
//
//}