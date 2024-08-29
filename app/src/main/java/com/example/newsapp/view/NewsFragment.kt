/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.newsapp.R
import com.example.newsapp.databinding.FragmentNewsBinding

class NewsFragment : Fragment() {
    private var _vb: FragmentNewsBinding? = null
    private val vb get() = _vb!!
    private lateinit var navController: NavController
    private val args: NewsFragmentArgs by navArgs()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _vb = FragmentNewsBinding.inflate(inflater, container, false)
        return vb.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = vb.root.findNavController()
        vb.btnBack.setOnClickListener { navController.navigateUp() }

        vb.wvNews.apply {
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    vb.includeSpinner.root.visibility = View.GONE
                }
            }
            loadUrl(args.url!!)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _vb = null
    }


}