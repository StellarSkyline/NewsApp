package com.example.newsapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.newsapp.viewmodel.MainViewModel
import com.example.newsapp.databinding.FragmentAllNewsBinding


class AllNewsFragment : Fragment() {
    private lateinit var vb:FragmentAllNewsBinding
    private lateinit var vm: MainViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[MainViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        vb = FragmentAllNewsBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = vb.root.findNavController()
        vb.btnBack.setOnClickListener { navController.navigateUp() }

        //Test Code to make Sure API Call Works
//        vm.getAllNews()
//        vm.allNews.observe(viewLifecycleOwner) { dataList ->
//            dataList.forEach { data ->
//                Log.d("STLog", data.title)
//            }
//        }
    }
}