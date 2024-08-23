package com.example.newsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.viewmodel.MainViewModel
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var vb:ActivityMainBinding
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
        //Test Code to make Sure API Call Works
//        vm.getAllNews()
//        vm.allNews.observe(this) { dataList ->
//            dataList.forEach { data ->
//                Log.d("STLog", data.title)
//            }
//        }

    }
}