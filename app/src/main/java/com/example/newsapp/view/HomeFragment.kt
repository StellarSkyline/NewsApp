/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.newsapp.R
import com.example.newsapp.viewmodel.AllNewsViewModel
import com.example.newsapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _vb: FragmentHomeBinding? = null
    private val vb get() = _vb!!
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // View Binding Inflate
        _vb = FragmentHomeBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = vb.root.findNavController()
        vb.btnNext.setOnClickListener {
            navController.navigate(R.id.action_homeFragment_to_allNewsFragment)
        }
    }

    override fun onDestroyView() {
        _vb = null
        super.onDestroyView()
    }

}