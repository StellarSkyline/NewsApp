package com.example.newsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var vb:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
    }
}