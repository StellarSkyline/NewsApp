package com.example.newsapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.ViewModel.MainViewModel
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var vb:ActivityMainBinding
    lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
        vm = ViewModelProvider(this)[MainViewModel::class.java]

        //API Network Call
        vm.getAllNews()

        //User Observe
        vm.allNews.observe(this) { dataList ->
            dataList.forEach { data ->
                Log.d("STLog", data.title)
            }
        }

    }
}