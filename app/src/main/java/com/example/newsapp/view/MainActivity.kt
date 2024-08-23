package com.example.newsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.newsapp.databinding.ActivityMainBinding
import com.example.newsapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    lateinit var vb:ActivityMainBinding
    lateinit var vm: MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
        setContentView(vb.root)

    }
}