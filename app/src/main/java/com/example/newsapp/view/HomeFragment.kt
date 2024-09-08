/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import com.example.newsapp.R
import com.example.newsapp.viewmodel.AllNewsViewModel
import com.example.newsapp.databinding.FragmentHomeBinding
import kotlinx.coroutines.FlowPreview

class HomeFragment : Fragment() {
//    private var _vb: FragmentHomeBinding? = null
//    private val vb get() = _vb!!
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // View Binding Inflate
//        _vb = FragmentHomeBinding.inflate(inflater, container, false)
//        return vb.root

        val x = requireContext().resources.getResourceName(R.navigation.nav_graph)

        return ComposeView(requireContext()).apply {
            setContent {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //navController = vb.root.findNavController()
//        vb.btnNext.setOnClickListener {
//            navController.navigate(R.id.action_homeFragment_to_allNewsFragment)
//        }
    }

}

@Preview
@Composable
fun HomeFragmentPreview() {
    val constraints =  ConstraintSet {
        val tv_title = createRefFor("tv_title")
        val btn_next = createRefFor("btn_next")

        constrain(tv_title) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            bottom.linkTo(parent.bottom)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

        constrain(btn_next) {
            top.linkTo(tv_title.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent


        }
    }

    ConstraintLayout(
        constraintSet = constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)) {

        titleText(
            title = "Home Fragment Title",
            modifier = Modifier.layoutId("tv_title"))

        button(
            text = "All News Fragment",
            modifier = Modifier
                .layoutId("btn_next")
                .padding(top = 32.dp)

        )
    }


}




//@Preview
//@Composable
//fun HomeFragmentPreview() {
//   Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//
//       Column(
//           modifier = Modifier
//               .padding(innerPadding)
//               .fillMaxSize(),
//           verticalArrangement = Arrangement.Center,
//           horizontalAlignment = Alignment.CenterHorizontally
//       ) {
//
//           titleText(title = "Home Fragment Title", modifier = Modifier )
//           button("All News Fragment", modifier = Modifier.padding(top = 40.dp))
//
//       }
//
//   }
//
//}

@Composable
fun titleText(title:String, modifier: Modifier) {
    Text(
        text = title,
        fontSize = 30.sp,
        color = Color.Blue,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
fun button(text:String, modifier:Modifier) {
    Button(
        modifier = modifier,
        onClick = {
            //TODO Implement nav graph jump

        },

    ) {
        Text(text = text,
            fontSize = 10.sp
        )

    }
}