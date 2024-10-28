/*
 * Copyright (c) 2024. Seth Torralba
 */

package com.example.newsapp.ui.screen

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material.icons.filled.Computer
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.newsapp.ui.components.CustomButton
import com.example.newsapp.ui.navigation.Screen
import com.example.newsapp.viewmodel.PhotosViewModel

@Composable
@OptIn(ExperimentalGlideComposeApi::class)
fun PhotoDetailsScreen(vm: PhotosViewModel, onNavigate: (String) -> Unit = {}) {
    val photo = vm.photo.observeAsState().value

    Log.d("STLog", "PhotoDetailsScreen: $photo")


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Photo Details Screen",
            fontSize = 30.sp,
            color = Color.DarkGray,
            textAlign = TextAlign.Center
        )

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .height(600.dp)
        ) {
            GlideImage(
                modifier = Modifier.fillMaxSize(),
                model = photo!!.src.large,
                contentDescription = "Photo",
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.height(10.dp))


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                imageVector = Icons.Default.Camera,
                contentDescription = "Photographer Name"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = photo!!.photographer, fontSize = 16.sp, color = Color.DarkGray)
        }


        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Image(
                imageVector = Icons.Default.Computer,
                contentDescription = "Photographer Name"
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = photo!!.photographer_url,
                fontSize = 16.sp, color = Color.DarkGray
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomButton(title = "Back") {
            onNavigate(Screen.PhotosScreen.route)
        }
        Spacer(modifier = Modifier.height(16.dp))

    }
}