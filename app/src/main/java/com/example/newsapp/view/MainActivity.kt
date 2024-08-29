/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newsapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var vb:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb.root)
    }
}