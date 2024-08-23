package com.example.newsapp.view

import AllNewsAdapter
import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapp.data.DataItem
import com.example.newsapp.viewmodel.MainViewModel
import com.example.newsapp.databinding.FragmentAllNewsBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AllNewsFragment : Fragment() {
    private var _vb: FragmentAllNewsBinding? = null
    private val vb get() = _vb!!
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
        _vb = FragmentAllNewsBinding.inflate(inflater, container, false)
        return vb.root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = vb.root.findNavController()
        vb.btnBack.setOnClickListener { navController.navigateUp() }


        //set up


        vm.allNews.observe(viewLifecycleOwner) { allNews ->
            vb.rvAllNews.apply {
                adapter = AllNewsAdapter(allNews)
                layoutManager = LinearLayoutManager(context)
            }
            allNews.forEach { Log.d("STLog", it.title) }
        }
    }

    override fun onDestroyView() {
        _vb = null
        super.onDestroyView()
    }
}