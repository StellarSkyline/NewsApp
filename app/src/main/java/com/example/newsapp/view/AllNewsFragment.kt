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
import com.example.newsapp.viewmodel.AllNewsViewModel
import com.example.newsapp.databinding.FragmentAllNewsBinding


class AllNewsFragment : Fragment() {
    private var _vb: FragmentAllNewsBinding? = null
    private val vb get() = _vb!!
    private lateinit var vm: AllNewsViewModel
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vm = ViewModelProvider(this)[AllNewsViewModel::class.java]
        //Network call
        vm.getAllNews()

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



        vm.allNews.observe(viewLifecycleOwner) { allNews ->
            vb.spinner.root.visibility = View.GONE
            vb.rvAllNews.apply {
                adapter = AllNewsAdapter(allNews,requireContext(), ::onItemClicked)
                layoutManager = LinearLayoutManager(context)
            }
            allNews.forEach { Log.d("STLog", it.title) }
        }

    }

    private fun onItemClicked(url:String) {
        Log.d("STLog", "url on AllNews Adapter $url")
        val direction = AllNewsFragmentDirections.actionAllNewsFragmentToNewsFragment(url)
        navController.navigate(direction)

    }

    override fun onDestroyView() {
        _vb = null
        super.onDestroyView()
    }


}

/**
 * override fun onClick(v: View) {
 *    val amountTv: EditText = view!!.findViewById(R.id.editTextAmount)
 *    val amount = amountTv.text.toString().toInt()
 *    val action = SpecifyAmountFragmentDirections.confirmationAction(amount)
 *    v.findNavController().navigate(action)
 * }
 */